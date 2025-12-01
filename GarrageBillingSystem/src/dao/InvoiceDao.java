package dao;

import config.DbConfig;
import entity.Invoice;
import entity.InvoiceLine;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class InvoiceDao {

    //Checking customer has invoice or not-->
    public boolean customerHasInvoice(int customerId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM invoices WHERE customer_id = ?";
        try (Connection conn = DbConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, customerId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt(1) > 0;
            }
        }
        return false;
    }

    // create invoice + lines in a transaction, returns invoice id
    // addBatch() → add all lines
    // executeBatch() → insert all lines at once (fast)
    // Scenerio like the customer alredy exist and i came with new services and new invoice line so invoice contains alreday a customerid and invoice id and we have to addd onli=y invoice for that customer how we can do this?
    public int createInvoice(int customerId, int vehicleId, List<InvoiceLine> lines) throws SQLException {
        String insertInvoice = "INSERT INTO invoices (customer_id, vehicle_id) VALUES (?, ?)";
        String insertLine = "INSERT INTO invoice_services (invoice_id, service_id, qty, subtotal) VALUES (?, ?, ?, ?)";
        try (Connection conn = DbConfig.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement psInv = conn.prepareStatement(insertInvoice, Statement.RETURN_GENERATED_KEYS)) {
                psInv.setInt(1, customerId);
                psInv.setInt(2, vehicleId);
                psInv.executeUpdate();
                int invoiceId;
                try (ResultSet rs = psInv.getGeneratedKeys()) {
                    if (rs.next()) invoiceId = rs.getInt(1);
                    else throw new SQLException("Failed to create invoice");
                }
                try (PreparedStatement psLine = conn.prepareStatement(insertLine, Statement.RETURN_GENERATED_KEYS)) {
                    for (InvoiceLine line : lines) {
                        psLine.setInt(1, invoiceId);
                        psLine.setInt(2, line.getServiceId());
                        psLine.setInt(3, line.getQty());
                        psLine.setBigDecimal(4, line.getSubtotal());
                        psLine.addBatch();
                    }
                    psLine.executeBatch();
                }
                conn.commit();
                return invoiceId;
            } catch (SQLException ex) {
                conn.rollback();
                throw ex;
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }

    //    read all invoices with their lines-->
    //    Get all invoices from the invoices table
    //    For each invoice, get all invoice_services rows
    //    Attach all lines into the invoice object
    //    Put the invoice in a list
    //    Return the list
    public List<Invoice> getAllInvoicesWithLines() throws SQLException {
        List<Invoice> result = new ArrayList<>();
        String invSql = "SELECT id, customer_id, vehicle_id, created_at FROM invoices";
        String lineSql = "SELECT id, invoice_id, service_id, qty, subtotal FROM invoice_services WHERE invoice_id = ?";
        try (Connection conn = DbConfig.getConnection();
             Statement st = conn.createStatement();
             ResultSet rsInv = st.executeQuery(invSql)) {
            while (rsInv.next()) {
                int invId = rsInv.getInt("id");
                Invoice inv = new Invoice(invId, rsInv.getInt("customer_id"), rsInv.getInt("vehicle_id"),
                        rsInv.getTimestamp("created_at").toLocalDateTime());
                try (PreparedStatement psLine = conn.prepareStatement(lineSql)) {
                    psLine.setInt(1, invId);
                    try (ResultSet rsLine = psLine.executeQuery()) {
                        while (rsLine.next()) {
                            InvoiceLine line = new InvoiceLine(
                                    rsLine.getInt("id"),
                                    rsLine.getInt("invoice_id"),
                                    rsLine.getInt("service_id"),
                                    rsLine.getInt("qty"),
                                    rsLine.getBigDecimal("subtotal")
                            );
                            inv.getLines().add(line);
                        }
                    }
                }
                result.add(inv);
            }
        }
        return result;
    }


    //List all invoices for customer using invoice id-->
    public Optional<Invoice> findByIdWithLines(int invoiceId) throws SQLException {
        String invSql = "SELECT id, customer_id, vehicle_id, created_at FROM invoices WHERE id = ?";
        String lineSql = "SELECT id, invoice_id, service_id, qty, subtotal FROM invoice_services WHERE invoice_id = ?";
        try (Connection conn = DbConfig.getConnection();
             PreparedStatement psInv = conn.prepareStatement(invSql)) {
            psInv.setInt(1, invoiceId);
            try (ResultSet rsInv = psInv.executeQuery()) {
                if (rsInv.next()) {
                    Invoice inv = new Invoice(invIdFrom(rsInv), rsInv.getInt("customer_id"), rsInv.getInt("vehicle_id"),
                            rsInv.getTimestamp("created_at").toLocalDateTime());
                    try (PreparedStatement psLine = conn.prepareStatement(lineSql)) {
                        psLine.setInt(1, inv.getId());
                        try (ResultSet rsLine = psLine.executeQuery()) {
                            while (rsLine.next()) {
                                InvoiceLine line = new InvoiceLine(
                                        rsLine.getInt("id"),
                                        rsLine.getInt("invoice_id"),
                                        rsLine.getInt("service_id"),
                                        rsLine.getInt("qty"),
                                        rsLine.getBigDecimal("subtotal")
                                );
                                inv.getLines().add(line);
                            }
                        }
                    }
                    return Optional.of(inv);
                }
            }
        }
        return Optional.empty();
    }

    //Return id-->
    private int invIdFrom(ResultSet rs) throws SQLException {
        return rs.getInt("id");
    }
}

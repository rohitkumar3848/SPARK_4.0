package Service;
import dao.InvoiceDao;
import entity.InvoiceLine;
import entity.ServiceItem;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BillingService {
    //create invoice and serviceitem objects--
    private final InvoiceDao invoiceDao = new InvoiceDao();
    private final ServiceItemService serviceItemService = new ServiceItemService();

    // create invoice
    public void createInvoice(int customerId, int vehicleId, List<Integer> serviceIds, List<Integer> quantities) throws SQLException {
        //first check customer has invoice if exist then return from here
        if (invoiceDao.customerHasInvoice(customerId)) {
            System.out.println("Error: This customer already has an invoice. (Policy: one invoice per customer)");
            return;
        }

        //Add invoice lines for all services ids--
        List<InvoiceLine> lines = new ArrayList<>();
        for (int i = 0; i < serviceIds.size(); i++) {
            int sid = serviceIds.get(i);
            int qty = (quantities != null && quantities.size() > i) ? quantities.get(i) : 1;
            Optional<ServiceItem> sOpt = serviceItemService.findById(sid);
            if (sOpt.isEmpty()) {
                System.out.println("Service id " + sid + " not found. Skipping.");
                continue;
            }
            ServiceItem s = sOpt.get();
            BigDecimal subtotal = s.getPrice().multiply(BigDecimal.valueOf(qty));
            lines.add(new InvoiceLine(sid, qty, subtotal));
        }
        if (lines.isEmpty()) {
            System.out.println("No valid services selected. Invoice not created.");
            return;
        }
        //after this create invoice call for all services--
        int invoiceId = invoiceDao.createInvoice(customerId, vehicleId, lines);
        System.out.println("Invoice created successfully. ID = " + invoiceId);
    }


    //list out all invoices-->
    public void showAllInvoices() throws SQLException {
        List<entity.Invoice> invoices = invoiceDao.getAllInvoicesWithLines();
        for (entity.Invoice inv : invoices) {
            System.out.println("-------------------------------------------------");
            System.out.println("Invoice ID: " + inv.getId() + " | Customer ID: " + inv.getCustomerId() + " | Vehicle ID: " + inv.getVehicleId() + " | Date: " + inv.getCreatedAt());
            BigDecimal total = BigDecimal.ZERO;
            for (InvoiceLine line : inv.getLines()) {
                Optional<ServiceItem> s = serviceItemService.findById(line.getServiceId());
                String sname = s.map(ServiceItem::getName).orElse("Unknown service");
                System.out.println(String.format(" - %s (serviceId=%d) x %d -> %s", sname, line.getServiceId(), line.getQty(), line.getSubtotal().toPlainString()));
                total = total.add(line.getSubtotal());
            }
            System.out.println("Total = " + total.toPlainString());
            System.out.println("-------------------------------------------------");
        }
    }

}

package dao;

import config.DbConfig;
import entity.ServiceItem;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceDao {

    //Add service-->
    public void add(ServiceItem s) throws SQLException {
        String sql = "INSERT INTO services (name, description, price) VALUES (?, ?, ?)";
        try (Connection conn = DbConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getDescription());
            ps.setBigDecimal(3, s.getPrice());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) s.setId(rs.getInt(1));
            }
        }
    }

    // Find all services-->
    public List<ServiceItem> findAll() throws SQLException {
        List<ServiceItem> list = new ArrayList<>();
        String sql = "SELECT id, name, description, price FROM services";
        try (Connection conn = DbConfig.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new ServiceItem(rs.getInt("id"), rs.getString("name"),
                        rs.getString("description"), rs.getBigDecimal("price")));
            }
        }
        return list;
    }

    //Find services using id-->
    public Optional<ServiceItem> findById(int id) throws SQLException {
        String sql = "SELECT id, name, description, price FROM services WHERE id = ?";
        try (Connection conn = DbConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return Optional.of(new ServiceItem(rs.getInt("id"),
                        rs.getString("name"), rs.getString("description"), rs.getBigDecimal("price")));
            }
        }
        return Optional.empty();
    }

}

package dao;

import config.DbConfig;
import entity.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VehicleDao {

    //Add Vehicle-->
    public  void add(Vehicle v) throws SQLException{
        String sql = "INSERT INTO vehicles (customer_id, vechicle_number, model) VALUES (?, ?, ?)";
        try (Connection conn = DbConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, v.getCustomerId());
            ps.setString(2, v.getVehicleNumber());
            ps.setString(3, v.getModel());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) v.setId(rs.getInt(1));
            }
        }
    }

    //Find Vehicle using customer id-->
    public List<Vehicle> findByCustomerId(int customerId) throws SQLException {
        List<Vehicle> out = new ArrayList<>();
        String sql = "SELECT id, customer_id, vechicle_number, model FROM vehicles WHERE customer_id = ?";
        try (Connection conn = DbConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, customerId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    out.add(new Vehicle(rs.getInt("id"), rs.getInt("customer_id"),
                            rs.getString("vechicle_number"), rs.getString("model")));
                }
            }
        }
        return out;
    }

    //Find Vehicle using id-->
    public Optional<Vehicle> findById(int id) throws SQLException {
        String sql = "SELECT id, customer_id, vechicle_number, model FROM vehicles WHERE id = ?";
        try (Connection conn = DbConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return Optional.of(new Vehicle(rs.getInt("id"), rs.getInt("customer_id"),
                        rs.getString("vechicle_number"), rs.getString("model")));
            }
        }
        return Optional.empty();
    }

}

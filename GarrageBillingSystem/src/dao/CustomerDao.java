package dao;

import config.DbConfig;
import entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDao {

    //1---> Add customer--
    public void  add(Customer c) throws SQLException {
        String sql="insert into customers(name,phone) values(?,?)";
        try(Connection conn= DbConfig.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
            ps.setString(1,c.getName());
            ps.setString(2,c.getPhone());
            ps.executeUpdate();
            try(ResultSet rs=ps.getGeneratedKeys()){
                if(rs.next()){
                    c.setId(rs.getInt(1));
                }
            }
        }
    }

    //Find customer using phone-->
    public Optional<Customer> findByPhone(String phone) throws SQLException {
        String sql = "SELECT id, name, phone FROM customers WHERE phone = ?";
        try (Connection conn = DbConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, phone);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return Optional.of(new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("phone")));
            }
        }
        return Optional.empty();
    }

    //Find all customers -->
    public List<Customer> findAll() throws SQLException {
        List<Customer> out = new ArrayList<>();
        String sql = "SELECT id, name, phone FROM customers";
        try (Connection conn = DbConfig.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                out.add(new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("phone")));
            }
        }
        return out;
    }

    //Find customer using id-->
    public Optional<Customer> findById(int id) throws SQLException {
        String sql = "SELECT id, name, phone FROM customers WHERE id = ?";
        try (Connection conn = DbConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return Optional.of(new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("phone")));
            }
        }
        return Optional.empty();
    }

}

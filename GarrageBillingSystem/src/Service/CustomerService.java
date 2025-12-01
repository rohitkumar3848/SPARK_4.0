package Service;

import dao.CustomerDao;
import entity.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CustomerService {
    //Create customer object
    private final CustomerDao dao = new CustomerDao();

    //add customer
    public Customer addCustomer(Customer c) throws SQLException {
        dao.add(c);
        return c;
    }

    //find customer by phone
    public Optional<Customer> findByPhone(String phone) throws SQLException {
        return dao.findByPhone(phone);
    }

    //list all customer
    public List<Customer> getAll() throws SQLException {
        return dao.findAll();
    }

    //find customer by id
    public Optional<Customer> findById(int id) throws SQLException {
        return dao.findById(id);
    }
}

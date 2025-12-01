package Service;

import dao.VehicleDao;
import entity.Vehicle;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class VehicleService {

    // create vehicle object
    private final VehicleDao dao = new VehicleDao();

    //add vehicle
    public Vehicle addVehicle(Vehicle v) throws SQLException {
        dao.add(v);
        return v;
    }

    //list vehicle using customerId
    public List<Vehicle> findByCustomerId(int customerId) throws SQLException {
        return dao.findByCustomerId(customerId);
    }

    //list vehicle using its own id
    public Optional<Vehicle> findById(int id) throws SQLException {
        return dao.findById(id);
    }
}

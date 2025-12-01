package Service;
import dao.ServiceDao;
import entity.ServiceItem;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ServiceItemService {
    //create service object
    private final ServiceDao dao = new ServiceDao();

    //list all service  item
    public List<ServiceItem> listServices() throws SQLException {
        return dao.findAll();
    }

    //list services using id
    public Optional<ServiceItem> findById(int id) throws SQLException {
        return dao.findById(id);
    }

    //add services
    public ServiceItem addService(ServiceItem s) throws SQLException {
        dao.add(s);
        return s;
    }
}

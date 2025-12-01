import entity.Customer;
import entity.ServiceItem;
import entity.Vehicle;
import Service.CustomerService;
import Service.ServiceItemService;
import Service.BillingService;
import Service.VehicleService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;



public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CustomerService customerService = new CustomerService();
        VehicleService vehicleService = new VehicleService();
        ServiceItemService serviceItemService = new ServiceItemService();
        BillingService billingService = new BillingService();

        System.out.println("=== Garage Billing System ===");
        while (true) {

            try {
                System.out.println("\n1. Add Customer\n2. List Customers\n3. Add Vehicle for Customer\n4. List Vehicles for Customer\n5. List Services\n6. Add Service (catalog)\n7. Create Invoice\n8. Show All Invoices\n9. Exit");
                System.out.print("Choice: ");

                int ch = Integer.parseInt(sc.nextLine().trim());
                switch (ch) {
                    //Add Customer-->
                    case 1 -> {
                        System.out.print("Customer name: ");
                        String name = sc.nextLine().trim();
                        System.out.print("Phone: ");
                        String phone = sc.nextLine().trim();
                        Customer c = new Customer(name, phone);
                        customerService.addCustomer(c);
                        System.out.println("Added: " + c);
                    }
                    //Show Customer-->
                    case 2 -> {
                        System.out.println("Customers:");
                        for (Customer c : customerService.getAll()) System.out.println(c);
                    }
                    //Add vehicle-->
                    case 3 -> {
                        System.out.print("Customer ID: ");
                        int cid = Integer.parseInt(sc.nextLine().trim());
                        Optional<Customer> cOpt = customerService.findById(cid);
                        if (cOpt.isEmpty()) {
                            System.out.println("Customer not found.");
                            break;
                        }
                        System.out.print("Vehicle number: ");
                        String vnum = sc.nextLine().trim();
                        System.out.print("Model: ");
                        String model = sc.nextLine().trim();
                        Vehicle v = new Vehicle(cid, vnum, model);
                        vehicleService.addVehicle(v);
                        System.out.println("Added vehicle: " + v);
                    }
                    // List customer vehicles-->
                    case 4 -> {
                        System.out.print("Customer ID: ");
                        int cid = Integer.parseInt(sc.nextLine().trim());
                        for (Vehicle v : vehicleService.findByCustomerId(cid)) System.out.println(v);
                    }
                    //List out all services-->
                    case 5 -> {
                        System.out.println("Service Catalog:");
                        for (ServiceItem s : serviceItemService.listServices()) System.out.println(s);
                    }
                    //Add service
                    case 6 -> {
                        System.out.print("Service name: ");
                        String sname = sc.nextLine().trim();
                        System.out.print("Description: ");
                        String desc = sc.nextLine().trim();
                        System.out.print("Price: ");
                        BigDecimal price = new BigDecimal(sc.nextLine().trim());
                        ServiceItem si = new ServiceItem(sname, desc, price);
                        serviceItemService.addService(si);
                        System.out.println("Added service: " + si);
                    }
                    //create Invoice--->
                    case 7 -> {
                        System.out.print("Customer ID: ");
                        int cid = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Vehicle ID: ");
                        int vid = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("How many different services to add? ");
                        int n = Integer.parseInt(sc.nextLine().trim());
                        List<Integer> sids = new ArrayList<>();
                        List<Integer> qtys = new ArrayList<>();
                        for (int i = 0; i < n; i++) {
                            System.out.print("Service ID: ");
                            sids.add(Integer.parseInt(sc.nextLine().trim()));
                            System.out.print("Quantity: ");
                            qtys.add(Integer.parseInt(sc.nextLine().trim()));
                        }
                        billingService.createInvoice(cid, vid, sids, qtys);
                    }
                    //show all invoices-->
                    case 8 -> billingService.showAllInvoices();
                    //for exiting-->
                    case 9 -> {
                        System.out.println("Exiting.");
                        System.exit(0);
                    }
                    //Invalid choice-->
                    default -> System.out.println("Invalid choice.");
                }
            } catch (SQLException e) {
                System.out.println("DB Error: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

}

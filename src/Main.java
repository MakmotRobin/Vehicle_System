import java.util.ArrayList;
import java.util.LinkedList;

interface Vehicle {
    String getLicensePlate();
    String getVehicleType();
    double getRentalPricePerDay();
    void printVehicleDetails();
    void printRentedBy();
    void rentVehicle(Customer customer) throws Exception;
    void returnVehicle(Customer customer) throws Exception;
    boolean isRented(); // New method to check if the vehicle is rented
    double calculateTotalRentalPrice(int days); // New method to calculate total rental price
    void addRentalHistory(Customer customer); // New method to add to rental history
}

class Customer {
    private String name;
    private String contactNumber;

    public Customer(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}

// Car implementation of the Vehicle
abstract class Cari implements Vehicle {
    protected String licensePlate;
    protected String vehicleType;
    protected double rentalPricePerDay;
    protected ArrayList<Customer> rentedBy;
    protected LinkedList<Customer> rentalHistory; // To track rental history
    protected int numberOfDoors;
    protected String transmissionType;

    public Cari(String licensePlate, String vehicleType, double rentalPricePerDay, int numberOfDoors, String transmissionType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.rentalPricePerDay = rentalPricePerDay;
        this.rentedBy = new ArrayList<>();
        this.rentalHistory = new LinkedList<>();
        this.numberOfDoors = numberOfDoors;
        this.transmissionType = transmissionType;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String getVehicleType() {
        return vehicleType;
    }

    @Override
    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    @Override
    public void printVehicleDetails() {
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Rental Price Per Day: $" + rentalPricePerDay);
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Transmission Type: " + transmissionType);
    }

    @Override
    public void printRentedBy() {
        if (rentedBy.isEmpty()) {
            System.out.println("This vehicle is currently not rented.");
        } else {
            System.out.println("Rented by:");
            for (Customer customer : rentedBy) {
                System.out.println("- " + customer.getName());
            }
        }
    }

    @Override
    public boolean isRented() {
        return !rentedBy.isEmpty(); // Returns true if rented
    }

    @Override
    public double calculateTotalRentalPrice(int days) {
        return rentalPricePerDay * days; // Calculate total rental price
    }

    @Override
    public void rentVehicle(Customer customer) throws Exception {
        if (rentedBy.isEmpty()) {
            rentedBy.add(customer);
            addRentalHistory(customer); // Add to rental history
            System.out.println("Vehicle rented successfully to " + customer.getName());
        } else {
            throw new Exception("This vehicle is already rented.");
        }
    }

    @Override
    public void returnVehicle(Customer customer) throws Exception {
        if (rentedBy.contains(customer)) {
            rentedBy.remove(customer);
            System.out.println("Vehicle returned successfully by " + customer.getName());
        } else {
            throw new Exception("This customer has not rented this vehicle.");
        }
    }

    @Override
    public void addRentalHistory(Customer customer) {
        if (rentalHistory.size() == 5) {
            rentalHistory.removeFirst(); // Remove the oldest rental if we have 5
        }
        rentalHistory.add(customer); // Add the new rental
    }
}

// Motorcycle implementation of Vehicle
abstract class Motorcycle implements Vehicle {
    protected String licensePlate;
    protected String vehicleType;
    protected double rentalPricePerDay;
    protected ArrayList<Customer> rentedBy;
    protected LinkedList<Customer> rentalHistory; // To track rental history
    protected int engineCapacity;

    public Motorcycle(String licensePlate, String vehicleType, double rentalPricePerDay, int engineCapacity) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.rentalPricePerDay = rentalPricePerDay;
        this.rentedBy = new ArrayList<>();
        this.rentalHistory = new LinkedList<>();
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String getVehicleType() {
        return vehicleType;
    }

    @Override
    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    @Override
    public void printVehicleDetails() {
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Rental Price Per Day: $" + rentalPricePerDay);
        System.out.println("Engine Capacity: " + engineCapacity);
    }

    @Override
    public void printRentedBy() {
        if (rentedBy.isEmpty()) {
            System.out.println("This vehicle is not rented currently.");
        } else {
            System.out.println("Rented by:");
            for (Customer customer : rentedBy) {
                System.out.println("- " + customer.getName());
            }
        }
    }

    @Override
    public boolean isRented() {
        return !rentedBy.isEmpty(); // Returns true if rented
    }

    @Override
    public double calculateTotalRentalPrice(int days) {
        return rentalPricePerDay * days; // Calculate total rental price
    }

    @Override
    public void rentVehicle(Customer customer) throws Exception {
        if (rentedBy.isEmpty()) {
            rentedBy.add(customer);
            addRentalHistory(customer); // Add to rental history
            System.out.println("Vehicle rented successfully to " + customer.getName());
        } else {
            throw new Exception("This vehicle is already rented.");
        }
    }

    @Override
    public void returnVehicle(Customer customer) throws Exception {
        if (rentedBy.contains(customer)) {
            rentedBy.remove(customer);
            System.out.println("Vehicle returned successfully by " + customer.getName());
        } else {
            throw new Exception("This customer has not rented this vehicle.");
        }
    }

    @Override
    public void addRentalHistory(Customer customer) {
        if (rentalHistory.size() == 5) {
            rentalHistory.removeFirst(); // Remove the oldest rental if we have 5
        }
        rentalHistory.add(customer); // Add the new rental
    }
}
package carantel.com;
import java.util.ArrayList;
import java.util.List;

public class CarRentalSystem {
	private List<Car> cars;

	private List<Customer> customers;

	private List<Rental> rentals;

	public CarRentalSystem() {
		cars = new ArrayList<>();
		customers = new ArrayList<>();
		rentals = new ArrayList<>();
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
}

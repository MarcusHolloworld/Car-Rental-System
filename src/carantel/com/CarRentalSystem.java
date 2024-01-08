package carantel.com;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

	public void carRent(Car car , Customer customer , int days) {
		if (car.isAvailable()) {
			car.rent();
			rentals.add(new Rental(car , customer , days));
		} else {
			System.out.println("Car is not available right now!");
		}
	}

	public void returnCar(Car car) {
		Rental rentalToRemove = null;
		for (Rental rental : rentals) {
			if (rental.getCar() == car) {
				rentalToRemove = rental;
				break;
			}
		}

		if (rentalToRemove != null) {
			rentals.remove(rentalToRemove);
			car.carReturn();
		} else {
			System.out.println("Car was not rental.");
		}
	}

	public void menu() {
		Scanner scanner = new Scanner(System.in);

		while(true) {
			System.out.println("\nWelcome to Car rental system.\n");
			System.out.println("-----------------XX-----------------");
			System.out.println("press 1 : Rent a car.");
			System.out.println("press 2 : Return a car.");
			System.out.println("press 3 : Exit");
			System.out.print("choose an option: ");

			int choise = scanner.nextInt();
			scanner.nextLine();

			if (choise == 1) {
				System.out.println("\n==Rent a cat==\n");
				System.out.print("Enter Your name: \n");
				String customerName = scanner.nextLine();

				System.out.println("\nAvailable cars:\n");
				for (Car car : cars) {
					if (car.isAvailable() == true) {
						System.out.println(car.getCarId() + "-" + car.getBrand() + "-" + car.getModel());
					}
				}
				System.out.print("\nEnter car ID for rent: ");
				String id = scanner.nextLine();

				System.out.print("How many days you want to rent? ");
				int days = scanner.nextInt();

				Customer newCustomer = new Customer("CUS" + (customers.size() +1) , customerName);
				addCustomer(newCustomer);

				Car selectCar = null;
				for (Car car : cars) {
					if (car.getCarId().equals(id) && car.isAvailable()) {
						selectCar = car;
						break;
					}
				}

				if (selectCar != null) {
					double total_price = selectCar.rentCalculate(days);
					System.out.println("\n==Rental Information==\n");
					System.out.println("Customer ID : " + newCustomer.getCustomerId());
					System.out.println("Customer name : " + newCustomer.getName());
					System.out.println("car: " + selectCar.getBrand() + " " + selectCar.getModel());
					System.out.println("Rental days : " + days);
					System.out.println("Total price : $" + selectCar.rentCalculate(days));

					System.out.println("\nConfirm rent(Y/N): ");
					String confirm = scanner.next();

					if (confirm.equalsIgnoreCase("Y")) {
						carRent(selectCar,newCustomer,days);
						System.out.println("\nCar rented successfully");
					} else {
						System.out.println("\nrRental canceled.");
					}
				} else {
					System.out.println("Invalid car selection or car is not available for rent.");
				}
			} else if (choise ==2) {
				System.out.println("\n==Return a car==\n");
				System.out.print("Enter your car Id you want to return: ");
				String carID = scanner.nextLine();

				Car carToReturn = null;
				for (Car car : cars) {
					if (car.getCarId().equals(carID) && !car.isAvailable()) {
						carToReturn = car;
						break;
					}
				}

				if (carToReturn != null) {
					Customer customer = null;
					for (Rental rental : rentals) {
						if (rental.getCar() == carToReturn) {
							customer = rental.getCustomer();
							break;
						}
					}

					if (customer != null) {
						returnCar(carToReturn);
						System.out.println("Car return successfully by " + customer.getName());
					} else {
						System.out.println("Car was not rented or rental information is missing.");
					}
				} else {
					System.out.println("Invalid car ID or car is not rented.");
				}
			} else if (choise == 3) {
				break;
			} else{
				System.out.println("Please enter a valid option.");
			}
		}
		System.out.println("\nThank You for using car rental system.\n");
	}
}

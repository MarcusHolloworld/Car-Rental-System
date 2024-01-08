package carantel.com;

public class Main {

    public static void main(String[] args) {
	// write your code here
        CarRentalSystem carRentalSystem = new CarRentalSystem();

        Car car1 = new Car("C001" , "Cmary" , "Toyota" , 65);
	    Car car2 = new Car("C002" , "Honda" , "Accord" , 75);
	    Car car3 = new Car("C003" , "Mahindra" , "Thar" , 170);
	    Car car4 = new Car("C004" , "Mahindra" , "Bularo" , 120);
	    Car car5 = new Car("C005" , "Honda" , "Amaze" , 65);

	    carRentalSystem.addCar(car1);
	    carRentalSystem.addCar(car2);
	    carRentalSystem.addCar(car3);
	    carRentalSystem.addCar(car4);
	    carRentalSystem.addCar(car5);

	    carRentalSystem.menu();

    }
}

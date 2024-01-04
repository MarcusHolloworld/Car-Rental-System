package carantel.com;

public class Car {
	private String carId;

	private String model;

	private String brand;

	private double basePricePerDay;

	private boolean isAvailable;

	public Car(String carId , String model , String brand , double basePricePerDay) {
		this.carId = carId;
		this.model = model;
		this.brand = brand;
		this.basePricePerDay = basePricePerDay;
		this.isAvailable =  true;
	}

	public String getCarId() {
		return carId;
	}


	public String getModel() {
		return model;
	}

	public String getBrand() {
		return brand;
	}

	public double rentCalculate(int rentalDays) {
		return basePricePerDay * rentalDays;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void rent() {
		isAvailable = false;
	}

	public void carReturn() {
		isAvailable = true;
	}
}

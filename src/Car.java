// Name: Kwok Sin Man	
// Program name : Car.java
// Start data: 16-Nov-2011
// End data: 20-Dec-2011
// --------------------------------------
// |   		 Car.java (Use GUI)			|
// --------------------------------------
// | licensePlate, colour: String		|
// | isVIPCar: boolean					|
// --------------------------------------
// | toString():String					|
// | Car(String,String,boolean)			|
// | setVehicle(String,String,boolean)	|
// | getCarPlate():String				|
// | setCarPlate(String)				|
// | getColour():String					|
// | setColour(String)					|
// | isVIPCar():boolean					|
// | setVIPCar(boolean)					|
// --------------------------------------

public class Car {
	// Variable Declaration
	private String licensePlate;
	private String colour;
	private boolean isVIPCar;

	// Set the setIsVIPCar is turn or false
	public void setIsVIPCar(boolean isVIPCar) {
		this.isVIPCar = isVIPCar;
	}

	// Set the Colour of the car
	public void setColour(String colour) {
		this.colour = colour;
	}

	// Set the Plate of the car
	public void setCarPlate(String carplate) {
		this.licensePlate = carplate;
	}

	// return the Plate of the car
	public String getCarPlate() {
		return licensePlate;
	}

	// return the colour of the car
	public String getColour() {
		return colour;
	}

	// return isVIPCar is turn of false
	public boolean isVIPCar() {
		return isVIPCar;
	}

	// return the String to show the information of the car
	public String toString() {
		// TODO : Only need to rewrite the c method body of this method
		String s;
		if (isVIPCar)
			s = "VIP Car ";
		else
			s = "Car ";
		return (s + "[" + licensePlate + "] " + colour);
	}

	// construtors
	public Car(String licensePlate, String colour, boolean isVIPCar) {
		// Use the method setCarPlate to set licensePlate
		setCarPlate(licensePlate);
		// Use the method setColour to set the colour
		setColour(colour);
		// Use the method isVIPCar to set isVIPCar is true of false
		setIsVIPCar(isVIPCar);
	}

	// Set the CarPlate, Colour, and IsVIPCar
	public void setVehicle(String licensePlate, String colour, boolean isVIPCar) {
		// TODO : Only need to rewrite the method body of this method
		// Use the method setCarPlate to set licensePlate
		setCarPlate(licensePlate);
		// Use the method setColour to set the colour
		setColour(colour);
		// Use the method isVIPCar to set isVIPCar is true of false
		setIsVIPCar(isVIPCar);
	}
}
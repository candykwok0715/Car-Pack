// Name: Kwok Sin Man	
// Program name : ManageCarpark.java
// Start data: 16-Nov-2011
// End data: 20-Dec-2011
// ----------------------------------
// |  ManageCarpark.java(Use GUI)	|
// ----------------------------------
// | licensePlate, colour: String	|
// | isVIPCar: boolean				|
// ----------------------------------
// | createSampleData(Carpark)		|
// | displayMenu()					|
// | getCarDetails(): Car			|
// | getCurrentTime(): Time			|
// | getUerInput(String):String		|
// | main(String[])					|
// ----------------------------------
import javax.swing.JOptionPane;
public class ManageCarpark {
	
	// the method make the getting User Input
	public static String getUserInput(String promptMsg) {
		return JOptionPane.showInputDialog(promptMsg);
	}
	  // require the user input the information of the car
	public static Car getCarDetails() {
		String licensePlate = getUserInput("Enter license plate no. :");
		// TODO : Complete the missing code
		String colour = getUserInput("Enter colour of the car :");
		boolean isVIPCar = false;
		String YesRoNoVIP = getUserInput("Is it a VIP car? (Y/N) :");
		if (YesRoNoVIP == "Y")
			isVIPCar = true;
		return new Car(licensePlate, colour, isVIPCar);
	}
	
	//require the user input the current time, the format is  (HH:MM)
	public static Time getCurrentTime() {
		String[] t = getUserInput("Enter current time (HH:MM) : ").split(":");
		return new Time(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
	}

	// the sample data will save your time to input data from the keyboard,
	// and have enough data to test the functions in the main menu
	public static void createSampleData(Carpark carpark) {
		Car car1 = new Car("AA1111", "Red", false);
		Car car2 = new Car("BB2222", "Yellow", false);
		Car car3 = new Car("CC3333", "Green", true);
		Car car4 = new Car("DD4444", "White", false);
		carpark.parkCar(car1, new Time(7, 15));
		carpark.parkCar(car2, new Time(8, 50));
		carpark.parkCar(car3, new Time(11, 40));
		carpark.parkCar(car4, new Time(23, 45));
		carpark.takeCar(1, new Time(9, 50));
	}

	  // return the string of the Menu
	public static String displayMenu() {
		return "=============================\n|      EASY-GO CARPARK SYSTEM      |\n=============================\n1. Park a car\n2. Take a car\n3. Search a car by license plate no.\n4. Display carpark usage\n5. Display all cars in carpark\n6. Display cars for free parking expired\n7. Display carpark income\n8. Quit the system\n";
	}

	
	public static void main(String[] args) {
		// Variable Declaration
		String licensePlate;
		int pos;
		int choice;
		// new the Carpark object 	
		Carpark carpark = new Carpark();
		// input the Sample Data
		createSampleData(carpark);
		do {
			choice = Integer.parseInt(getUserInput(displayMenu()
					+ "Please enter your choice (1 to 8) : "));
			switch (choice) {
			case 1: // Park a car
				if (carpark.hasFreeParkingLot()) {
					// TODO : Complete the missing code
					carpark.parkCar(getCarDetails(), getCurrentTime());
				} else
					// TODO : Complete the missing code
					JOptionPane.showMessageDialog(null, "Car Park is full !!!",
							"", JOptionPane.ERROR_MESSAGE);

				break;
			case 2: // Take a car
				licensePlate = getUserInput("Enter license plate no. : ");
				// TODO : Complete the missing code
				pos = carpark.searchCar(licensePlate);
				if (pos == -1) {
					// TODO : Complete the missing code
					JOptionPane.showMessageDialog(null,
							"Car with license plate no. [" + licensePlate
									+ "] is not found in carpark !!!", "Warns",
							JOptionPane.ERROR_MESSAGE);
				} else {
					// TODO : Complete the missing code
					carpark.takeCar(pos, getCurrentTime());
				}
				break;
			case 3: // Search a car by license plate no.
				// TODO : Complete the missing code
				licensePlate = getUserInput("Enter license plate no. : ");
				pos = carpark.searchCar(licensePlate);
				if (pos == -1) {
					// TODO : Complete the missing code
					JOptionPane.showMessageDialog(null,
							"Car with license plate no. [" + licensePlate
									+ "] is not found in carpark !!!", "Warns",
							JOptionPane.ERROR_MESSAGE);
				} else {
					// TODO : Complete the missing code
					JOptionPane.showMessageDialog(null,
							carpark.getParkingLot(pos).toString(),
							"Show the information of the car",
							JOptionPane.PLAIN_MESSAGE);
				}
				break;
			case 4: // Display carpark usage
				// TODO : Complete the missing code
				carpark.showCarparkUsage();
				break;
			case 5: // Display all cars in carpark
				// TODO : Complete the missing code
				carpark.showCarsInCarpark();
				break;
			case 6: // Display cars for free parking expired
				Time currentTime = getCurrentTime();
				// TODO : Complete the missing code
				carpark.showCarsShouldLeave(currentTime);
				break;
			case 7: // Display carpark income
				// TODO : Complete the missing code
				JOptionPane.showMessageDialog(
						null,
						"Current income of the carpark is "
								+ carpark.getIncome(), "Show the Income",
						JOptionPane.PLAIN_MESSAGE);
				break;
			case 8:
				break;
			default: // Handle invalid choice
				// TODO : Complete the missing code
				JOptionPane.showMessageDialog(null,
						"Invalid choice entered !!!", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} while (choice != 8);
		JOptionPane.showMessageDialog(null, "Thank you for using this system",
				"The End", JOptionPane.PLAIN_MESSAGE);
	}
}
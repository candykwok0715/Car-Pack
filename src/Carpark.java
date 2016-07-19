// Name: Kwok Sin Man	
// Program name : Carpark.java
// Start data: 16-Nov-2011
// End data: 20-Dec-2011
// --------------------------------------
// |   		Carpark.java(Use GUI)		|
// --------------------------------------
// | CAPACITY, freeParkingLot: int		|
// | DOLLAR_PER_MINUTE, income: double	|
// | pLo: ParkingLot[]					|
// --------------------------------------
// | Carpark()							|
// | getParkingLot(int): ParkingLot		|
// | hasFreeParkingLot(): boolean		|
// | parkCar(Car, Time): boolean		|
// | takeCar(int, Time): boolean		|
// | findFreeParkingLot(): int			|
// | searchCar(String): int				|
// | showCarsInCarpark()				|
// | showCarShouldLeave(Time)			|
// | getIncome(): double				|
// --------------------------------------

import javax.swing.JOptionPane;

public class Carpark {
	// Variable Declaration
	private final double DOLLAR_PER_MINUTE = 0.3;
	private final int CAPACITY = 5;
	private int freeParkingLot = CAPACITY;
	private ParkingLot[] pLot;
	private double income = 0;

	// Set a Constructor
	public Carpark() {
		pLot = new ParkingLot[CAPACITY];
		for (int i = 0; i < pLot.length; i++) {
			pLot[i] = new ParkingLot();
		}
		// Set the Open Time of the car park
		ParkingLot.carparkTimeOpen = new Time(6, 0);
		// Set the Close Time of the car park
		ParkingLot.carparkTimeClose = new Time(23, 59);
	}

	public ParkingLot getParkingLot(int pos) {
		return pLot[pos];// return the array
	}

	public boolean hasFreeParkingLot() {
		return (freeParkingLot > 0);
	}

	public boolean parkCar(Car car, Time timeIn) {
		// TODO : Only need to rewrite the method body of this method
		// This method should return false if cannot find a free parking lot,
		// otherwise return true and update the car information etc. in free
		// parking lot found
		// Hint : use methods findFreeParkingLot, driveIn
		boolean b = false;
		// check the parking has free parkingLot or not
		if (hasFreeParkingLot()) {
			pLot[findFreeParkingLot()].driveIn(car, timeIn);
			freeParkingLot -= 1; // the no. of freeParkingLot need to reduce 1
			b = true;
		}
		return b;
	}

	// assume the parking lot position already found by method searchCar
	public double takeCar(int pos, Time currentTime) {
		double charge = pLot[pos].driveOut(currentTime) * DOLLAR_PER_MINUTE;
		// the no. of free parkingLot need to increase 1 when take the car
		freeParkingLot++;
		income += charge;
		return charge;
	}

	public int findFreeParkingLot() {
		// TODO : Only need to rewrite the method body of this method
		// This method should perform linear search in array pLot,
		// and return the index of the first free parking lot found,
		// otherwise return -1 if cannot find a free parking lot
		for (int i = 0; i < pLot.length; i++) {
			// if find the free car parking Lot , return the car park no.
			if (!pLot[i].isOccupied())
				return i;
		}
		return -1;
	}

	// perform linear search in array pLot to find the car with the specified
	// licensePlate
	public int searchCar(String searchLicensePlate) {
		for (int i = 0; i < pLot.length; i++) {
			ParkingLot p = pLot[i];
			if (p.isOccupied()) {
				String licensePlate = p.getCarParked().getCarPlate();
				if (licensePlate.equals(searchLicensePlate))
					return i;
			}
		}
		return -1;
	}

	// list all cars currently in the carpark
	public void showCarsInCarpark() {
		String s = "";
		for (int i = 0; i < pLot.length; i++) {
			ParkingLot p = pLot[i];
			if (p.isOccupied())
				s += p.getCarParked() + "\n";
		}

		if (s == "")
			JOptionPane.showMessageDialog(null, "No Car In the Carpark !!!",
					"Show Cars In the Carpark", JOptionPane.PLAIN_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, s, "Show Cars In the Carpark",
					JOptionPane.PLAIN_MESSAGE);
	}

	public void showCarparkUsage() {
		// list the information of each parking lot
		// Show the car details if the parking lot is occupied
		String s = "";
		for (int i = 0; i < CAPACITY; i++)
			s += "Parking lot [" + i + "] " + pLot[i].toString().substring(7)
					+ "\n";
		JOptionPane.showMessageDialog(null, s, "Show Carpark Usage",
				JOptionPane.PLAIN_MESSAGE);
	}

	public void showCarsShouldLeave(Time currentTime) {
		// list all the cars for timeOut exceeds the
		// currentTime
		String s = "";
		for (int i = 0; i < CAPACITY; i++)
			if (pLot[i].isOccupied()) {
				// if the car should leave when is is greater or equal to 0
				if (currentTime.compareTo(currentTime, pLot[i].getTimeOut()) >= 0)
					s += pLot[i].getCarParked().toString();
			}
		if (s == "") // no car should leave
			JOptionPane.showMessageDialog(null, "No Car should Leave !!!",
					"Show Cars should leave", JOptionPane.PLAIN_MESSAGE);
		else
			// list the car when could leave
			JOptionPane.showMessageDialog(null, s, "Show Cars Should Leave",
					JOptionPane.PLAIN_MESSAGE);
	}

	// return the income
	public double getIncome() {
		return this.income;
	}
}
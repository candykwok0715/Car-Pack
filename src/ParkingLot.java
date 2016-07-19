// Name: Kwok Sin Man	
// Program name : ParkingLot.java
// Start data: 16-Nov-2011
// End data: 20-Dec-2011
// ----------------------------------
// |   	ParkingLot.java(Use GUI)	|
// ----------------------------------
// | timeIn, timeOut: Time			|
// | carParked: Car					|
// | isOccupied: boolean			|
// | carparkTimeOpen: Time			|
// | carparkTimeClose: Time			|
// ----------------------------------
// | ParkingLot()					|
// | driveIn(Car,Time):boolean		|
// | driveOut(Time): int			|
// | clearParkingLot()				|
// | setTimeOut(Time)				|
// | isOccupied(): boolean			|
// | setOccupied(boolean)			|
// | getTimeIn(): Time				|
// | setTimeIn(Time)				|
// | getCarParked(): Car			|
// | setCarParked(Car)				|
// | getTimeOut(): Time				|
// | toString(): String				|
// ----------------------------------

public class ParkingLot {
	// set Variable Declaration
	private boolean isOccupied;
	private Time timeIn;
	private Time timeOut;
	private Car carParked;

	// car park open time. Will be set by the CarPark class
	public static Time carparkTimeOpen;
	// car park close time. Will be set by the CarPark class
	public static Time carparkTimeClose;

	public ParkingLot() {
		clearParkingLot();
	}

	// add appropriate accessors and mutators
	public void setTimeIn(Time time) {
		timeIn = new Time(time);
	}

	// set the information of the car
	public void setCarParked(Car car) {
		carParked = new Car(car.getCarPlate(), car.getColour(), car.isVIPCar());
	}

	// set the isOccupied is true of false
	public void setOccupied(boolean b) {
		isOccupied = b;
	}

	// return the time in of the car
	public Time getTimeIn() {
		return timeIn;
	}

	// return the information of the car
	public Car getCarParked() {
		return carParked;
	}

	// return the time our of the car
	public Time getTimeOut() {
		return timeOut;
	}

	// return isOccupied is true or false
	public boolean isOccupied() {
		return isOccupied;
	}

	public boolean driveIn(Car carParked, Time timeIn) {
		// TODO : Only need to rewrite the method body of this method
		// This method should return false, if the car drives in before the
		// carparkTimeOpen,
		// otherwise return true and record car and timeIn information etc. for
		// this parking lot
		// Hint : use method setTimeOut to set the timeOut attribute value
		boolean b = false;
		// Case 1
		// if the hour of drives in car park Time
		if (timeIn.getHour() > carparkTimeOpen.getHour()
				&& timeIn.getHour() < carparkTimeClose.getHour()) {
			b = true; // set the b is true
			setOccupied(true); // put true in the Occupied
			setTimeIn(timeIn); // record the time in
			setTimeOut(timeIn);// record the time out
			setCarParked(carParked);// record the information of car
		}
		// Case 2
		// if the hour of drives in is equal car park Time Open or car park Time
		// Close
		// we need to check the minute of car park Open Time or car park Close
		// Time
		if (timeIn.getHour() == carparkTimeOpen.getHour()
				|| timeIn.getHour() == carparkTimeClose.getHour())
			if (timeIn.getMinute() >= carparkTimeOpen.getMinute()
					|| timeIn.getMinute() <= carparkTimeClose.getMinute()) {
				b = true;// set the b is true
				setOccupied(true);// put true in the Occupied
				setTimeIn(timeIn); // record the time in
				setTimeOut(timeIn);// record the time out
				setCarParked(carParked);// record the information of car
			}
		return b;
	}

	public int driveOut(Time timeGetCar) {
		// TODO : Only need to rewrite the method body of this method
		// Assume timeGetCar is always less than or equal to 23:59
		// This method should return the number of minutes need to be charged,
		// return 0 if the car is VIP car or the free parking time is not
		// exceeded
		// Hint : use method clearParkingLot to reset this parking lot to
		// available state
		int diff = 0;
		// if the car is not the VIP car, we will calculate the time between
		// time out and drive out
		if (carParked.isVIPCar() == false)
			if (timeGetCar.compareTo(timeGetCar, timeOut) >= 0)
				diff = timeGetCar.compareTo(timeGetCar, timeOut);
		clearParkingLot(); // the car park lot is free now
		return diff;
	}

	// reset attributes when parking lot is not occupied
	// call this method when a new carpark is set up or when a parking lot
	// becomes not occupied
	private void clearParkingLot() {
		isOccupied = false;
		timeIn = null;
		timeOut = null;
		carParked = null;
	}

	// the timeOut value which is 30 minutes after timeIn
	private void setTimeOut(Time timeIn) {
		timeOut = new Time(timeIn);
		timeOut.setTime(timeIn);
		// reset timeOut to carParkTimeClose if the calculated timeOut exceeds
		// carParkTimeClose
		if (carparkTimeOpen.getHour() < timeOut.getHour()
				& timeOut.getHour() > carparkTimeClose.getHour()
				| carparkTimeClose.getHour() == timeOut.getHour()
				& timeOut.getMinute() > carparkTimeClose.getMinute() - 30) {
			timeOut.setHour(carparkTimeClose.getHour());
			timeOut.setMinute(carparkTimeClose.getMinute());
		} else
			timeOut.addMinutes(30); // use method addMinutes to calculate the
									// timeOut value
	}

	// return the information of car when Parking Lot is occupied
	public String toString() {
		// TODO : Only need to rewrite the method body of this method
		// This method need to use the toString method of class Car
		String s = "";
		if (isOccupied)
			s = "Parking Lot is occupied by : " + carParked.toString()
					+ " Time In " + timeIn + ", Time Out " + timeOut;
		else
			s = "Parking Lot is available";
		return s;
	}
}
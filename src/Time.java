// Name: Kwok Sin Man	
// Program name : Time.java
// Start data: 16-Nov-2011
// End data: 20-Dec-2011
// ------------------------------
// |   Time.java ( Use GUI)		|
// ------------------------------
// | hour, minute: integer		|
// ------------------------------
// | Time(int,int)				|
// | Time(Time)					|
// | setTime(Time)				|
// | getHour():int				|
// | setHour(int)				|
// | getMinute():int			|
// | setMinute(int)				|
// | minuteToTime(int):Time		|
// | timeToMinute(Time):int		|
// | addMinute(int)				|
// | diffMinute(Time,Time):int	|
// | compareTo(Time,Time):int	|
// | toString():String			|
// ------------------------------
import javax.swing.JOptionPane;

public class Time {
	private int hour;
	private int minute;

	// Set a Constructor
	public Time(int hour, int minute) {
		// TODO : Only need to rewrite the method body of this method
		setHour(hour); // Call Method setHour to set the hour
		setMinute(minute); // Call Method setMinute to set the Minute
	}

	// Set a other Constructor
	public Time(Time time) {
		// TODO : Only need to rewrite the method body of this method
		setHour(time.hour); // Call Method setHour to set the Hour
		setMinute(time.minute);// Call Method setMinute to set the Minute
	}

	// Set the Time
	public void setTime(Time time) {
		setHour(time.hour);// Call Method setHour to set the Hour
		setMinute(time.minute);// Call Method setMinute to set the Minute }
	}

	// Set the Hour
	public void setHour(int hour) {
		// TODO : Only need to rewrite the method body of this method
		// This method should also display error message if the value of hour is
		// incorrect
		// valid range for hour : 0 to 23
		this.hour = hour;
		// Check the hour is not between 0 and 23
		if (hour < 0 || hour > 23) {
			// Show the Message to remain that the Hour is error and reset Hour
			// to 0
			JOptionPane.showMessageDialog(null, "ERROE: cannot set hour to "
					+ hour, "Erroe", JOptionPane.ERROR_MESSAGE);
			this.hour = 0;
			JOptionPane.showMessageDialog(null, "Hous is now set to "
					+ this.hour, "Reset", JOptionPane.PLAIN_MESSAGE);
		}
	}

	// return hour
	public int getHour() {
		return hour;
	}

	// Set Minute
	public void setMinute(int minute) {
		// TODO : Only need to rewrite the method body of this method
		// This method should also display error message if the value of minute
		// is incorrect
		// valid range for minute : 0 to 59
		this.minute = minute;
		// Check the hour is not between 0 and 59
		if (minute < 0 || minute > 59) {
			// Show the Message to remain that the Minute is error and reset
			// minute to 0
			JOptionPane.showMessageDialog(null, "ERROE: cannot set hour to "
					+ minute, "Erroe", JOptionPane.ERROR_MESSAGE);
			this.minute = 0;
			JOptionPane.showMessageDialog(null, "Minute is now set to "
					+ this.minute, "Reset", JOptionPane.PLAIN_MESSAGE);
		}
	}

	// return the minute
	public int getMinute() {
		return minute;
	}

	// the minute change to time, the return the Time
	public static Time minuteToTime(int minute) {
		// TODO : Only need to rewrite the method body of this method
		// This method perform reverse conversion similar to method timeToMinute
		// reset hour if hour > 23. E.g. if hour is 25, change it to 1
		return new Time(minute / 60, minute % 60);
	}

	// the time change to the minute format
	public static int timeToMinute(Time t) {
		return t.hour * 60 + t.minute;
	}

	// add the minutes
	public void addMinutes(int m) {
		// call the method minuteToTime and timeToMinute to change the time
		// format to do the calculation
		Time t = minuteToTime(timeToMinute(this) + m);
		setTime(t);
	}

	public static int diffMinute(Time t1, Time t2) {
		// This method should return the number of minutes when t1 - t2
		// use method timeToMinute to change the minute format before doing
		// calculation
		return (Time.timeToMinute(t1) - Time.timeToMinute(t2));
	}

	// return the different of two time
	public static int compareTo(Time t1, Time t2) {
		return diffMinute(t1, t2);
	}

	// return the hour and minute
	public String toString() {
		// TODO : Only need to rewrite the method body of this method
		return String.format("%02d:%02d", hour, minute);
	}
}
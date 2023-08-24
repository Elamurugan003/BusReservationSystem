package busResv;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.sql.SQLException;
public class Booking {
	String passengerName;
	int busNo;
	Date date;
	
	Booking(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name of passenger: ");
		passengerName = scanner.next();
		System.out.println("Enter bus no: ");
		busNo = scanner.nextInt();
		System.out.println("Enter date dd-mm-yyyy");
		String dateInput = scanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			e.printStackTrace();
		}	
	}
	
	public boolean isAvailable(int nos) throws SQLException{
		
		BusDAO busdao = new BusDAO();
		BookingDAO bookingdao = new BookingDAO();
		
		int capacity = busdao.getCapacity(busNo);
		int booked = bookingdao.getBookedCount(busNo,date);
		
		return (booked+nos)<=capacity ?true:false;
		
	}
}
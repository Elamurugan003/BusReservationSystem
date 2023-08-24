package busResv;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*; 

public class BusDemo {

	public static void main(String[] args){
		
	    BusDAO busdao = new BusDAO();
	    Date date = null;
	    try {
	    busdao.displayBusInfo();
		
		int userOpt = 1;
		Scanner scanner = new Scanner(System.in);
		
		while(userOpt>=0 && userOpt <=3) {
			
			System.out.println("Enter 0 to check Bus seat availability or Enter 1 for Bus booking "
					         + "or Enter 2 to cancel Bus booking or Enter 3 to Add Bus or 4 to exit");
			
			userOpt = scanner.nextInt();
			
			if(userOpt == 0) {
				System.out.println("Enter Bus No: ");
				int busNo = scanner.nextInt();
				System.out.println("Enter travel date: ");
				String dateInput = scanner.next();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				
				try {
					date = dateFormat.parse(dateInput);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				BookingDAO b = new BookingDAO();
				BusDAO bus = new BusDAO();
				int bookCount = b.getBookedCount(busNo, date);
				int availCount = bus.getCapacity(busNo) - bookCount;
				System.out.println("Available seats : " + availCount );
				
			}
			
			else if(userOpt == 1) {
				Booking booking = new Booking();
				BookingDAO bookingdao = new BookingDAO();
				int bookNo;
				
				System.out.println("No of booking needed: ");
				int nos = scanner.nextInt();
				
				if(booking.isAvailable(nos)) {
	
				  for(int i=0; i<nos; i++) {
					if(i==0) {
				      bookNo = bookingdao.addBooking(booking);
				      System.out.println(booking.passengerName+" booking is confirmed and booking no is "+ bookNo);
					}else {
						Booking book = new Booking();
						bookNo = bookingdao.addBooking(book);
					    System.out.println(book.passengerName+" booking is confirmed and booking no is "+ bookNo);
					}
				  }
				  
				}
				else
					System.out.println("Sorry. Bus is full. Try another bus or date.");
			}
			
			else if(userOpt == 2) {
				BookingDAO cancelB = new BookingDAO();
				System.out.println("Enter the Booking no to cancel: ");
				int bn = scanner.nextInt();
				cancelB.cancelBooking(bn);
				System.out.println("Your Booking is cancelled.");
			}
			
			else if(userOpt == 3) {
				Bus bus = new Bus();
				BusDAO addB = new BusDAO();
				addB.addBus(bus);
				System.out.println("Your Bus is added successfully with required information");
			}
			
		}
		scanner.close();
		
	}
	    catch(Exception e) {
	    	System.out.println(e);
	    }
	}
}

package busResv;

import java.util.Scanner;

public class Bus {
	private int busNo;
	private int ac;
	private int capacity;
	private String driverName;
	private String travelFrom;
	private String travelTo;
	
	Bus(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Bus no: ");
		busNo = scanner.nextInt();
		System.out.println("Enter Ac availability(Yes - 1 / No - 0): ");
		ac = scanner.nextInt();
		System.out.println("Enter capacity of Bus: ");
		capacity = scanner.nextInt();
		System.out.println("Enter driver name: ");
		driverName = scanner.next();
		System.out.println("Enter travel from: ");
		travelFrom = scanner.next();
		System.out.println("Enter travel to: ");
		travelTo = scanner.next();
	}
	
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getTravelFrom() {
		return travelFrom;
	}

	public void setTravelFrom(String travelFrom) {
		this.travelFrom = travelFrom;
	}

	public String getTravelTo() {
		return travelTo;
	}

	public void setTravelTo(String travelTo) {
		this.travelTo = travelTo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public int getBusNo(){ //accessors
		return busNo;
	}
	
	public int getAc(){
		return ac;
	}
	public int getCapacity(){ //accessor method
		return capacity;
	}
	
	public void setAc(int val) { //mutators
		ac = val;
	}
	
	public void setCapacity(int cap) { //mutator
		capacity = cap;
	}
	
}
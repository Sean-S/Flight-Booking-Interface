package application;

import java.time.LocalDate;

public class Flight2 {
	private String inBoundFlight2;
	private LocalDate inBoundDate2;
	private String departureTime2;
	private String arrivalTime2;
	private int price2;
	
	public Flight2(String inBoundFlight2, LocalDate inBoundDate2, 
			String departureTime2, String arrivalTime2, int price2)
	{
		this.inBoundFlight2 = inBoundFlight2;
		this.inBoundDate2 = inBoundDate2;
		this.departureTime2 = departureTime2;
		this.arrivalTime2 = arrivalTime2;
		this.price2 = price2;
	}
	
	public String getInBoundFlight2()
	{
		return inBoundFlight2;
	}
	
	public LocalDate getInBoundDate2()
	{
		return inBoundDate2;
	}
	
	public String getDepartureTime2()
	{
		return departureTime2;
	}
	
	public String getArrivalTime2()
	{
		return arrivalTime2;
	}
	
	public int getPrice2()
	{
		return price2;
	}

}
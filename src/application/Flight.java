package application;

import java.time.LocalDate;

public class Flight {
	private String outBoundFlight;
	private LocalDate outBoundDate;
	private String departureTime;
	private String arrivalTime;
	private int price;
	
	public Flight(String outBoundFlight, LocalDate outBoundDate, 
			String departureTime, String arrivalTime, int price)
	{
		this.outBoundFlight = outBoundFlight;
		this.outBoundDate = outBoundDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.price = price;
	}
	
	public String getOutBoundFlight()
	{
		return outBoundFlight;
	}
	
	public LocalDate getOutBoundDate()
	{
		return outBoundDate;
	}
	
	public String getDepartureTime()
	{
		return departureTime;
	}
	
	public String getArrivalTime()
	{
		return arrivalTime;
	}
	
	public int getPrice()
	{
		return price;
	}

}
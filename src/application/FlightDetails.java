package application;

import java.time.LocalDate;

public class FlightDetails {
	private String outBoundFlightRoute;
	private String inBoundFlightRoute;	
	private LocalDate dateOut;
	private LocalDate dateReturn;
	private String passengerName;
	private LocalDate passengerDOB;
	private int baggage;
	
	
	public FlightDetails(String outBoundFlightRoute, String inBoundFlightRoute,
			LocalDate dateOut, LocalDate dateReturn, String passengerName,
			LocalDate passengerDOB, int baggage)
	{
		this.outBoundFlightRoute = outBoundFlightRoute;
		this.inBoundFlightRoute = inBoundFlightRoute;
		this.dateOut = dateOut;
		this.dateReturn = dateReturn;
		this.passengerName = passengerName;
		this.passengerDOB = passengerDOB;
		this.baggage = baggage;
	}
	
	public String getOutBoundFlightRoute()
	{
		return outBoundFlightRoute;
	}
	
	public String getInBoundFlightRoute()
	{
		return inBoundFlightRoute;
	}
	
	public LocalDate getDateOut()
	{
		return dateOut;
	}
	
	public LocalDate getDateReturn()
	{
		return dateReturn;
	}
	
	public String getPassengerName()
	{
		return passengerName;
	}
	
	public LocalDate getPassengerDOB()
	{
		return passengerDOB;
	}
	
	public int getBaggage()
	{
		return baggage;
	}
}
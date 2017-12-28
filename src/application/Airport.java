package application;

import java.util.*;
import java.io.*;

public class Airport {
	private String airportName;
	private String airportCode;
	//Store Code and Price
	private String[][] price = new String[6][2];
	//Store Code and schedule
	private String [][] schedule = new String[6][3];
	
	
	public Airport(String AirportName, String AirportCode, String[][] price, String[][] schedule)  
	 {      
		 airportName = AirportName; 
		 airportCode = AirportCode; 
		 for (int i = 0; i<price.length; i++){			    
			       this.price[i][0] = price[i][0];
			       this.price[i][1] = price[i][1];			     
			}	
		 
		 for (int i = 0; i<schedule.length; i++){			    
		       this.schedule[i][0] = schedule[i][0];
		       this.schedule[i][1] = schedule[i][1];	
		       this.schedule[i][2] = schedule[i][2];
		 }
	 }
	
	 public Airport(String AirportName, String AirportCode)  
	 {      
		 airportName = AirportName; 
		 airportCode = AirportCode; 
	 }
	 
	 public String getFare(String AirportCode)
	 {
		 int x = 0;
		 while(x < price.length)
		 {
			 if(price[x][0].equals(AirportCode))
			 {
				 return price[x][1];				 
			 }
			 x++;
		 }
		 return "0";		 
	 }
	 
	 public String getDepartureTime(String AirportCode)
	 {
		 int x = 0;
		 while(x < schedule.length)
		 {
			 if(schedule[x][0].equals(AirportCode))
			 {
				 return schedule[x][1];				 
			 }
			 x++;
		 }
		 return "0";		 
	 }
	
	public String getArrivalTime(String AirportCode)
	 {
		 int x = 0;
		 while(x < schedule.length)
		 {
			 if(schedule[x][0].equals(AirportCode))
			 {
				 return schedule[x][2];				 
			 }
			 x++;
		 }
		 return "0";		 
	 }
	 
	 public String getAirportName()
	 {
		 return airportName;		 
	 }
	 
	 public String getAirportCode()
	 {
		 return airportCode;		 
	 }
	 
	 
	 
	  public String toString()  
	  {        
		  return airportName + " (" + airportCode + ")";    
	  } 

	    
}

package application;

import javafx.scene.control.DatePicker;

public class Passenger {
	private String firstName;
	private String secondName;
	private DatePicker datePicker;
	private Boolean bag;
	private String dni;
	
	public Passenger(String FirstName, String SecondName, DatePicker DatePicker,
			Boolean Bag, String Dni)
	{
		firstName = FirstName;
		secondName = SecondName;
		datePicker = DatePicker;
		bag = Bag;
		dni = Dni;		
	}
	
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getSecondName()
	{
		return secondName;
	}
	
	public DatePicker getDatePicker()
	{
		return datePicker;
	}
	
	public Boolean getBag()
	{
		return bag;
	}
	
	public String getDni()
	{
		return dni;
	}
}
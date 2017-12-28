package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Airports {
	private ArrayList<Airport> airports = new ArrayList<Airport>();
	//Store Code and Price
	private String [][] price = new String[6][2];
	//Store Code and schedule
	private String [][] schedule = new String[6][3];
	
	public Airports()
	{
		//readFileSchedule();
		readFile();
	}
	
	public ArrayList<Airport> getAirports()
	{
		return airports;
	}
	
	/*public ArrayList<Schedule> getSchedules()
	{
		//return schedules;
	}*/
	
	void readFile()
	{
		BufferedReader br = null;
		try {
			String sCurrentLine;				
			br = new BufferedReader(new FileReader("flights.txt"));
			while ((sCurrentLine = br.readLine()) != null) {
				String[] tokens = sCurrentLine.split (" ") ;
				/*int k = 2;
				//Loop through file and fill array with Code and Price
				for(int i = 0; i < price.length; i++)
				{
					for(int j = 0; j < 2; j++)
					{
						price[i][j] = tokens[i + k + j];	//i = Code, j = Price
					}
					if(k < 6) k++;
				}*/
				price[0][0] = tokens[2];
				price[0][1] = tokens[3];
				price[1][0] = tokens[4];
				price[1][1] = tokens[5];
				price[2][0] = tokens[6];
				price[2][1] = tokens[7];
				price[3][0] = tokens[8];
				price[3][1] = tokens[9];
				price[4][0] = tokens[10];
				price[4][1] = tokens[11];
				price[5][0] = tokens[12];
				price[5][1] = tokens[13];
				
				schedule[0][0] = tokens[14];
				schedule[0][1] = tokens[15];
				schedule[0][2] = tokens[16];
				schedule[1][0] = tokens[17];
				schedule[1][1] = tokens[18];
				schedule[1][2] = tokens[19];
				schedule[2][0] = tokens[20];
				schedule[2][1] = tokens[21];
				schedule[2][2] = tokens[22];
				schedule[3][0] = tokens[23];
				schedule[3][1] = tokens[24];
				schedule[3][2] = tokens[25];		
				schedule[4][0] = tokens[26];
				schedule[4][1] = tokens[27];
				schedule[4][2] = tokens[28];
				schedule[5][0] = tokens[29];
				schedule[5][1] = tokens[30];
				schedule[5][2] = tokens[31];
				
				
				
				airports.add(new Airport(tokens[0], tokens[1], price, schedule)); //Create Airports with tokens and pass price array
				}	
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	void readFileSchedule()
	{
		BufferedReader br = null;
		try {
			String sCurrentLine;				
			br = new BufferedReader(new FileReader("times.txt"));
			while ((sCurrentLine = br.readLine()) != null) {
				String[] tokens = sCurrentLine.split (" ") ;
				/*int k = 2;
				//Loop through file and fill array with Code and schedule
				for(int i = 0; i < schedule.length; i++)
				{
					for(int j = 0; j < 2; j++)
					{
						schedule[i][j] = tokens[i + k + j];	//i = Code, j = schedule
					}
					if(k < 6) k++;
				}*/
				schedule[0][0] = tokens[2];
				schedule[0][1] = tokens[3];
				schedule[0][2] = tokens[4];
				schedule[1][0] = tokens[5];
				schedule[1][1] = tokens[6];
				schedule[1][2] = tokens[7];
				schedule[2][0] = tokens[8];
				schedule[2][1] = tokens[9];
				schedule[2][2] = tokens[10];
				schedule[3][0] = tokens[11];
				schedule[3][1] = tokens[12];
				schedule[3][2] = tokens[13];		
				schedule[4][0] = tokens[14];
				schedule[5][1] = tokens[15];
				schedule[5][2] = tokens[16];
				//schedule[6][0] = tokens[17];
				//schedule[6][1] = tokens[18];
				//schedule[6][2] = tokens[19];
				
				
				}	
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
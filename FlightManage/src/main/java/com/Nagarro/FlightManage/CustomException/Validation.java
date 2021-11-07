package com.Nagarro.FlightManage.CustomException;

import com.Nagarro.FlightManage.Enums.FlightClass;

public class Validation extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public Validation() {
		// TODO Auto-generated constructor stub
	}

	public Validation(String message) {
		super(message);
		
		System.out.println();
		System.out.println(message);
	}
	
public void isValidLoc(String location) {
		
		if( location == null) {
			throw new Validation("Please Enter Correct Details");
		}
		
		if(location.length() > 3) {
			
			throw new Validation("\nError: Please Enter Location of 3 Length");
		}
		
		for(int i =0; i<location.length(); i++) {
			
			char loc = location.charAt(i);
			if(!(loc >='A') && !(loc <= 'Z')) {
				throw new Validation("\nError:Please Enter the Location in Alphabets Only");
			}
		}
	}
	
	public void isValidflightClass(String flightClass) {
		
		if(flightClass == "null") {
			throw new Validation("Please Enter Correct Details");
			
		}
		FlightClass flight = FlightClass.valueOf(flightClass);
		if(!flight.toString().equals("E") 
				&& !flight.toString().equals("B") 
					&& !flight.toString().equals("EB")) {
			throw new Validation("\nError: Please Enter Correct Flight Class");
		}
	}

	public boolean isValidDate(String flightDate) {
		
		//Converting Date Format To String For Validation
		if(flightDate.trim().equals("")) {
			throw new Validation();
		}
		else {
			String[] str = flightDate.split("-");
			String d = str[0];
			String m = str[1];
			if(d.length() > 2 || m.length() >2 ) {
				throw new Validation("Error: Please Enter Correct Flight Date Format");
			}
		}
		return true;
		
	}
	
	
}

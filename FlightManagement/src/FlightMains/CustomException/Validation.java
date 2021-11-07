package FlightMains.CustomException;

import FlightMains.Enums.FlightClass;

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
	
public void isValidLoc(String Location) {
		
		if( Location == null) {
			throw new Validation("Please Enter Correct Details");
		}
		
		if(Location.length() > 3) {
			
			throw new Validation("\nError: Please Enter Location of 3 Length");
		}
		
		for(int i =0; i<Location.length(); i++) {
			
			char loc = Location.charAt(i);
			if(!(loc >='A') && !(loc <= 'Z')) {
				throw new Validation("\nError:Please Enter the Location in Alphabets Only");
			}
		}
	}
	
	public void is_Valid_f_Class(String f_class) {
		
		if(f_class == "null") {
			throw new Validation("Please Enter Correct Details");
			
		}
		
		FlightClass flight = FlightClass.valueOf(f_class);
		
		if(!flight.toString().equals("E") 
				&& !flight.toString().equals("B") 
					&& !flight.toString().equals("EB")) {
			throw new Validation("\nError: Please Enter Correct Flight Class");
		}
	}

	public boolean is_Valid_Date(String f_Date) {
		
		//Converting Date Format To String For Validation
		if(f_Date.trim().equals("")) {
			throw new Validation();
		}
		else {
			String[] str = f_Date.split("-");
			
			String d = str[0];
			String m = str[1];
			
			if(d.length() > 2 || m.length() >2 ) {
				
				throw new Validation("Error: Please Enter Correct Flight Date Format");
			}
		}
		return true;
		
	}
}

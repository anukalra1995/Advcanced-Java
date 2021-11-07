package FlightMains.FlightInputs;

import java.util.Scanner;

import FlightMains.CustomException.Validation;
import FlightMains.FlightOutputs.FlightSearchMatch;
import FlightMains.Threads.MyThreads;

public class TravellerInputs {
	
public void takeInputs() {
		
		String Dep_Loc,Arr_Loc,Flight_Class,Output_Pref, Flight_Date;
		char ch;
		Scanner sc = new Scanner(System.in);
		
		MyThreads t = new MyThreads();
		t.start();
		
		Traveller travel = new Traveller();
		Validation valid = new Validation();
		
		do {
			
			System.out.println("\n*****Inputs*******");
			System.out.println("\nEnter the following details");
			
			sc.nextLine();
			
			try{
				System.out.println("Enter Departure Location: ");
				Dep_Loc = sc.nextLine().toUpperCase();
				valid.isValidLoc(Dep_Loc);
				
				System.out.println("Enter Arrival Location: ");
				Arr_Loc = sc.nextLine().toUpperCase();
				valid.isValidLoc(Arr_Loc);
				
				System.out.println("Enter FlightDate(dd-mm-yyyy): ");
				Flight_Date = sc.nextLine();
				valid.is_Valid_Date(Flight_Date);
					
						
				System.out.println("Enter Flight Class:");
				System.out.println("\n\t E : Economic \n\t B: Business");
				Flight_Class = sc.nextLine().toUpperCase();
				valid.is_Valid_f_Class(Flight_Class);
							
				System.out.println("Enter Output Prefernce: ");
				System.out.println("\n\t Fare \n\t Both (Fare and Flight Duration)");
				Output_Pref = sc.nextLine().toLowerCase();
				
				travel.setDep_Loc(Dep_Loc);
				travel.setArr_Loc(Arr_Loc);
				travel.setFlight_Class(Flight_Class);
				travel.setFlight_Date(Flight_Date);
				travel.setOutput_Pref(Output_Pref);
				
				FlightSearchMatch f = new FlightSearchMatch();
				f.flightmatch(travel);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println();
			System.out.println("Do u want to continue(y/n):");
			ch = sc.next().charAt(0);
			
			if(ch == 'n') {
				System.exit(0);
			}		
			
		} while (ch == 'y');
		
		sc.close();
		
	}
}

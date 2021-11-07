package com.Nagarro.FlightManage.FlightInputs;

import java.util.Scanner;

import com.Nagarro.FlightManage.CustomException.Validation;
import com.Nagarro.FlightManage.Outputs.FlightSearchMatch;
import com.Nagarro.FlightManage.Threads.MyThreads;

public class TravelInputs {
	
	public void takeInputs() {
		
		String depLoc,arrLoc,flightClass,outputPref, flightDate;
		char ch;
		Scanner sc = new Scanner(System.in);
		Traveller travel = new Traveller();
		Validation valid = new Validation();		
		MyThreads t = new MyThreads();
		t.start();
		do {
			
			System.out.println("\n*****Inputs*******");
			System.out.println("\nEnter the following details");			
			sc.nextLine();			
			try{				
				System.out.println("Enter Departure Location: ");
				depLoc = sc.nextLine().toUpperCase();
				valid.isValidLoc(depLoc);				
				System.out.println("Enter Arrival Location: ");
				arrLoc = sc.nextLine().toUpperCase();
				valid.isValidLoc(arrLoc);				
				System.out.println("Enter FlightDate(dd-mm-yyyy): ");
				flightDate = sc.nextLine();
				valid.isValidDate(flightDate);					
				System.out.println("Enter Flight Class:");
				System.out.println("\n\t E : Economic \n\t B: Business");
				flightClass = sc.nextLine().toUpperCase();
				valid.isValidflightClass(flightClass);							
				System.out.println("Enter Output Prefernce: ");
				System.out.println("\n\t Fare \n\t Both (Fare and Flight Duration)");
				outputPref = sc.nextLine().toLowerCase();				
				travel.setDepLoc(depLoc);
				travel.setArrLoc(arrLoc);
				travel.setFlightClass(flightClass);
				travel.setFlightDate(flightDate);
				travel.setOutputPref(outputPref);
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

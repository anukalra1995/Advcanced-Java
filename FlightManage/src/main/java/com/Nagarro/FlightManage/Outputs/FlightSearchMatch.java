package com.Nagarro.FlightManage.Outputs;

import java.util.ArrayList;

import com.Nagarro.FlightManage.Comparation.*;
import com.Nagarro.FlightManage.CsvReader.*;
import com.Nagarro.FlightManage.FlightInputs.Traveller;

public class FlightSearchMatch {
	
public void flightmatch(Traveller t) {
		
		ArrayList<CsvReading> result = new ArrayList<CsvReading>();
		ArrayList<CsvReading> csv = CsvReadInputs.csvFileRead();
		
		System.out.println("\nOutput of search\n");
		for(CsvReading flights : csv) {
			
			if(flights.getSeatAvail().equals("Y")) {
				
				if(flights.getArrLoc().equals(t.getArrLoc()) && flights.getDepLoc().equals(t.getDepLoc())
						&& flights.getValidTill().equals(t.getFlightDate())
							&& flights.getFlightClass().equals(t.getFlightClass())) {

						result.add(flights);
				}
			}
			
		}		
		//Setting Fare according to the output preference
		for(CsvReading flight : result ) {
			
			if(flight.getFlightClass().equals("EB") || flight.getFlightClass().equals("B") ) {
				
				double fare = Double.parseDouble(flight.getFare()) + 
									0.4 * Double.parseDouble(flight.getFare());
				flight.setFare(Double.toString(fare));
				
			}
		}
		
		//Sorting the output according the output preference selected
		
		if(t.getOutputPref().equals("fare") && result != null) {
			
			result.sort(new FareCompare());
			printFlightDetails.printDetails(result);
			
		}else if(t.getOutputPref().equals("both") && result != null) {
			
			result.sort(new FareCompare());
			result.sort(new DurCompare());
			printFlightDetails.printDetails(result);
			
		}else {
			
			System.out.println("No Flight found");
		}
		
	}
}

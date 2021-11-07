package FlightMains.FlightOutputs;

import java.util.ArrayList;

import FlightMains.Comparation.DurCompare;
import FlightMains.Comparation.fareCompare;
import FlightMains.CsvReader.CsvReadInputs;
import FlightMains.CsvReader.CsvReading;
import FlightMains.FlightInputs.Traveller;

public class FlightSearchMatch {
	
public void flightmatch(Traveller t) {
		
		ArrayList<CsvReading> result = new ArrayList<CsvReading>();
		ArrayList<CsvReading> csv = CsvReadInputs.csvFileRead();
		
		System.out.println("\nOutput of search\n");
		for(CsvReading flights : csv) {
			
			if(flights.getSeat_Avail().equals("Y")) {
				
				if(flights.getArr_Loc().equals(t.getArr_Loc()) && flights.getDep_Loc().equals(t.getDep_Loc())
						&& flights.getValid_Till().equals(t.getFlight_Date())
							&& flights.getFlight_Class().equals(t.getFlight_Class())) {

						result.add(flights);
				}
			}
			
		}		
		//Setting Fare according to the output preference
		for(CsvReading flight : result ) {
			
			if(flight.getFlight_Class().equals("EB") || flight.getFlight_Class().equals("B") ) {
				
				double fare = Double.parseDouble(flight.getFare()) + 
									0.4 * Double.parseDouble(flight.getFare());
				flight.setFare(Double.toString(fare));
				
			}
		}
		
		//Sorting the output according the output preference selected
		
		if(t.getOutput_Pref().equals("fare") && result != null) {
			
			result.sort(new fareCompare());
			printOutput.printDetails(result);
			
		}else if(t.getOutput_Pref().equals("both") && result != null) {
			
			result.sort(new fareCompare());
			result.sort(new DurCompare());
			printOutput.printDetails(result);
			
		}else {
			
			System.out.println("No Flight found");
		}
		
	}
}

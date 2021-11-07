package FlightMains.FlightOutputs;

import java.util.ArrayList;

import FlightMains.CsvReader.CsvReading;


public class printOutput {
	public static void printDetails(ArrayList<CsvReading> resultList) {
		for(CsvReading flights : resultList) {
			System.out.println(flights.toString());
		}
			
	}
}

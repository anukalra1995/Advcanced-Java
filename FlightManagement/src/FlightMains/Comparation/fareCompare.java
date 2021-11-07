package FlightMains.Comparation;

import java.util.Comparator;

import FlightMains.CsvReader.CsvReading;


public class fareCompare implements Comparator<CsvReading> {
	
	@Override
	public int compare(CsvReading d1, CsvReading d2) {
		
		return d2.getFare().compareTo(d1.getFare());
		
	}
}

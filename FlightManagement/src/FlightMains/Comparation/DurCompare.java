package FlightMains.Comparation;

import java.util.Comparator;

import FlightMains.CsvReader.CsvReading;

public class DurCompare  implements Comparator<CsvReading> {
	
	@Override
	public int compare(CsvReading d1, CsvReading d2) {
		
		return d2.getFlight_Dur().compareTo(d1.getFlight_Dur());
		
	}
}

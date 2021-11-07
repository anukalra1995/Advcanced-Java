package com.Nagarro.FlightManage.Comparation;

import java.util.Comparator;

import com.Nagarro.FlightManage.CsvReader.CsvReading;

public class FareCompare implements Comparator<CsvReading> {
	
	public int compare(CsvReading d1, CsvReading d2) {
		
		return d2.getFare().compareTo(d1.getFare());
		
	}
}

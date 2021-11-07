package com.Nagarro.FlightManage.Comparation;

import java.util.Comparator;

import com.Nagarro.FlightManage.CsvReader.CsvReading;

public class DurCompare implements Comparator<CsvReading> {
	
	public int compare(CsvReading d1, CsvReading d2) {
		
		return d2.getFlightDur().compareTo(d1.getFlightDur());
	}
}

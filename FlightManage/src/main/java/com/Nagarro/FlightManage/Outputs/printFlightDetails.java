package com.Nagarro.FlightManage.Outputs;

import java.util.ArrayList;

import com.Nagarro.FlightManage.CsvReader.CsvReading;

public class printFlightDetails {
	
	public static void printDetails(ArrayList<CsvReading> resultList) {
		for(int i = 0; i < resultList.size(); i++) {
			System.out.println(resultList.get(i)+" ");
		}
			
	}
}

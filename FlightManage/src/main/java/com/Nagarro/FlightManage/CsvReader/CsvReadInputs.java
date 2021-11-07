package com.Nagarro.FlightManage.CsvReader;

import java.io.*;
import java.util.ArrayList;
import com.opencsv.*;
public class CsvReadInputs {
	public static ArrayList<CsvReading>  csvFileRead() {
		
		ArrayList<CsvReading> lists = new ArrayList<CsvReading>();
		File folder = new File("ResourceFiles");
		File[] files = folder.listFiles();		
		for(File file : files) {
			try {
				
				CSVParser parser = new CSVParserBuilder().withSeparator('|').build(); 
				CSVReader reader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(parser).build();
				String[] words;				
				while((words = reader.readNext()) != null) {
					if(words != null) {
						CsvReading csv = new CsvReading(words[0] , words[1] , words[2] , words[3],words[4],
																	words[5],words[6], words[7],words[8]);
						lists.add(csv);
					}
				}
			} catch (Exception e) {
//				e.printStackTrace();
				System.out.println(e.getMessage());
			}			
		}
		return lists;
	}
}

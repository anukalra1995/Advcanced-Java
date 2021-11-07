package FlightMains.CsvReader;

import java.io.*;
import java.util.*;

public class CsvReadInputs {
	
	public static ArrayList<CsvReading>  csvFileRead() {
		
		
		ArrayList<CsvReading> lists = new ArrayList<CsvReading>();
		
		File folder = new File("AdvFiles");
		File[] files = folder.listFiles();		
		
		for(File file : files) {
			try {
				Scanner sc = new Scanner(file);
				
				while(sc.hasNext()) {
					String sent = sc.nextLine();
					String[] words = sent.split("\\|");
					if(words != null) {
						CsvReading csv = new CsvReading(words[0] , words[1] , words[2] , words[3],words[4],
								words[5],words[6], words[7],words[8]);
						lists.add(csv);

						
					}
					
				}
				
				sc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lists;
	}
}

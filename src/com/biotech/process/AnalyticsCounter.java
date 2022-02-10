package com.biotech.process;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {


		ReadSymptomDataFromFile z = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptomes = z.getSymptoms();
		//System.out.println(symptomes);
		symptomes.sort(Comparator.naturalOrder());
		//System.out.println(symptomes);
		List<Symptome> objSymptomes = new ArrayList<>();
		for (int i = 0; i<symptomes.size(); i++){
			if (i!=0){
				if (symptomes.get(i).equals(symptomes.get(i-1))){
					objSymptomes.get(objSymptomes.size()-1).addCount();
				}else{
					objSymptomes.add(new Symptome(symptomes.get(i)));
				}
			}else{
				objSymptomes.add(new Symptome(symptomes.get(0)));
			}
		}

		FileWriter writer = new FileWriter ("result.out");
		for(Symptome symptome : objSymptomes){
			System.out.println(symptome.getName()+ " "+symptome.getCount());
			writer.write(symptome.getName()+" : "+symptome.getCount()+"\n");
		}
		writer.close();
	}
}

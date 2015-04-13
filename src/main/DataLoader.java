package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import objects.TransportLine;

public class DataLoader {
	private StringBuilder json;
	private ArrayList<TransportLine> lines;
	private Type type;
	
	public DataLoader(){
		json = new StringBuilder();
		lines = new ArrayList<TransportLine>();
		type = new TypeToken<ArrayList<TransportLine>>(){}.getType();
	}
	
	public ArrayList<TransportLine> loadLines(String filePath) throws IOException{
//		json.delete(0, json.length()-1);	//nie ma czegos w stylu deleteAll albo clear kurde? tu mi sie sypie -.-
		loadDataToString(filePath);
		String linesString = json.toString();
		lines = new Gson().fromJson(linesString, type);
		return lines;
	}
	
	private void loadDataToString(String filePath) throws IOException{
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		String textLine = bufferedReader.readLine();
		  do {
		    json.append(textLine);
		  
		    textLine = bufferedReader.readLine();
		  } while(textLine != null);

		  bufferedReader.close();
	}
}

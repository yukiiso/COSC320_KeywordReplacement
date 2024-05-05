package Package0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Tool {
	
	public static ArrayList<ArrayList<String>> readKeywordCSV() throws Exception {
		/*
		 *  This method returns keyword list in the form of 2D ArrayList of String read from URL of csv.
		 *  Make sure to enter URL of raw file from git. 
		 *  
		 *  Inner ArrayList holds 
		 *  [0] = keyword 
		 *  [1] = corresponding phrase
		 *  
		 *  Outer ArrayList holds inner ArrayList such that 
		 *  [0] = header
		 *  [1-] = combination of keyword and corresponding phrase
		 *  
		 *  We need to process the original csv file by making sure that...
		 *  - there are keyword and phrase for each row
		 *  - keyword does not contain ","
		 *  - phrases are just containing phrases (ex: "Meaning ""smile""" is not acceptable)
		 *  
		 *  Modify the URL as you change the path in git. 
		 */
		String url = "https://raw.githubusercontent.com/PhamByteX/COSC320-Keyword-Replacement/main/DATA1.csv";
        String line;
        String csvSplitBy = ",";
        ArrayList<ArrayList<String>> csv = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            while ((line = br.readLine()) != null) {
            	String[] data = line.split(csvSplitBy);
            	ArrayList<String> new_line = new ArrayList<>();
            	// add keyword
            	new_line.add(data[0]);
            	// process phrase back into one string
            	String phrase = "";
            	if(data.length-1 > 0) { //if there was a phrase (Should not need to check!!! Fix original csv!!!)
            		phrase = combineByComma(Arrays.copyOfRange(data, 1, data.length));
            	}
            	// add processed phrase 
            	new_line.add(phrase);
            	// add inner ArrayList to outer ArrayList
            	csv.add(new_line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csv;
	}
	
	public static HashMap<String, String> makeKeywordHash() throws Exception{
		/*
		 * This method does not consider the collision at this point. 
		 * Make sure that there are no duplicates in keywords. 
		 */
		ArrayList<ArrayList<String>> keyword_list= Tool.readKeywordCSV();
		HashMap<String, String> keyword_hash = new HashMap<>();
		
		for(ArrayList<String> item: keyword_list) {
			keyword_hash.put(item.get(0), item.get(1));
		}

		return keyword_hash;
	}
	
	public static ArrayList<ArrayList<String>> readCSV(String url) throws Exception {
		/*
		 *  This method returns 2D ArrayList of String read from URL specified.
		 *  Make sure to enter URL of raw file from git. 
		 *  
		 *  Inner ArrayList holds list of cells in one row. 
		 *  
		 *  Outer ArrayList holds inner ArrayList such that 
		 *  [0] = header
		 *  [1-] = contents
		 *  
		 *  Since csv separates cells by "," , 
		 *  We need to make sure that each cell does not contain "," . 
		 *  
		 */
        String line;
        String csvSplitBy = ",";
        ArrayList<ArrayList<String>> csv = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            while ((line = br.readLine()) != null) {
            	String[] data = line.split(csvSplitBy);
            	ArrayList<String> new_line = new ArrayList<>();
            	for(String item: data) {
            		new_line.add(item);
            	}
            	csv.add(new_line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csv;
	}
	
	public static String combineByComma(String[] data) {
		/*
		 * This method combines String in data into one String. 
		 * In order to match the format of CSV, it splits all elements by comma. 
		 * But it does not insert comma at the end. 
		 */
		String str = "";
		if(data.length != 0) {
			for(int i=0; i<data.length; i++) {
				str = str + data[i] + ",";
	    	}
			str = str.substring(0, str.length()-1); //remove last "," 
		}
    	return str;
	}
	
	public static String processedPath(String org_path, String cur_folder, String new_folder) {
		/*
		 * This method returns new path modified from org_path. 
		 * Method replaces cur_folder by new_folder and add "_processed" after the file name.
		 * Make sure to have cur_folder in org_path.   
		 */
		String before_dot = org_path.substring(0, org_path.lastIndexOf('.'));
		String after_dot  = org_path.substring(org_path.lastIndexOf('.'), org_path.length());
		
		String before_folder = before_dot.substring(0, before_dot.lastIndexOf(cur_folder));
		String after_folder  = before_dot.substring(before_dot.lastIndexOf(cur_folder)+cur_folder.length(),
													before_dot.length());
		
		String new_path = before_folder + new_folder + after_folder + "_processed" + after_dot;
		return new_path;
	}
}

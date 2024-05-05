package Package0;

import java.util.ArrayList;


public class AlgorithmA {
	
	public static void processAllDocuments(ArrayList<String> doc_path_list) throws Exception {
		ArrayList<ArrayList<String>> keyword_list= Tool.readKeywordCSV();
		for(String doc_path: doc_path_list) {
			processDocument(keyword_list, doc_path);
		}
	}
	
	public static void processDocument(ArrayList<ArrayList<String>> keyword_list, String doc_path) {
		/* 
		 * CAUTION: this method modifies the original file. 
		 * if you want the original file to remain the same, 
		 * modify this code to create another file using Tool.processedPath(). 
		 */
		
		
		
	}
	
	
	
	
	
	
}

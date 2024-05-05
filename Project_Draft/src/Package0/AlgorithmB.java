package Package0;

import java.util.ArrayList;
import java.util.HashMap;

public class AlgorithmB {
	public static void processAllDocuments(ArrayList<String> doc_path_list) throws Exception {
		HashMap<String, String> keyword_hash = Tool.makeKeywordHash();
		
		for(String doc_path: doc_path_list) {
			processDocument(keyword_hash, doc_path);
		}
	}
	
	public static void processDocument(HashMap<String, String> keyword_hash, String doc_path) {
		/* 
		 * CAUTION: this method modifies the original file. 
		 * if you want the original file to remain the same, 
		 * modify this code to create another file using Tool.processedPath(). 
		 */
		
	}
	
	
}

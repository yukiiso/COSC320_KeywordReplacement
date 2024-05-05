package Package0;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		ArrayList<ArrayList<String>> keyword_list= Tool.readKeywordCSV();
		for(ArrayList<String> item: keyword_list) {
			System.out.println(item.toString());
		}
		
		// make list of path of documents
		ArrayList<String> doc_path_list = new ArrayList<>();
		
		
//		AlgorithmA.processAllDocuments(doc_path_list);
//		AlgorithmB.processAllDocuments(doc_path_list);

	}
}

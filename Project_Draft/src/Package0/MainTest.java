package Package0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void testProcessedPath() {
		String original = "COSC320-Keyword-Replacement/raw/document0.csv";
		String processed = Tool.processedPath(original, "raw", "processed");
		assertTrue(processed.equals("COSC320-Keyword-Replacement/processed/document0_processed.csv"));
	}

}

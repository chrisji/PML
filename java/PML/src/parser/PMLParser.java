package parser;

import java.util.ArrayList;
import tags.Tag;

public class PMLParser {
	/**
	 * Parses each Tag in the ArrayList. 
	 * 
	 * This calls the output method for each tag.
	 * 
	 * @param tags the ArrayList of Tags to parse.
	 */
	public static void parse(ArrayList<Tag> tags) {
		for (Tag t: tags) {
			t.output();
		}	
	}
}

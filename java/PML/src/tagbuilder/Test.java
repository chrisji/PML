package tagbuilder;

import java.util.ArrayList;

import org.w3c.dom.Document;

import parser.PMLParser;
import tags.Tag;

public class Test {
	public static void main(String[] args) {
		PMLBuilder builder = new PMLBuilder();
		Document doc = builder.loadPML("tests/test.pml");
		Tag t = builder.build(doc);
		
		ArrayList<Tag> tagDocument = new ArrayList<Tag>();
		tagDocument.add(t);
		
		PMLParser.parse(tagDocument);
	}
}

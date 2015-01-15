package tagbuilder;

import java.util.ArrayList;

import org.w3c.dom.Document;

import parser.PMLParser;
import tags.Tag;

public class Test {
	public static void main(String[] args) {
		TagBuilder tagBuilder = new TagBuilder();
		PMLBuilder builder = new PMLBuilder(tagBuilder);
		Document doc = builder.loadPML("tests/test.pml");
		Tag rootTag = builder.build(doc);
		
		ArrayList<Tag> tagDocument = new ArrayList<Tag>();
		tagDocument.add(rootTag);
		
		PMLParser.parse(tagDocument);
	}
}

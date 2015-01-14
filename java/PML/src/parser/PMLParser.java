package parser;
import java.util.ArrayList;

import tags.Tag;
import tags.TagHTML;
import tags.TagHeading;
import tags.TagText;

public class PMLParser {
	public static void main(String[] args) {
		// <html><h1><text>Hello world!</h1></html>
		TagText headingText = new TagText(null, "Hello world!");
		ArrayList<Tag> headingTextList = new ArrayList<Tag>();	
		headingTextList.add(headingText);
		
		TagHeading h1Tag = new TagHeading(null, headingTextList);
		ArrayList<Tag> h1TagList = new ArrayList<Tag>();
		h1TagList.add(h1Tag);
		
		TagHTML htmlTag = new TagHTML(null, h1TagList);
		ArrayList<Tag> root = new ArrayList<Tag>();
		root.add(htmlTag);

		PMLParser.parse(root);
	}

	public static void parse(ArrayList<Tag> tags) {
		if (tags != null) {
			for (Tag t: tags) {
				t.output(t.getChildTags());
			}	
		}
	}
}

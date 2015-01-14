package parser;
import java.util.ArrayList;

import tags.Tag;
import tags.TagHTML;
import tags.TagHeading;
import tags.TagText;

public class PMLParser {
	public static void main(String[] args) {
		// <html><h1><text>Hello world!</h1></html>
		TagText headingText = new TagText();
		headingText.setCharacterData("Hello world!");
		ArrayList<Tag> headingTextList = new ArrayList<Tag>();	
		headingTextList.add(headingText);
		
		TagHeading h1Tag = new TagHeading();
		h1Tag.setChildTags(headingTextList);
		ArrayList<Tag> h1TagList = new ArrayList<Tag>();
		h1TagList.add(h1Tag);
		
		TagHTML htmlTag = new TagHTML();
		htmlTag.setChildTags(h1TagList);
		ArrayList<Tag> document = new ArrayList<Tag>();
		document.add(htmlTag);

		PMLParser.parse(document);
	}
	
	public static void parse(ArrayList<Tag> tags) {
		if (tags != null) {
			for (Tag t: tags) {
				t.output(t.getChildTags());
			}	
		}
	}
}

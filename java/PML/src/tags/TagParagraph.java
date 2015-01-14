package tags;

import java.util.ArrayList;
import java.util.HashMap;

import parser.PMLParser;

public class TagParagraph extends Tag{

	public TagParagraph(HashMap<String, String> attributes, ArrayList<Tag> childTags) {
		super(attributes, childTags);
	}


	@Override
	public void output(ArrayList<Tag> tags) {
		System.out.println("<p>");
		PMLParser.parse(tags);
		System.out.println("</p>");
	}
}

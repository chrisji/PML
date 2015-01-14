package tags;

import java.util.ArrayList;

import parser.PMLParser;

public class TagParagraph extends Tag{

	@Override
	public void output(ArrayList<Tag> tags) {
		System.out.println("<p>");
		PMLParser.parse(tags);
		System.out.println("</p>");
	}
}

package tags;

import java.util.ArrayList;

import parser.PMLParser;

public class TagHeading extends Tag{

	@Override
	public void output(ArrayList<Tag> tags) {
		System.out.println("<h1>");
		PMLParser.parse(tags);
		System.out.println("</h1>");
	}
}

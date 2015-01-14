package tags;

import java.util.ArrayList;
import java.util.HashMap;

import parser.PMLParser;

public class TagHeading extends Tag{

	public TagHeading(HashMap<String, String> attributes, ArrayList<Tag> childTags) {
		super(attributes, childTags);
	}

	@Override
	public void output(ArrayList<Tag> tags) {
		System.out.println("<h1>");
		PMLParser.parse(tags);
		System.out.println("</h1>");
	}
}

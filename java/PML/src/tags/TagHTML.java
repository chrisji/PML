package tags;

import java.util.ArrayList;
import java.util.HashMap;

import parser.PMLParser;

public class TagHTML extends Tag{

	public TagHTML(HashMap<String, String> attributes, ArrayList<Tag> childTags) {
		super(attributes, childTags);
	}


	@Override
	public void output(ArrayList<Tag> tags) {
		System.out.println("<html>");
		PMLParser.parse(tags);
		System.out.println("</html>");
	}
}

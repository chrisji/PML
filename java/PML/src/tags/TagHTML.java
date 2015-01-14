package tags;

import java.util.ArrayList;

import parser.PMLParser;

public class TagHTML extends Tag{

	@Override
	public void output(ArrayList<Tag> tags) {
		System.out.println("<html>");
		PMLParser.parse(tags);
		System.out.println("</html>");
	}
}

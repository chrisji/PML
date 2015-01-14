package tags;

import java.util.ArrayList;

import parser.PMLParser;

public class TagHeading extends Tag{

	@Override
	public void output(ArrayList<Tag> tags) {
		String attString = buildAttributeString();
		if (attString.equals("")) {
			System.out.println("<h1>");
		} else {
			System.out.println("<h1 " + attString + ">");
		}
		
		PMLParser.parse(tags);
		System.out.println("</h1>");
	}
}

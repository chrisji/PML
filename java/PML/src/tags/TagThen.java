package tags;

import java.util.ArrayList;

import parser.PMLParser;

public class TagThen extends Tag{

	@Override
	public void output(ArrayList<Tag> tags) {
		PMLParser.parse(tags);
	}
}

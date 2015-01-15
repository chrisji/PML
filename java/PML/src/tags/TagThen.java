package tags;

import parser.PMLParser;

public class TagThen extends Tag{

	@Override
	public void output() {
		PMLParser.parse(this.getChildTags());
	}
}

package tags;

import parser.PMLParser;

public class TagElse extends Tag{

	@Override
	public void output() {
		System.out.println("<?php else : ?>");
		PMLParser.parse(this.getChildTags());
	}
}

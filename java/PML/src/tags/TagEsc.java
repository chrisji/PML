package tags;

import parser.PMLParser;

public class TagEsc extends Tag{

	@Override
	public void output() {
		if (this.getAttributes().containsKey("lang")) {
			System.out.println("<?php");
			PMLParser.parse(this.getChildTags());
			System.out.println("?>");
		}
	}
}

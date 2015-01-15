package tags;

import parser.PMLParser;

public class TagWhile extends Tag{

	@Override

	public void output() {
		String cond = this.getAttributes().get("cond");

		System.out.println("<?php while(" + cond + ") : ?>");
		PMLParser.parse(this.getChildTags());
		System.out.println("<?php endwhile; ?>");
	}
}

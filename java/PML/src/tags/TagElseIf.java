package tags;

import parser.PMLParser;

public class TagElseIf extends Tag{

	@Override
	public void output() {
		String cond = getAttributes().get("cond");
		System.out.println("<?php elseif (" + cond + ") : ?>");
		PMLParser.parse(this.getChildTags());
	}
}

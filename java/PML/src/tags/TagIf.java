package tags;

import parser.PMLParser;

public class TagIf extends Tag{

	@Override
	public void output() {
		String cond = getAttributes().get("cond");
		
		System.out.println("<?php if (" + cond + ") : ?>");
		PMLParser.parse(this.getChildTags());
		System.out.println("<?php endif; ?>");
	}
}

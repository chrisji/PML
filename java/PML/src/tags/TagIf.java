package tags;

import java.util.ArrayList;

import parser.PMLParser;

public class TagIf extends Tag{

	@Override
	public void output(ArrayList<Tag> tags) {
		String cond = getAttributes().get("cond");
		
		System.out.println("<?php if (" + cond + ") { ?>");
		PMLParser.parse(tags);
		System.out.println("<?php } ?>");
	}
}

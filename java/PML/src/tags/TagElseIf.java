package tags;

import java.util.ArrayList;

import parser.PMLParser;

public class TagElseIf extends Tag{

	@Override
	public void output(ArrayList<Tag> tags) {
		String cond = getAttributes().get("cond");
		System.out.println("<?php elseif (" + cond + "):?>");
		PMLParser.parse(tags);
	}
}

package tags;

import java.util.ArrayList;

import parser.PMLParser;

public class TagWhile extends Tag{

	@Override
	public void output(ArrayList<Tag> tags) {
		String cond = this.getAttributes().get("cond");
		
		System.out.println("<?php while(" + cond);
		PMLParser.parse(tags);
		System.out.println("<?php while(" + cond);
	}
}

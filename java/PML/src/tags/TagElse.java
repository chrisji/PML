package tags;

import java.util.ArrayList;

import parser.PMLParser;

public class TagElse extends Tag{

	@Override
	public void output(ArrayList<Tag> tags) {
		System.out.println("<?php else { ?>");
		PMLParser.parse(tags);
		System.out.println("<?php } ?>");
	}
}

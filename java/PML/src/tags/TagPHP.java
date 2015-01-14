package tags;

import java.util.ArrayList;

import parser.PMLParser;

public class TagPHP extends Tag{

	@Override
	public void output(ArrayList<Tag> tags) {
		System.out.println("<?php");
		PMLParser.parse(tags);
		System.out.println("?>");
	}
}

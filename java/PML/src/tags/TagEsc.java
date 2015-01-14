package tags;

import java.util.ArrayList;

import parser.PMLParser;

public class TagEsc extends Tag{

	@Override
	public void output(ArrayList<Tag> tags) {
		if (this.hasAttributes() && this.getAttributes().containsKey("lang")) {
			String lang = getAttributes().get("lang");
			System.out.println("<?php");
			PMLParser.parse(tags);
			System.out.println("?>");
		}
	}
}

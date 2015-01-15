package tags;

import java.util.ArrayList;

import parser.PMLParser;

public class TagFunction extends Tag{

	@Override
	public void output() {
		String functionName = this.getAttributes().get("name");
		String args = this.buildArgumentString(this.getChildTagsByName("argument"));
		
		System.out.println("<?php function " + functionName + "(" + args + ") { ?>");
		// TODO - disallow no body tag definition.
		PMLParser.parse(this.getChildTagsByName("body").get(0).getChildTags());
		System.out.println("<?php } ?>");
	}
	
	private String buildArgumentString(ArrayList<Tag> argTags) {
		String argString = "";
		
		for (Tag argTag: argTags) {
			argString += argTag.getAttributes().get("name") + ", ";
		}
		
		// Remove last two characters ", " and return.
		return argString.substring(0, argString.length()-2);
	}
}

package tags;

import java.util.ArrayList;

import parser.PMLParser;

public class TagFunction extends Tag{

	@Override
	public void output() {
		String functionName = this.getAttributes().get("name");
		String args = this.buildArgumentString(this.getChildTagsByName("argument"));
		
		System.out.println("<?php function " + functionName + "(" + args + ") { ?>");
		PMLParser.parse(this.getChildTagsByName("body"));
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

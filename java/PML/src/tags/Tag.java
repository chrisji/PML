package tags;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents a PML element.
 * 
 * @author Chris
 *
 */
public abstract class Tag {
	private HashMap<String, String> attributes;
	private ArrayList<Tag> childTags;
	
	public Tag(HashMap<String, String> attributes, ArrayList<Tag> childTags) {
		this.attributes = attributes;
		this.childTags = childTags;
	}
	
	public abstract void output(ArrayList<Tag> tags);
	
	public ArrayList<Tag> getChildTags() {
		return this.childTags;
	}
}

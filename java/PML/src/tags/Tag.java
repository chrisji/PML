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
	
	public Tag() {
		this.attributes = null;
		this.childTags = null;
	}
	
	/* For simple reflection, no parameter constructors allowed?!
	public Tag(HashMap<String, String> attributes, ArrayList<Tag> childTags) {
		this.attributes = attributes;
		this.childTags = childTags;
	}*/
	
	//Should return a tree like structure soon?
	public abstract void output(ArrayList<Tag> tags);
	
	/**
	 * Returns an ArrayList of Tags representing this Tag's children.
	 * 
	 * @return ArrayList<Tag> representing this Tag's children.
	 */
	public ArrayList<Tag> getChildTags() {
		return this.childTags;
	}
	
	/**
	 * Returns a HashMap of attributes for this Tag.
	 * Where the key is the attribute's name, and the value is the attribute's value.
	 * 
	 * @return HashMap<String, String> representing this tag's attributes.
	 */
	public HashMap<String, String> getAttributes() {
		return this.attributes;
	}
	
	/**
	 * Set the children of this Tag.
	 * 
	 * @param ArrayList<Tag> - ArrayList<Tag> representing this Tag's children.
	 */
	public void setChildTags(ArrayList<Tag> childTags) {
		this.childTags = childTags;
	}
	
	/**
	 * Set the attributes for this tag.
	 * @param HashMap<String, String> - HashMap of attributes.
	 */
	public void getAttributes(HashMap<String, String> attributes) {
		this.attributes = attributes;
	}
	
	
}

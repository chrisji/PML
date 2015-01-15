package tags;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import parser.PMLParser;

/**
 * Represents a PML element.
 * 
 * @author Chris
 *
 */
public class Tag {
	private HashMap<String, String> attributes;
	private ArrayList<Tag> childTags;
	private String tagName;
	
	/**
	 * Constructor for Tag.
	 * 
	 * Currently an empty constructor to simplify reflection.
	 */
	public Tag() {
		this.attributes = null;
		this.childTags = null;
		this.tagName = null;
	}

	/**
	 * Outputs the 'code' for the Tag.
	 * 
	 * @param tags ArrayList<Tag> containing this Tag's children.
	 */
	public void output(ArrayList<Tag> tags) {
		System.out.println("<" + this.tagName + buildAttributeString() + ">");
		PMLParser.parse(tags);
		System.out.println("</" + this.tagName + ">");
	}
	
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
	 * Returns the Tag's name.
	 * 
	 * @return String the Tag's name.
	 */
	public String getTagName() {
		return this.tagName;
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
	 * 
	 * @param HashMap<String, String> - HashMap of attributes.
	 */
	public void setAttributes(HashMap<String, String> attributes) {
		this.attributes = attributes;
	}
	
	/**
	 * Sets the name of the Tag.
	 * 
	 * @param tagName String containing the name of the Tag.
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	/**
	 * Returns a String representing the Tag's attribute map.
	 * 
	 * Example: A map containing ("x", "1") and ("y", "hello") 
	 * returns the string: " x=\"1\" y=\"hello\""
	 * 
	 * @return String representing the Tag's attributes.
	 */
	public String buildAttributeString() {
		String attString = "";
		
		if (attributes != null) {
			attString += " ";
			for (Map.Entry<String, String> entry : attributes.entrySet()){
				attString += entry.getKey() + "=\"" + entry.getValue() + "\"";
			}
		}
		
		return attString;
	}
	
	
	/**
	 * Tests whether this Tag has attributes.
	 * 
	 * @return boolean true if the Tag has one or more attribute, false otherwise.
	 */
	public boolean hasAttributes() {
		// Has attributes if the attributes map has been initialised and is not empty.
		return this.attributes!=null && !this.attributes.isEmpty();
	}
}

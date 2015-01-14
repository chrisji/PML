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
	
	public Tag() {
		this.attributes = null;
		this.childTags = null;
		this.tagName = null;
	}

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
	 * @param HashMap<String, String> - HashMap of attributes.
	 */
	public void setAttributes(HashMap<String, String> attributes) {
		this.attributes = attributes;
	}
	
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
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
	
	
	public boolean hasAttributes() {
		return this.attributes!=null;
	}
}

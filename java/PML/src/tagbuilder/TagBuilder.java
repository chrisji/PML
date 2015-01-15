package tagbuilder;

import java.util.HashMap;

import tags.Tag;

public class TagBuilder {
	private HashMap<String, String> tagMap;
	
	/**
	 * Initialises tagMap.
	 */
	public TagBuilder() {
		tagMap = new HashMap<String, String>();
		tagMap.put("esc", "tags.TagEsc");
		tagMap.put("text", "tags.TagText");
		tagMap.put("if", "tags.TagIf");
		tagMap.put("then", "tags.TagThen");
		tagMap.put("elif", "tags.TagElseIf");
		tagMap.put("else", "tags.TagElse");
		tagMap.put("while", "tags.TagWhile");
		tagMap.put("function", "tags.TagFunction");
	}

	/**
	 * Builds and returns a Tag by reflection, using the classes specified in the tagMap. 
	 * 
	 * @param tagName the name of the PML tag to build.
	 * @return Tag the Tag that is mapped with tagName. If the tag is not found in the map
	 * then 
	 */
	public Tag build(String tagName) {
		try {
			Tag tag = null;
			if (tagMap.containsKey(tagName)) {
				String tagClassName = tagMap.get(tagName);
				Class<?> tagClass = Class.forName(tagClassName);
				tag = (Tag)tagClass.newInstance(); 
			} else {
				tag = new Tag();
			}
			tag.setTagName(tagName);
			return tag;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

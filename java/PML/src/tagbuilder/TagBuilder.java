package tagbuilder;

import java.util.HashMap;

import tags.Tag;

public class TagBuilder {
	public static HashMap<String, String> tagMap;
	
	public TagBuilder() {
		tagMap = new HashMap<String, String>();
		tagMap.put("html", "tags.TagHTML");
		tagMap.put("h1", "tags.TagHeading");
		tagMap.put("p", "tags.TagParagraph");
		tagMap.put("esc", "tags.TagEsc");
		tagMap.put("text", "tags.TagText");
		tagMap.put("if", "tags.TagIf");
		tagMap.put("then", "tags.TagThen");
		tagMap.put("elif", "tags.TagElseIf");
		tagMap.put("else", "tags.TagElse");
	}

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

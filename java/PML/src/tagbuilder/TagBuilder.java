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
		tagMap.put("php", "tags.TagPHP");
		tagMap.put("text", "tags.TagText");
	}

	public Tag build(String tagName) {
		try {
			String tagClassName = tagMap.get(tagName);
			Class<?> tagClass = Class.forName(tagClassName);
			Tag tag = (Tag)tagClass.newInstance(); 
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

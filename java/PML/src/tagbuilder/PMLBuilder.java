package tagbuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import tags.Tag;
import tags.TagText;

public class PMLBuilder {
	private TagBuilder tagBuilder;
	
	public PMLBuilder() {
		tagBuilder= new TagBuilder();
	}
	
	public Document loadPML(String filename) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			return builder.parse(new File(filename));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Tag buildTagTree(Node root) {
		// Build root Tag
		String rootTagName = root.getNodeName();
		Tag rootTag = tagBuilder.build(rootTagName);
		System.out.println("DEBUG[PMLBuilder:buildTagTree] - Built tag: " + rootTagName);
		
		// Build children of root.
		NodeList list = root.getChildNodes();
		ArrayList<Tag> childTags = new ArrayList<Tag>();
		
		for (int i=0; i<list.getLength(); i++) {
			Node childNode = list.item(i);
			if (childNode instanceof Text) {
		        String text = childNode.getNodeValue();
		        if (!text.trim().equals("") ) {
					System.out.println("DEBUG[PMLBuilder:buildTagTree] - For " + rootTagName +", building and adding child tag: " + childNode.getNodeName());
		        	TagText tt = new TagText();
		        	tt.setCharacterData(text);
		            childTags.add(tt);
		        }
		    } else {
				System.out.println("DEBUG[PMLBuilder:buildTagTree] - For " + rootTagName +", building and adding child tag: " + childNode.getNodeName());
				childTags.add(buildTagTree(childNode));
		    }
		}
		
		if (root.hasAttributes()) {
			HashMap<String, String> atts = new HashMap<String, String>();
			NamedNodeMap nnm = root.getAttributes();
			for (int i=0; i<nnm.getLength(); i++) {
				Node att = nnm.item(i);
				atts.put(att.getNodeName(), att.getNodeValue());
			}
			rootTag.setAttributes(atts);
		}
		
		rootTag.setChildTags(childTags);
		// Return root tag
		return rootTag;
	}
	
	public Tag build(Document doc) {
		Node root = doc.getDocumentElement();
		return buildTagTree(root);
	}
	
}

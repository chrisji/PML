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

import tags.Tag;
import tags.TagText;

public class PMLBuilder {
	private TagBuilder tagBuilder;
	
	/**
	 * Construct a PMLBuilder which uses a language specific TagBuilder.
	 * 
	 * @param builder TagBuilder which will be used to build Tags.
	 */
	public PMLBuilder(TagBuilder builder) {
		this.tagBuilder = builder;
	}
	
	/**
	 * Loads a DOM Document from a PML (XML) file.
	 * 
	 * @param path Path to the PML file.
	 * @return Document the DOM Document of the PML file.
	 */
	public Document loadPML(String path) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			return builder.parse(new File(path));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Tag build(Document doc) {
		Node root = doc.getDocumentElement();
		return buildTagTree(root);
	}
	
	/**
	 * @param root
	 * @return
	 */
	private Tag buildTagTree(Node root) {
		// Get the tag name of the root node.
		String rootTagName = root.getNodeName();
		
		// Build the children for the root node.
		ArrayList<Tag> children = buildChildren(root);
		
		// Build the attributes for the root node.
		HashMap<String, String> attributes = buildAttributes(root);
		
		// Set up the root Tag, and return it.
		Tag rootTag = tagBuilder.build(rootTagName);
		rootTag.setTagName(rootTagName);
		rootTag.setChildTags(children);
		rootTag.setAttributes(attributes);
		return rootTag;
	}
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	private ArrayList<Tag> buildChildren(Node node) {
		ArrayList<Tag> childTags = new ArrayList<Tag>();
		NodeList childNodes = node.getChildNodes();
		
		for (int i=0; i<childNodes.getLength(); i++) {
			Node childNode = childNodes.item(i);
			if (childNode.getNodeType() == Node.TEXT_NODE) {
		        String text = childNode.getNodeValue();
		        if (!text.trim().equals("") ) {
		        	TagText tt = new TagText();
		        	tt.setCharacterData(text);
		            childTags.add(tt);
		        }
		    } else if (childNode.getNodeType() == Node.COMMENT_NODE) {
		    	// Ignore comments for the moment...
		    } else {
				childTags.add(buildTagTree(childNode));
		    }
		}
		
		return childTags;
	}
	
	/**
	 * 
	 * @param rootNode
	 * @return
	 */
	private HashMap<String, String> buildAttributes(Node rootNode) {
		HashMap<String, String> atts = new HashMap<String, String>();
		
		// Add attributes from the Node into the Map.
		if (rootNode.hasAttributes()) {
			NamedNodeMap attributeMap = rootNode.getAttributes();
			for (int i=0; i<attributeMap.getLength(); i++) {
				Node attNode = attributeMap.item(i);
				atts.put(attNode.getNodeName(), attNode.getNodeValue());
			}
		}
		
		return atts;
	}
}
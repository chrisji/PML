package tags;

import java.util.ArrayList;
import java.util.HashMap;

public class TagText extends Tag{
	private String characterData;
	
	public TagText(HashMap<String, String> attributes, String characterData) {
		super(attributes, null);
		this.characterData = characterData;
	}
	
	@Override
	public void output(ArrayList<Tag> tags) {
		System.out.println(this.characterData);
	}

}

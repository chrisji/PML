package tags;

import java.util.ArrayList;

public class TagText extends Tag{
	private String characterData;
	
	public void setCharacterData(String characterData) {
		this.characterData = characterData;
	}
	
	@Override
	public void output(ArrayList<Tag> tags) {
		System.out.println(this.characterData);
	}
}

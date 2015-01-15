package tags;

public class TagText extends Tag{
	private String characterData;
	
	public void setCharacterData(String characterData) {
		this.characterData = characterData;
	}
	
	@Override
	public void output() {
		System.out.println(this.characterData);
	}
}

package a6adept;

public class BeltFullException extends Exception {
	
	private Belt belt;
	
	public BeltFullException(Belt belt) {
		super("The belt is full");
		this.belt = belt;
	}
	
	public Belt getBelt() {
		return belt;
	}

}

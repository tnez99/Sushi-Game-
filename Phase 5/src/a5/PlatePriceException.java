package a5;

public class PlatePriceException extends Exception{
	
	private Plate p;
	private Sushi s;
	
	
	public PlatePriceException(Plate p, Sushi s) {
		super("Illegal plate price");
		
		this.p = p;
		this.s = s;
	}
	
	
// throw new plate price exception
	
}

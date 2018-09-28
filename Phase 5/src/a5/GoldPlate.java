package a5;

public class GoldPlate extends PlateImpl{

	public GoldPlate(Sushi contents, double price) throws PlatePriceException {
		super(contents, Plate.Color.GOLD, priceCheck(price));
		// TODO Auto-generated constructor stub
		
		
	}
	
	private static double priceCheck(double price) {
		if( price < 5.0) {
			throw new IllegalArgumentException();
		}
		
		return price;
		
		
	}

}

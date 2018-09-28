package a5;

public abstract class PlateImpl implements Plate {

	private Sushi contents;
	private Plate.Color color;
	private double price;

	public PlateImpl(Sushi contents, Plate.Color color, double price) throws PlatePriceException {
		this.contents = contents;
		this.color = color;
		this.price = price;

	}

	public PlateImpl(Sushi contents, Plate.Color color) {
		// TODO Auto-generated constructor stub
	}

	public Sushi getContents() {
		return contents;
	}

	public Sushi removeContents() {
		if (contents == null) {
			return null;
		}
		return contents;

	}

	public void setContents(Sushi s) throws PlatePriceException {
		if (s == null) {
			throw new IllegalArgumentException();
		} else if (price <= s.getCost()) {
			throw new PlatePriceException(this, s);
		}
		
		contents = s;
	}

	public boolean hasContents() {
		if (contents == null) {
			return false;
		}
		return true;
	}

	public double getPrice() {
		return price;
	}
	
	

	public Plate.Color getColor() {
		return color;

	}

	public double getProfit() {
		if (!hasContents()) {
			return 0.0;
		}
		return (this.getPrice() - contents.getCost());

	}
}

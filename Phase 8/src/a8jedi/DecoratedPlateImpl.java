package a8jedi;

import comp401.sushi.Plate;
import comp401.sushi.PlatePriceException;
import comp401.sushi.Sushi;


public class DecoratedPlateImpl implements DecoratedPlate{
	
	private Plate p;
	private int rotationCount;
	
	public DecoratedPlateImpl(Plate p, int rotationCount) {
		this.p = p;
		this.rotationCount = rotationCount;
	}

	@Override
	public Sushi getContents() {
		// TODO Auto-generated method stub
		return p.getContents();
	}

	@Override
	public void setContents(Sushi s) throws PlatePriceException {
		// TODO Auto-generated method stub
		p.setContents(s);
		
	}

	@Override
	public Sushi removeContents() {
		// TODO Auto-generated method stub
		return p.removeContents();
	}

	@Override
	public boolean hasContents() {
		// TODO Auto-generated method stub
		return p.hasContents();
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return p.getPrice();
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return p.getColor();
	}

	@Override
	public double getProfit() {
		// TODO Auto-generated method stub
		return p.getProfit();
	}

	@Override
	public int getRotationCount() {
		// TODO Auto-generated method stub
		return rotationCount;
	}

	@Override
	public void incrementRotationCount() {
		// TODO Auto-generated method stub
		
		rotationCount++;
		
	}

	@Override
	public Plate getPlate() {
		// TODO Auto-generated method stub
		return p;
	}

}

package a6jedi;

import java.util.Iterator;
import java.util.NoSuchElementException;

import comp401.sushi.Plate;

public class PriceThresholdBeltIterator implements Iterator<Plate> {
	private Belt belt;
	private int start_position;
	private double max_price;
	private boolean nextUsed = false;

	public PriceThresholdBeltIterator(Belt belt, int start_position, double max_price) {
		if(belt == null) {
			throw new IllegalArgumentException("Belt cannot be null.");
		} else if(max_price <= 0.0) {
			throw new IllegalArgumentException("Max price must be greater than zero.");
		} else {
			// Set instance variables
			this.belt = belt;
			this.start_position = start_position;
			this.max_price = max_price;
		}
}
	
	public boolean hasNext() {
		
		int position = start_position;
		Plate nextPlate = belt.getPlateAtPosition(position);
		if ((nextPlate != null) && (nextPlate.getPrice() <= this.max_price)) {
			return true;
		} else {
			for (int i = 0; i < belt.getSize(); i++) {
				nextPlate = belt.getPlateAtPosition(position);

				position++;
				if (nextPlate != null) {
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	public Plate next() {
		int beltsize = belt.getSize();
		
		if (hasNext() == false) {
			throw new NoSuchElementException();
		} else {
			for (int i = 0; i < belt.getSize(); i++) {
				if (start_position < 0) {
					start_position = ((start_position % beltsize) + beltsize);
				} else {
					start_position = (start_position % beltsize);
				}
				Plate nextPlate = belt.getPlateAtPosition(start_position++);
				
				if ((nextPlate != null) && (nextPlate.getPrice() <= this.max_price)) {
					return nextPlate;
				}
			}
	
	}
	return null;
	}
	
	public void remove() {
		if(this.nextUsed == true) {
			this.belt.clearPlateAtPosition(this.start_position);
			this.nextUsed = false;
		} else {
			
		throw new UnsupportedOperationException();

	}

}
	}



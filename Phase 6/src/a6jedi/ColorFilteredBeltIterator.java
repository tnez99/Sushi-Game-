package a6jedi;

import java.util.Iterator;
import java.util.NoSuchElementException;

import comp401.sushi.Plate;

public class ColorFilteredBeltIterator implements Iterator<Plate> {
	private Belt belt;
	private int start_position;
	private Plate.Color color_filter;
	private boolean nextUsed = false;

	
	public ColorFilteredBeltIterator(Belt belt, int start_position, Plate.Color color_filter) {
		if(belt == null) {
			throw new IllegalArgumentException("Belt cannot be null.");
		} else if(color_filter == null) {
			throw new IllegalArgumentException("Max price must be greater than zero.");
		} else {
			// Set instance variables
			this.belt = belt;
			this.start_position = start_position;
			this.color_filter = color_filter;
		}
}
	
	public boolean hasNext() {
		
		int position = start_position;
		Plate nextPlate = belt.getPlateAtPosition(position);
		if ((nextPlate != null) && (nextPlate.getColor().equals(this.color_filter))){
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
				
				if ((nextPlate != null)  && (nextPlate.getColor().equals(this.color_filter))) {
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

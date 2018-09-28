package a6novice;

import comp401.sushi.Plate;
import comp401.sushi.Sushi;

public class Belt {

	private Plate[] Belt; // sets room for the array

	public Belt(int size) {
		Belt = new Plate[size]; // creates the array. currently empty
	}

	public int getSize() {
		return Belt.length;

	}

	public Plate getPlateAtPosition(int position) {
		if (Belt[position] == null) {
			return null;
		} else if (position < 0 || position >= Belt.length) {
			throw new IllegalArgumentException();
		} else {
			return Belt[position];
		}

	}

	public void setPlateAtPosition (Plate plate, int position) throws BeltPlateException {
		if(plate == null ) {
			throw new IllegalArgumentException();
		} else if (position < 0 || position >= Belt.length) {
			throw new IllegalArgumentException();
		} else if (Belt[position] != null){
			throw new BeltPlateException(position, plate, this);	
		} else {
			Belt[position] = plate;
		}
		return;
		}

	public void clearPlateAtPosition(int position) {
		if (position < 0 || position >= Belt.length) {
			throw new IllegalArgumentException();
		}
		Belt[position] = null;
		return;
	}

	public Plate removePlateAtPosition(int position) {
		if (position < 0 || position >= Belt.length) {
			throw new IllegalArgumentException();
		} else if(Belt[position] == null) {
			throw new java.util.NoSuchElementException();
		} else {
			
			Plate newPlate = getPlateAtPosition(position);
			clearPlateAtPosition(position);
			return newPlate;

		}

	}

}

 package a6jedi;

import java.util.Iterator;

import comp401.sushi.Plate;
import comp401.sushi.Plate.Color;
import comp401.sushi.Sushi;
import java.util.NoSuchElementException;

import a6jedi.BeltPlateException;

public class Belt implements Iterable<Plate> {

	private Plate[] Belt; // sets room for the array
	private int size;

	public Belt(int size) {
		this.size = size;
		Belt = new Plate[size]; // creates the array. currently empty

		if (size <= 0) {
			throw new IllegalArgumentException();
		}
	}
	public int getSize() {
		return Belt.length;

	}

	public Plate getPlateAtPosition(int position) {
		if (position < 0) {
			return Belt[position % size + size];
		}
			if (position == size) {
				return Belt[0];
			}
		if (position > size) {

			return Belt[position % size];
		} if(Belt[position] == null) {
			return null;
		}
			return Belt[position];


	}


	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		if(plate == null) {
			throw new IllegalArgumentException();
		}
		if (position < 0) {
			Belt[position % size + size] = plate;
			return;
		}
			if (position == size) {
				Belt[0] = plate;
				return;
			}
		if (position > size) {

			Belt[position % size] = plate;
			return;
		} if(Belt[position] != null) {
			throw new BeltPlateException(position, plate, this);
		}
			Belt[position] = plate;


	}

	public void clearPlateAtPosition(int position) {
		if (position < 0) {
			Belt[position % getSize() + getSize()] = null;
		} else if (position >= Belt.length) {

			Belt[position % getSize()] = null;
		} else {

			Belt[position] = null;
		}
	}

	public Plate removePlateAtPosition(int position) {
		if (Belt[position] == null) {
			throw new RuntimeException();
		} else if (position < 0) {
			Plate temp = Belt[position % getSize() + getSize()];
			Belt[position % getSize() + getSize()] = null;
			return temp;
		} else if (position >= Belt.length) {
			Plate temp = Belt[position % getSize()];
			Belt[position % getSize()] = null;
			return temp;
		} else {
			Plate temp = Belt[position]; // assuming that it is not null initially, then setting it to null
			Belt[position] = null;
			return temp;

		}

	}

	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		for (int x = 0; x < Belt.length; x++) {
			int j = (position + x);
			if (Belt[j] == null) {
				Belt[j] = plate;
				return j;
			}
		}
		throw new BeltFullException(this);
	}

	public Iterator<Plate> iterator() {
		int position = 0;
		return new BeltIterator(this, position);
	}
	
	public Iterator<Plate> iterator(double maxPrice) {
		return new PriceThresholdBeltIterator(this, 0, maxPrice);
}
	
	public Iterator<Plate> iterator(Plate.Color color) {
		return new ColorFilteredBeltIterator(this, 0, color);
}

	public Iterator<Plate> iteratorFromPosition(int position) {
		return new BeltIterator(this, position);
	}
	public Iterator<Plate> iteratorFromPosition(int position, double maxPrice) {
		return new PriceThresholdBeltIterator(this, position, maxPrice);
	}
	
	public Iterator<Plate> iteratorFromPosition(int position, Plate.Color color) {
		return new ColorFilteredBeltIterator(this, position, color);
}

	
	public void rotate() {
		Plate[] temp = new Plate[size];
		for (int i =0; i < size - 1; i++) {
			if (i == 0) {
				temp[i] = Belt[size - 1];
			} else {
				temp[i] = Belt[i - 1];
			}
		}
		Belt = temp.clone();
	}

}

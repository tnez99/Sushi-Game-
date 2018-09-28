package a6jedi;

import java.util.Iterator;

import java.util.NoSuchElementException;
import comp401.sushi.Plate;

public class BeltIterator implements Iterator<Plate> {
	private Belt belt;
	private int start_position;
	private boolean nextUsed = false;

	public BeltIterator(Belt belt, int start_position) {
		this.belt = belt;
		this.start_position = start_position;
		this.nextUsed = nextUsed;

	}

	public boolean hasNext() {

		int position = start_position;
		Plate nextPlate = belt.getPlateAtPosition(position);
		if (nextPlate != null) {
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

				if (nextPlate != null) {
					nextUsed = true;
					return nextPlate;
				}
			}

		}
		return null;
	}

	public void remove() {
		if (nextUsed == false) {

			throw new IllegalStateException();

		}
		if (nextUsed == true) {
			belt.clearPlateAtPosition(this.start_position - 1);
			nextUsed = false;
		}

	}
}

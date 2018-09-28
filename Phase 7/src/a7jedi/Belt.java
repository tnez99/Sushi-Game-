package a7jedi;

import java.util.NoSuchElementException;


import comp401.sushi.Plate;

import comp401.observable.*;

public class Belt extends Observable {

	private Plate belt[];
	private Customer[] cus;

	public Belt(int size) {
		if (size < 1) {
			throw new IllegalArgumentException("Belt size must be greater than zero.");
		}

		belt = new Plate[size];
		
		cus = new Customer[size];
	}
	
	

	public int getSize() {
		return belt.length;
	}

	public Plate getPlateAtPosition(int position) {
		position = normalizePosition(position);
		return belt[position];
	}

	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		position = normalizePosition(position);

		if (plate == null) {
			throw new IllegalArgumentException("Plate is null");
		}

		if (belt[position] != null) {
			throw new BeltPlateException(position, plate, this);
		}
		belt[position] = plate;
	}

	public void clearPlateAtPosition(int position) {
		position = normalizePosition(position);
		belt[position] = null;
	}

	public Plate removePlateAtPosition(int position) {
		Plate plate = getPlateAtPosition(position);
		if (plate == null) {
			throw new NoSuchElementException();
		}
		clearPlateAtPosition(position);
		return plate;
	}

	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		for (int i=0; i<getSize(); i++) {
			try {
				setPlateAtPosition(plate, position);
				return normalizePosition(position);
			} catch (BeltPlateException e) {
				position += 1;
			}
		}
		throw new BeltFullException(this);
	}

	private int normalizePosition(int position) {
		int normalized_position = position%getSize();

		if (position < 0) {
			normalized_position += getSize();
		}

		return normalized_position;
	}

	public void rotate() {
		Plate last_plate = belt[getSize()-1];
		for (int i=getSize()-1; i>0; i--) {
			belt[i] = belt[i-1];
		}
		belt[0] = last_plate;
		
		
		for (int i= 0; i < getSize() ; i++) {
			if (cus[i] != null && belt[i] != null) {
				cus[i].observePlateOnBelt(this, belt[i], i);
				
				
			}
		}

	}
	
	public void registerCustomerAtPosition(Customer c, int position) {
		 int normal_pos = normalizePosition(position);

		if (c == null) {
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < cus.length; i++) {
			if (cus[i] == c) {
				throw new RuntimeException();
			}
		}
	
		if (cus[normal_pos] != null) {
			throw new RuntimeException();
		}
		else {
			cus[normal_pos] = c;
		}
}
		

	
	public Customer unregisterCustomerAtPosition(int position) {
		
		Customer temp = cus[normalizePosition(position)];
		cus[normalizePosition(position)]= null;
		return temp;
	}

}

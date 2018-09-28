package a8jedi;
import comp401.observable.Observable;
import a8adept.Belt;
import a8adept.PlateEvent;
import comp401.observable.*;
import comp401.observable.Observer;
import comp401.sushi.Plate;


public class PlateCounter implements Observer{
	private Belt b;
	private int red_num;
	private int green_num;
	private int blue_num;
	private int gold_num ;

	

    public PlateCounter(Belt b) {
    this.b = b;
    if( b == null) {
    	throw new IllegalArgumentException();
    }
    this.b = b;
    b.addObserver(this);
    	

    for (int i = 0; i < b.getSize(); i++) {
		if (b.getPlateAtPosition(i) != null) {
			if (b.getPlateAtPosition(i).getColor() == (Plate.Color.RED)) {
				red_num++;
			} else if (b.getPlateAtPosition(i).getColor() == (Plate.Color.GREEN)) {
				green_num++;
			} else if (b.getPlateAtPosition(i).getColor() == (Plate.Color.BLUE)) {
				blue_num++;
			} else if (b.getPlateAtPosition(i).getColor() == (Plate.Color.GOLD)) {
				gold_num++;
			}
}
}
}
    public void update(Observable o, Object arg) {
		PlateEvent event = (PlateEvent) arg;
		// If a plate is placed, find out the color of the plate and increment
		// the number of that color of plate.
		if (event.getType() == PlateEvent.EventType.PLATE_PLACED) {
			switch (event.getPlate().getColor()) {
			case RED:
				red_num++;
				break;
			case GREEN:
				green_num++;
				break;
			case BLUE:
				blue_num++;
				break;
			case GOLD:
				gold_num++;
				break;
			}
		} else {
	
			if (event.getType() == PlateEvent.EventType.PLATE_REMOVED) {
				switch (event.getPlate().getColor()) {
				case RED:
					red_num--;
					break;
				case GREEN:
					green_num--;
					break;
				case BLUE:
					blue_num--;
					break;
				case GOLD:
					gold_num--;
					break;
				}
			}
		}
	}

    
	public int getRedPlateCount() {
		return red_num;
	}

	public int getGreenPlateCount() {
		return green_num;
	}

	public int getBluePlateCount() {
		return blue_num;
	}

	public int getGoldPlateCount() {
		return gold_num;
	}

}
    


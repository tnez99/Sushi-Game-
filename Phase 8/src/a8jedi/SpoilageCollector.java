package a8jedi;

import comp401.observable.Observable;
import comp401.observable.Observer;
import comp401.sushi.IngredientPortion;

public class SpoilageCollector implements Observer {
	private Belt b;
	private double SpoiledSushi_cost;
	private double SpoiledShellfish_amount;
	private double SpoiledSeafood_amount;
	private double SpoiledFood_amount;

	public SpoilageCollector(Belt b) {
		this.b = b;
		// Throw an exception if the belt is null.
		if (b == (null)) {
			throw new IllegalArgumentException();
		} else {
			// This is an observer of the belt.
			b.addObserver(this);
		}

	}

	public void update(Observable o, Object arg) {
		PlateEvent event = (PlateEvent) arg;
		if (event.getType() == PlateEvent.EventType.PLATE_SPOILED) {
			b.removePlateAtPosition(event.getPosition());
			IngredientPortion[] ingredients;
			ingredients = event.getPlate().getContents().getIngredients();

			for (int i = 0; i < ingredients.length; i++) {
				SpoiledSushi_cost += ingredients[i].getCost();
				if (ingredients[i].getIsShellfish() == true) {
					SpoiledShellfish_amount += ingredients[i].getAmount();
				}
				if (ingredients[i].getName() == "crab" || ingredients[i].getName() == "shrimp"
						|| ingredients[i].getName() == "salmon" || ingredients[i].getName() == "tuna"
						|| ingredients[i].getName() == "eel") {
					SpoiledSeafood_amount += ingredients[i].getAmount();
				}
				SpoiledFood_amount += ingredients[i].getAmount();
			}
		}
	}

	public double getTotalSpoiledCost() {
		return SpoiledSushi_cost;

	}

	public double getTotalSpoiledShellfish() {
		return SpoiledShellfish_amount;

	}

	public double getTotalSpoiledSeafood() {
		return SpoiledSeafood_amount;

	}

	public double getTotalSpoiledFood() {
		return SpoiledFood_amount;

	}

}

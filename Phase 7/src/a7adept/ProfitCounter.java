package a7adept;
import comp401.observable.Observable;
import comp401.observable.*;
import comp401.observable.Observer;
import comp401.sushi.Plate;



public class ProfitCounter implements Observer {
	private Belt b;
	private double profit;
	private int num_plates;


		public ProfitCounter(Belt b) {
		this.b = b;
		if (b == (null)) {
			throw new IllegalArgumentException();
		} else {
			b.addObserver(this);
		}

		for (int i = 0; i < b.getSize(); i++) {
			if (b.getPlateAtPosition(i) != null) {
				profit = profit + b.getPlateAtPosition(i).getProfit();
				num_plates++;
			}
		}
	}


	public void update(Observable o, Object arg) {
		PlateEvent event = (PlateEvent) arg;

		if (event.getType() == PlateEvent.EventType.PLATE_PLACED) {
			double tempProfit = (event.getPlate().getProfit());
			profit = profit + tempProfit;
			num_plates++;

		} else if (event.getType() == PlateEvent.EventType.PLATE_REMOVED) {
			double tempProfit = (event.getPlate().getProfit());
			profit = profit - tempProfit;
			num_plates--;
		}
	}

	public double getTotalBeltProfit() {
		return profit;
	}


	public double getAverageBeltProfit() {
		if(num_plates == 0) {
			
			return 0.00;
		} else {
			return profit/(num_plates);}
		}

}

package a4jedi;



public class TunaPortion extends IngredientPortionImpl {
	
	public TunaPortion(double amount) {
		super(new Tuna(), amount );

		  if(amount < 0) {
				throw new RuntimeException("Value cannot be negative");

		  }
	}
	@Override
	public IngredientPortion combine(IngredientPortion other) {
		TunaPortion newCombo = null;
		// TODO Auto-generated method stub
		if(other == null) {
			return this;
		}
		else if(other.getName()==(this.getName())) {
			newCombo = new TunaPortion(this.getAmount() + other.getAmount());
			return newCombo;
		} 
		else {
			return null;
		}
	}

}

package a5;

public class RicePortion extends IngredientPortionImpl {
	
	public RicePortion(double amount) {
		super(new Rice(), amount );

		  if(amount < 0) {
				throw new RuntimeException("Value cannot be negative");

		  }
	}
	
	public IngredientPortion combine(IngredientPortion other) {
		RicePortion newCombo = null;
		// TODO Auto-generated method stub
		if(other == null) {
			return this;
		}
		else if(other.getName()==(this.getName())) {
			newCombo = new RicePortion(this.getAmount() + other.getAmount());
			return newCombo;
		} 
		else {
			return null;
		}
	}

}

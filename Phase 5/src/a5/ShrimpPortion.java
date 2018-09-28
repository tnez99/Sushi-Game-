package a5;



public class ShrimpPortion extends IngredientPortionImpl {
	
	public ShrimpPortion(double amount) {
		super(new Shrimp(), amount );

		  if(amount < 0) {
				throw new RuntimeException("Value cannot be negative");

		  }
	}
	@Override

	public IngredientPortion combine(IngredientPortion other) {
		ShrimpPortion newCombo = null;
		// TODO Auto-generated method stub
		if(other == null) {
			return this;
		}
		else if(other.getName()==(this.getName())) {
			newCombo = new ShrimpPortion(this.getAmount() + other.getAmount());
			return newCombo;
		} 
		else {
			return null;
		}
	}

}


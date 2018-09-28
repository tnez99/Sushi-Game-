package a4novice;

public class SeaweedPortion extends IngredientPortionImpl {
	
	public SeaweedPortion(double amount) {
		super(new Seaweed(), amount );

		  if(amount < 0) {
				throw new RuntimeException("Value cannot be negative");

		  }
	}
	@Override

	public IngredientPortion combine(IngredientPortion other) {
		// TODO Auto-generated method stub
		if(other == null) {
			return this;
		}
		else if(!other.getIngredient().equals(this.getIngredient())) {
			throw new RuntimeException("Illegal Arguments");
		} 
		else {
			double total = other.getAmount() + this.getAmount();
			SeaweedPortion ingSum = new SeaweedPortion(total);
			return ingSum;
			//construct new ingredientPortionImpl, same ingredient but the sum of amounts and this
		}
	}

}

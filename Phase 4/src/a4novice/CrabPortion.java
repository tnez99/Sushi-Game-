package a4novice;

public class CrabPortion extends IngredientPortionImpl {
	
	public CrabPortion(double amount) {
		super(new Crab(), amount );
		
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
			CrabPortion ingSum = new CrabPortion(total);
			return ingSum;
			//construct new ingredientPortionImpl, same ingredient but the sum of amounts and this
		}
	}

}

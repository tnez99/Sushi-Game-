package a4jedi;



public class SalmonPortion extends IngredientPortionImpl{
	
	public SalmonPortion(double amount) {
		super(new Salmon(), amount );

		  if(amount < 0) {
				throw new RuntimeException("Value cannot be negative");

		  }
	}
	@Override
	public IngredientPortion combine(IngredientPortion other) {
		SalmonPortion newCombo = null;
		// TODO Auto-generated method stub
		if(other == null) {
			return this;
		}
		else if(other.getName()==(this.getName())) {
			newCombo = new SalmonPortion(this.getAmount() + other.getAmount());
			return newCombo;
		} 
		else {
			return null;
		}
	}

}


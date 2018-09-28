package a5;

public class SeaweedPortion extends IngredientPortionImpl {
	
	public SeaweedPortion(double amount) {
		super(new Seaweed(), amount );

		  if(amount < 0) {
				throw new RuntimeException("Value cannot be negative");

		  }
	}
	@Override

	public IngredientPortion combine(IngredientPortion other) {
		SeaweedPortion newCombo = null;
		// TODO Auto-generated method stub
		if(other == null) {
			return this;
		}
		else if(other.getName()==(this.getName())) {
			newCombo = new SeaweedPortion(this.getAmount() + other.getAmount());
			return newCombo;
		} 
		else {
			return null;
		}
	}

}
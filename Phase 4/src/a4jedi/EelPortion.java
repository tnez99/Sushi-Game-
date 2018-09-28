package a4jedi;



public class EelPortion extends IngredientPortionImpl {
	
	public EelPortion(double amount) {
		super(new Eel(), amount );

		  if(amount < 0) {
				throw new RuntimeException("Value cannot be negative");

		  }
	}
	@Override

	public IngredientPortion combine(IngredientPortion other) {
		EelPortion newCombo = null;
		// TODO Auto-generated method stub
		if(other == null) {
			return this;
		}
		else if(other.getName()==(this.getName())) {
			newCombo = new EelPortion(this.getAmount() + other.getAmount());
			return newCombo;
		} 
		else {
			return null;
		}
	}

}

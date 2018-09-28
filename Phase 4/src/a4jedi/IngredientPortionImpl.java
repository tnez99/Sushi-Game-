package a4jedi;

public class IngredientPortionImpl implements IngredientPortion {
	
	private Ingredient ingredient;
	private double amount;
	
	
	public IngredientPortionImpl(Ingredient ing, double amount) {
		this.amount = amount;
		ingredient = ing;
		
		if(ing ==null) {
			throw new RuntimeException("Cannot be null");
	}
		if(amount < 0) {
			throw new RuntimeException("Value cannot be negative");
		}
	}

	
	public Ingredient getIngredient() {
		// TODO Auto-generated method stub
		return ingredient;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return ingredient.getName();
	}

	
	public double getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}

	
	public double getCalories() {
		// TODO Auto-generated method stub
		return ingredient.getCaloriesPerOunce() * amount;
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return ingredient.getPricePerOunce()* amount;
	}

	public boolean getIsVegetarian() {
		// TODO Auto-generated method stub
		return ingredient.getIsVegetarian();
	}

	public boolean getIsRice() {
		// TODO Auto-generated method stub
		return ingredient.getIsRice();
	}

	
	public boolean getIsShellfish() {
		// TODO Auto-generated method stub
		return ingredient.getIsShellfish();
	}


	public IngredientPortion combine(IngredientPortion other) {
		// TODO Auto-generated method stub
		if(other == null) {
			return this;
		}
		else if(ingredient == other.getIngredient()) {
			throw new RuntimeException("Illegal Arguments");
		} 
		else {
			double total = other.getAmount() + this.getAmount();
			IngredientPortion ingSum = new IngredientPortionImpl(this.getIngredient(), total);
			return ingSum;
			//construct new ingredientPortionImpl, same ingredient but the sum of amounts and this
		}
	}

}

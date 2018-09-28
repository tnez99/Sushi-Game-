package a4adept;

abstract public class IngredientPortionImpl implements IngredientPortion {
	
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


	abstract public IngredientPortion combine(IngredientPortion other);

}

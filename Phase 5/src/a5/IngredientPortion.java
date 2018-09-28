package a5;

public interface IngredientPortion {
	
	public Ingredient getIngredient();
	public String getName();
	public double getAmount();
	public double getCalories();
	public double getCost();
	public boolean getIsVegetarian();
	public boolean getIsRice();
	public boolean getIsShellfish();
	public IngredientPortion combine(IngredientPortion other);

}

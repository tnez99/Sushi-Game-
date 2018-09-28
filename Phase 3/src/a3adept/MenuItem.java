package a3adept;

public interface MenuItem {

	
	public String getName();
	IngredientPortion[] getIngredients();
	public int getCalories();
	public double getCost();
	public boolean getIsVegetarian();
}

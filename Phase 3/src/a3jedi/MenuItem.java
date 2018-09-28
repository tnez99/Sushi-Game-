package a3jedi;

public interface MenuItem {

	
	public String getName();
	IngredientPortion[] getIngredients();
	public int getCalories();
	public double getCost();
	public boolean getIsVegetarian();
}

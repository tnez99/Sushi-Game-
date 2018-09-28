package a4adept;

public interface Ingredient {
	
	public String getName();
	public double getCaloriesPerDollar();
	public int getCaloriesPerOunce();
	public double getPricePerOunce();
	public boolean equals(Ingredient other);
	public boolean getIsVegetarian();
	public boolean getIsRice();
	public boolean getIsShellfish();
	
}

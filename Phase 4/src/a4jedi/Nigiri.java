package a4jedi;


public class Nigiri implements Sushi {
	
	private static double nigiriSeaFoodAmount = 0.75;
	private static double nigiriRiceAmount = 0.5;
	private IngredientPortion seafood;
	private IngredientPortion rice;
	
	
	public enum NigiriType {TUNA, SALMON, EEL, CRAB, SHRIMP};

	public Nigiri (NigiriType type) {
		
		switch(type) {
		case TUNA:
			seafood = new TunaPortion(nigiriSeaFoodAmount);
			break;
		case SALMON:
			seafood = new SalmonPortion(nigiriSeaFoodAmount);
			break;
		case EEL:
			seafood = new EelPortion(nigiriSeaFoodAmount);
			break;
		case CRAB:
			seafood = new CrabPortion(nigiriSeaFoodAmount);
			break;
		case SHRIMP:
			seafood = new ShrimpPortion(nigiriSeaFoodAmount);
			break;
		}
		
		rice = new RicePortion(nigiriRiceAmount);

		
	}
	public String getName() {
		// TODO Auto-generated method stub
		return seafood.getName() + " nigiri";
	}

	@Override
	public IngredientPortion[] getIngredients() {
		// TODO Auto-generated method stub
		IngredientPortion[] ingredients = new IngredientPortion[] {seafood, rice};
		return ingredients;
	}

	@Override
	public int getCalories() {
		// TODO Auto-generated method stub
		return (int) (seafood.getCalories() + rice.getCalories() + 0.5);
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return (int) (seafood.getCost() + rice.getCost() + 0.5);
	}
	@Override
	public boolean getHasRice() {
		// TODO Auto-generated method stub
		return seafood.getIsRice();
	}

	@Override
	public boolean getHasShellfish() {
		// TODO Auto-generated method stub
		return seafood.getIsShellfish();
	}

	@Override
	public boolean getIsVegetarian() {
		// TODO Auto-generated method stub
		return seafood.getIsVegetarian();
	}

}

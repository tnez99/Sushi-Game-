package a4jedi;

public class Sashimi implements Sushi{
	
	private static double sashimiSeaFoodAmount = 0.75;
	private IngredientPortion seafood;
	
	
public enum SashimiType {TUNA, SALMON, EEL, CRAB, SHRIMP};
	
public Sashimi (SashimiType type) {
	
	switch(type) {
	case TUNA:
		seafood = new TunaPortion(sashimiSeaFoodAmount);
		break;
	case SALMON:
		seafood = new SalmonPortion(sashimiSeaFoodAmount);
		break;
	case EEL:
		seafood = new EelPortion(sashimiSeaFoodAmount);
		break;
	case CRAB:
		seafood = new CrabPortion(sashimiSeaFoodAmount);
		break;
	case SHRIMP:
		seafood = new ShrimpPortion(sashimiSeaFoodAmount);
		break;
	}	
 
	
}

@Override
public String getName() {
	// TODO Auto-generated method stub
	return seafood.getName() + " sashimi";
}

@Override
public IngredientPortion[] getIngredients() {
	// TODO Auto-generated method stub
	IngredientPortion[] ingredients = new IngredientPortion[1] ;
	ingredients[0] = seafood;
	return ingredients;
}

@Override
public int getCalories() {
	// TODO Auto-generated method stub
	return (int) (seafood.getCalories() + 0.5);
}

@Override
public double getCost() {
	// TODO Auto-generated method stub
	return (int) (seafood.getCost() + 0.5);
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

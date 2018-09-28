package a4adept;

import java.util.ArrayList;
import java.util.List;

public class Roll implements Sushi {
	
	private String name;
	private IngredientPortion[] roll_ingredients;
	List<IngredientPortion> ingredients = new ArrayList <IngredientPortion>();

	
	public Roll(String name, IngredientPortion[] roll_ingredients ) {
		this.name = name;
		this.roll_ingredients = roll_ingredients.clone();
		
		
		if(name.equals(null)) {
			throw new RuntimeException("Cannot be null");
		}
		if(roll_ingredients.equals(null)) {
			throw new RuntimeException("Cannot be null");
		}
		
		if(roll_ingredients.length < 0) {
			throw new RuntimeException("Must be bigger than 0");
	}
		for( int i = 0; i < roll_ingredients.length; i++ ) {
			if(roll_ingredients[i].equals(null)) {
				throw new RuntimeException("Cannot be null");
			}
		}
	
	for (int i =0; i < roll_ingredients.length; i++) {
		for(int j = i + 1; j < roll_ingredients.length; j++) {
			if(roll_ingredients[i].equals(roll_ingredients[j])) {
				IngredientPortion newingredient = roll_ingredients[i].combine(roll_ingredients[j]);
				ingredients.add(newingredient);
			} else if (!roll_ingredients[i].equals(roll_ingredients[j])){
				ingredients.add(roll_ingredients[j]);
			} else if (ingredients.contains(roll_ingredients[j])) {
				ingredients.remove(roll_ingredients[j]);
			}
		}
	}
	
	IngredientPortion[] new_ingredients = new IngredientPortion[roll_ingredients.length + 1];
	for(int i = 0; i < roll_ingredients.length; i++) {
		if(roll_ingredients[i].getName().equals(("seaweed"))){
			if((roll_ingredients[i].getAmount() < 0.1))
			new_ingredients[i] = new SeaweedPortion(0.1);
		} else {
			new_ingredients[new_ingredients.length -1] = new SeaweedPortion(0.1);
		}
	}
roll_ingredients = new_ingredients;
		}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}


	@Override
	public IngredientPortion[] getIngredients() {
		// TODO Auto-generated method stub
		return roll_ingredients.clone();
	}


	@Override
	public int getCalories() {
		// TODO Auto-generated method stub
		double sumCalories = 0.0;
		int roundedCalories = 0;
		for(int i = 0; i < roll_ingredients.length; i++) {
			sumCalories += roll_ingredients[i].getCalories();
			roundedCalories = ((int) (sumCalories + 0.5));
		}
		
		return roundedCalories;
	}


	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		double sumCost = 0.0;
		for(int i = 0; i < roll_ingredients.length; i++) {
		sumCost += roll_ingredients[i].getCost();
		sumCost = ((int) ((sumCost * 100.0) + 0.5))/100.0;
		}

		return sumCost;
	}


	@Override
	public boolean getHasRice() {
		// TODO Auto-generated method stub
		for(int i = 0; i < roll_ingredients.length; i++) {
			if(roll_ingredients[i].getIsRice()) {
				return true;
			}
		}

		return false;
	}


	@Override
	public boolean getHasShellfish() {
		// TODO Auto-generated method stub
		for(int i = 0; i < roll_ingredients.length; i++) {
			if(roll_ingredients[i].getIsShellfish()) {
				return true;
			}
		}

		return false;
	}


	@Override
	public boolean getIsVegetarian() {
		// TODO Auto-generated method stub
		for(int i = 0; i < roll_ingredients.length; i++) {
			if(roll_ingredients[i].getIsVegetarian()) {
				return true;
			}
		}

		return false;
	}

	}
	




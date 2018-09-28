package a4jedi;

import java.util.ArrayList;
import java.util.List;

public class Roll implements Sushi {
	
	private String name;
	private IngredientPortion[] roll_ingredients;
	private List<IngredientPortion> ingredients = new ArrayList <IngredientPortion>();
	private IngredientPortion[] new_ingredients;
	
	
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
		boolean item = false;
		for(int j = 0; j < ingredients.size(); j++) {
			if(roll_ingredients[i].getName().equals(ingredients.get(j).getName())) {
				IngredientPortion combined_ingredients = roll_ingredients[i].combine(ingredients.get(j));
				ingredients.set(j, combined_ingredients);
				item = true;	
			}
			
		}
			if(!item) {
				ingredients.add(roll_ingredients[i]);
			}
	}
	
	// IngredientPortion[] new_ingredients = new IngredientPortion[roll_ingredients.length + 1];
	boolean is_there_seaweed = false;
	for(int i = 0; i < ingredients.size(); i++) {
		if(ingredients.get(i).getIngredient().getName().equals(("seaweed"))){
			is_there_seaweed = true;
		if((ingredients.get(i).getAmount()< 0.1)) {
				ingredients.set(i, new SeaweedPortion(0.1));
				is_there_seaweed = true;
			}
		}
	}
		if(!is_there_seaweed) {
			ingredients.add(new SeaweedPortion(0.1));
		}
		new_ingredients = ingredients.toArray(new IngredientPortion[ingredients.size()]);
		} 


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}


	@Override
	public IngredientPortion[] getIngredients() {
		// TODO Auto-generated method stub
		return new_ingredients.clone();
	}


	@Override
	public int getCalories() {
		// TODO Auto-generated method stub
		double sumCalories = 0.0;
		int roundedCalories = 0;
		for(int i = 0; i < this.new_ingredients.length; i++) {
			sumCalories += new_ingredients[i].getCalories();
			roundedCalories = ((int) (sumCalories + 0.5));
		}
		
		return roundedCalories;
	}


	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		double sumCost = 0.0;
		for(int i = 0; i < this.new_ingredients.length; i++) {
		sumCost += new_ingredients[i].getCost();
		sumCost = ((int) ((sumCost * 100.0) + 0.5))/100.0;
		}

		return sumCost;
	}


	@Override
	public boolean getHasRice() {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.new_ingredients.length; i++) {
			if(new_ingredients[i].getIsRice()) {
				return true;
			}
		}

		return false;
	}


	@Override
	public boolean getHasShellfish() {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.new_ingredients.length; i++) {
			if(new_ingredients[i].getIsShellfish()) {
				return true;
			}
		}

		return false;
	}


	@Override
	public boolean getIsVegetarian() {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.new_ingredients.length; i++) {
			if(new_ingredients[i].getIsVegetarian()) {
				return true;
			}
		}

		return false;
	}

	}
	




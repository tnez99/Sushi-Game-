package a3jedi;

public class MenuItemImpl implements MenuItem{
	
	private String name;
	private IngredientPortion[] ingPortArray;
	private int calories;
	private double price;
	private boolean is_vegetarian;
	
	public MenuItemImpl (String name, IngredientPortion[] ingredients) {
		
		ingPortArray = ingredients;
		this.name = name;
		
		if(name.equals(null)) {
			throw new RuntimeException("Cannot be null");
		}
		if(ingredients.equals(null)) {
			throw new RuntimeException("Cannot be null");
		}
		
		if(ingPortArray.length < 0) {
			throw new RuntimeException("Must be bigger than 0");
	}
		for( int i = 0; i < ingPortArray.length; i++ ) {
			if(ingredients[i].equals(null)) {
				throw new RuntimeException("Cannot be null");
			}
		}
		}	
	 

	public String getName() {
		return name;
	}
	
	public IngredientPortion[] getIngredients() {
		return ingPortArray;
	}
	
	
	public int getCalories() {
		double sum = 0;
		for( int i = 0; i < ingPortArray.length; i++ ) {
			sum = (sum + ingPortArray[i].getCalories());
		}
		return (int) sum;	
	}
	
	public double getCost() {
		double sum = 0;
		for( int i = 0; i < ingPortArray.length; i++ ) {
			sum = (sum + ingPortArray[i].getCost());
		}
		return (int) sum;	
	}
	
	
	public boolean getIsVegetarian() {
		for( int i = 0; i < ingPortArray.length; i++ ) {
			if (ingPortArray[i].getIsVegetarian()) {
				return true;
			}
		}

		return false;
	}
	}
	


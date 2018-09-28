package a4novice;

public abstract class IngredientImpl implements Ingredient{

	private String name;
	private double price;
	private int calories;
	private boolean is_vegetarian;
	private boolean is_rice;
	private boolean is_shellfish;

	public IngredientImpl(String name, double price, int calories, boolean is_vegetarian, boolean is_rice, boolean is_shellfish) {

		this.name = name;
		this.price = price;
		this.calories = calories;
		this.is_vegetarian = is_vegetarian;
		this.is_rice = is_rice;
		this.is_shellfish = is_shellfish;
	
	
	
	if(name==null) {
		throw new RuntimeException("Illegal Arguments");
	}
	if(price < 0) {
		throw new RuntimeException("Illegal Arguments");
	}
	if(calories < 0) {
		throw new RuntimeException("Illegal Arguments");

	}
	}


	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public double getCaloriesPerDollar() {
		// TODO Auto-generated method stub
		return calories/price;
	}


	public int getCaloriesPerOunce() {
		// TODO Auto-generated method stub
		return calories;
	}


	public double getPricePerOunce() {
		// TODO Auto-generated method stub
		return price;
	}

	public boolean equals(Ingredient other) {
		boolean isEqual = true;
		if (!getName().equals(other.getName())) {
			isEqual = false;
		}
		
		if (!getIsVegetarian()==(other.getIsVegetarian())) {
			isEqual = false;
		}
		
		if (Math.abs(getPricePerOunce() - (other.getPricePerOunce())) >= 0.01 ){
				isEqual = false;
		}
		
		if (!(getCaloriesPerOunce() == (other.getCaloriesPerOunce()))) {
			isEqual = false;
		}
		
		if (!(getCaloriesPerDollar() == (other.getCaloriesPerDollar()))) {
			isEqual = false;
		}
		if (!getIsRice()==(other.getIsRice())) {
			isEqual = false;
		}
		if (!getIsShellfish()==(other.getIsShellfish())) {
			isEqual = false;
		}
		return isEqual;
		
	
	}
	

	public boolean getIsVegetarian() {
		// TODO Auto-generated method stub
		return is_vegetarian;
	}

	public boolean getIsRice() {
		// TODO Auto-generated method stub
		return is_rice;
	}


	public boolean getIsShellfish() {
		// TODO Auto-generated method stub
		return is_shellfish;
	}





}

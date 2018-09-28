package a3jedi;

import java.util.Arrays;
import java.util.Scanner;


public class A3Jedi  {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int num = s.nextInt();
		IngredientImpl[] ingredients = new IngredientImpl[num];
		for(int i=0; i<num; i++) {
			String name = s.next();
			double price = s.nextDouble();
			boolean is_vegetarian = s.nextBoolean();
			int calories = s.nextInt();

			ingredients[i] = new IngredientImpl(name, price, calories, is_vegetarian);
		}

		int numMenuItems = s.nextInt();
		MenuItemImpl[] menu = new MenuItemImpl[numMenuItems];
		for(int i=0; i< numMenuItems; i++) {
			String name = s.next();
			int ing_num = s.nextInt();
			IngredientPortionImpl[] IngredientPortions = new IngredientPortionImpl[ing_num];
			for(int j=0; j < ing_num; j++) {
				String ing_name = s.next();
				double ing_amount = s.nextDouble();
				for (Ingredient k: ingredients) {
					if (ing_name.equals(k)) {
						IngredientPortions[j] = new IngredientPortionImpl(k, ing_amount);
					}
				}
			
			} 
			
			menu[i] = new MenuItemImpl(name, IngredientPortions);

		}
		IngredientPortionImpl[] Final = new IngredientPortionImpl[num];
		for(int b=0; b<num; b++) {
			Final[b] = new IngredientPortionImpl(ingredients[b], 0);
		}
		
		String menu_name = "";
		int p=0;
		while(!menu_name.equals("End Order")) {
			menu_name = s.next();
			for(int t=0; t<menu.length; t++) {
				if(menu[t].getName().equals(menu_name)) {
					p = t;
					for(int u = 0; u < menu[t].getIngredients().length; u++) {
						for ( int f = 0; f < Final.length; f++) {
							if(Final[f].getName().equals(menu[f].getIngredients()[u].getName())) {
								Final[f] = (IngredientPortionImpl)(Final[f].combine(menu[t].getIngredients()[u]));
							}
						}
					}
				}
			}
		}
		
		
		System.out.println("The order will require:");
			for(int r = 0; r< Final.length; r++) {
				System.out.println(((int)((Final[r].getAmount()* 100.0)+0.5))/100.0 + "" + "ounces of" + "" + Final[r].getName());			
				
			}

	}	
	



}

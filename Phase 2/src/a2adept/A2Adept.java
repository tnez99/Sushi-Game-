package a2adept;

import java.util.Scanner;

public class A2Adept {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		// Your code goes here.
		int ingredient_amount = 0;
		ingredient_amount = s.nextInt();
		String[] ingredient_name = new String[ingredient_amount];
		double[] price_per_ounce = new double [ingredient_amount] ;
		boolean[] is_vegetarian = new boolean [ingredient_amount];
		int[] calories_per_ounce = new int [ingredient_amount];
		int vegetarian_amount = 0;
		double[] calories_per_dollar = new double [ingredient_amount];
		int number_menu_items = 0;
	
		
		
	for(int j = 0; j < ingredient_amount; j++ ) {
		ingredient_name[j] = s.next();
		price_per_ounce[j] = s.nextDouble();
		is_vegetarian[j] = s.nextBoolean();
		calories_per_ounce[j] = s.nextInt();
		calories_per_dollar[j]= (calories_per_ounce[j] / price_per_ounce[j]);
	}

		number_menu_items = s.nextInt();
		

		String[] menu_name = new String[number_menu_items];
		
		// taking in the number of menu items, cycling through the number of menus
		for(int k = 0; k < number_menu_items; k++ ) {
			
			//System.out.println("loop running");


			menu_name[k] = s.next();
			int number_item_ingredients = 0;
			number_item_ingredients = s.nextInt();
			String[] item_ingredients = new String[number_item_ingredients];
			double[] ounces_amount = new double[number_item_ingredients];
			
			
			double calories_amount = 0.0;
			double cost_amount = 0.0;
			boolean roll_is_vegetarian = true;
			// cycling through the amount of ingredients being used, and which ones that we are using
			for(int b = 0; b < number_item_ingredients; b++) {
				item_ingredients[b] = s.next();
				ounces_amount[b] = s.nextDouble();
				
				//System.out.println("loop 2 running");

				
				// cycling through the amount of ingredients from the first list, trying to find a matching one
				for(int m = 0; m < ingredient_amount; m++) {
					
					
					// if the ingredient name matches
					if (item_ingredients[b].equals(ingredient_name[m])) {
						// multiplying calories per ounce by the amount of ounces
						calories_amount += (calories_per_ounce[m] * ounces_amount[b]);
						// int calories_amount + 0.5;
						cost_amount += (price_per_ounce[m] * ounces_amount[b]); 
						if (!is_vegetarian[m] ) {
							roll_is_vegetarian = false;
							

					}
						
					}

					
				}

			}
			System.out.println(menu_name[k] + ":");
			System.out.println(Math.round(calories_amount) + " calories ");
			System.out.println("$"+((int) ((cost_amount * 100.0)+0.5))/100.0);
			if (roll_is_vegetarian) {
				System.out.println("Vegetarian");

			} else {
				System.out.println("Non-Vegetarian");

			}
		}
		
		
	}



	}






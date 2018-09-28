package a2novice;

import java.util.Scanner;

public class A2Novice {

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
		double highest_ratio = Double.MIN_VALUE;
		double lowest_ratio = Double.MAX_VALUE;
		int high_index_variable = 0;
		int low_index_variable = 0;
		
		
		for(int j = 0; j < ingredient_amount; j++ ) {
			ingredient_name[j] = s.next();
			price_per_ounce[j] = s.nextDouble();
			is_vegetarian[j] = s.nextBoolean();
			calories_per_ounce[j] = s.nextInt();
			calories_per_dollar[j]= (calories_per_ounce[j] / price_per_ounce[j]);
			

			if (is_vegetarian[j]) {
				vegetarian_amount++;
			
			}
		}
			
			
			for(int i = 0; i < ingredient_amount; i++ ) {

			if (calories_per_dollar[i] > highest_ratio) {
				highest_ratio = calories_per_dollar[i]; 
				high_index_variable = i;
			}
			
			
			if (calories_per_dollar[i] < lowest_ratio) {
				lowest_ratio = calories_per_dollar[i];
				low_index_variable = i;
			}
			

			}
			System.out.println("Number of vegetarian ingredients: " + vegetarian_amount );
			System.out.println("Highest cals/$: " + ingredient_name[high_index_variable]);
			System.out.println("Lowest cals/$: " + ingredient_name[low_index_variable]);
		}



	}





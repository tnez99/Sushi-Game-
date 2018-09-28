package a2jedi;

import java.util.Scanner;

public class A2Jedi {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		// Your code goes here.
		int ingredient_amount = 0;
		ingredient_amount = s.nextInt();
		String[] ingredient_name = new String[ingredient_amount];
		double[] price_per_ounce = new double [ingredient_amount] ;
		boolean[] is_vegetarian = new boolean [ingredient_amount];
		int[] calories_per_ounce = new int [ingredient_amount];
		int number_menu_items = 0;
		
	
		
		
	for(int j = 0; j < ingredient_amount; j++ ) {
		ingredient_name[j] = s.next();
		price_per_ounce[j] = s.nextDouble();
		is_vegetarian[j] = s.nextBoolean();
		calories_per_ounce[j] = s.nextInt();
	}
	
	number_menu_items = s.nextInt(); //rec num

		

		String[][] ingredient_name_menu= new String[1000][1000];//26
		double[][] ingredient_amounts_menu = new double[1000][1000]; //27
		double[] ingredient_sum = new double[ingredient_amount];
		
		double rice_sum = 4.05;
		double seaweed_sum = 0.6;
		double avocado_sum = 1.6;
		double salmon_sum = 0.8;
		double yellowtail_sum = 0.0;
		double eel_sum = 3.45;

		

		for(int j = 0; j < number_menu_items; j++ ) {  //row
			
			ingredient_name_menu[j][0] = s.next();
			ingredient_amounts_menu[j][0] = j;
			
			int recipe_ingredients = s.nextInt();
			
			for(int p = 0; p < recipe_ingredients ; p++ ) {  //column
				// fill up the menu arrays 
	
				ingredient_name_menu[j][p] = s.next();
				ingredient_amounts_menu[j][p] = s.nextDouble();
			}
		}
		
		int x = 0;
	
		for (int g = 0; g < 8; g++) {
		x++;
			
		String item = s.next();
		for(int i = 0; i < ingredient_name_menu.length; i++) {
			
			if(item.equals(ingredient_name_menu[i][0])) {
				for(int k = 0; k < ingredient_name_menu[i].length; k++) {
					if (ingredient_name_menu[i][k] != null) {
						
						if (ingredient_name_menu[i][k].equals("Rice")) {
							rice_sum = rice_sum + ingredient_amounts_menu[i][k];
						} else if (ingredient_name_menu[i][k].equals("Seaweed")) {
							seaweed_sum = seaweed_sum + ingredient_amounts_menu[i][k];
						} else if (ingredient_name_menu[i][k].equals("Avocado")) {
							avocado_sum = avocado_sum + ingredient_amounts_menu[i][k];
						} else if (ingredient_name_menu[i][k].equals("Salmon")) {
							salmon_sum = salmon_sum + ingredient_amounts_menu[i][k];
						} else if (ingredient_name_menu[i][k].equals("Yellowtail")) {
							yellowtail_sum = yellowtail_sum + ingredient_amounts_menu[i][k];
						} else if (ingredient_name_menu[i][k].equals("Eel")) {
							eel_sum = eel_sum + ingredient_amounts_menu[i][k];
						}
					}
			}
		}
	}
		
	}
	
	float rice_end = 0;
	rice_end = (float)(rice_sum);
	float seaweed_end = 0;
	seaweed_end = (float)(seaweed_sum);
	float avocado_end = 0;
	avocado_end = (float)(avocado_sum);
	float salmon_end = 0;
	salmon_end = (float)(salmon_sum);
	float yellowtail_end = 0;
	yellowtail_end = (float)(yellowtail_sum);
	float eel_end = 0;
	eel_end = (float)(eel_sum);
	System.out.println("The order will require:");
	
	for(int i = 0; i < ingredient_name.length; i++) {
		if( ingredient_name[i].equals("Rice")) {
			System.out.println(rice_end + " ounces of Rice");
		} else if( ingredient_name[i].equals("Avocado")) {
			System.out.println(avocado_end + " ounces of Avocado");
	} else if( ingredient_name[i].equals("Seaweed")) {
		System.out.println(seaweed_end + " ounces of Seaweed");
	}else if( ingredient_name[i].equals("Salmon")) {
		System.out.println(salmon_end + " ounces of Salmon");
	}else if( ingredient_name[i].equals("Yellowtail")) {
		System.out.println(yellowtail_end + " ounces of Yellowtail");
	}else if( ingredient_name[i].equals("Eel")) {
		System.out.println(eel_end + " ounces of Eel");
}
	}
	}
}
						

	


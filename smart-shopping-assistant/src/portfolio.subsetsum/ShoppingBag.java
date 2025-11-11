package portfolio.subsetsum;

import java.util.ArrayList;
import java.util.Scanner;

import portfolio.music.TimeConverter;



public class ShoppingBag 
{
	private ArrayList<Double> priceOfGroceries;

	
	public ShoppingBag(String filePath)
	{
		
		GroceriesFileReader reader = new GroceriesFileReader();

		
		priceOfGroceries = reader.readFile(filePath);

		
		if (priceOfGroceries.size() < 1) 
		{
			System.out.println("WARNING: The list of groceries is empty.");
			return;
		} 

		System.out.printf("The list of groceries has %d items. \n", priceOfGroceries.size());

	}


	/**
	 * Accessor method returns the list of items read from input file.
	 * @return	the price of groceries.
	 */
	public ArrayList<Double> getPriceOfGroceries()
	{
		return priceOfGroceries;
	}

	/**
	 * Reads an input file that contains the prices of the different items.
	 * Then stores and outputs a list of items we can buy
	 * given the condition of how much money you have in your wallet.
	 * We're at a cash only store. So, no checks or credit purchases!
	 * @param args	Not used.
	 */
	public static void main(String[] args) 
	{
		final String FILEPATH = "resources/input02.txt";

		ShoppingBag bag = new ShoppingBag(FILEPATH);
		ArrayList<Double> shoppingList = bag.getPriceOfGroceries();

		
		System.out.println("Groceries wanted:");
		System.out.println(shoppingList);

		
		Scanner keyboard = new Scanner(System.in);
		double budget = -1;
		do 
		{
			System.out.println("\nEnter your budget:");
			String input = keyboard.nextLine();
			
			String validInputPattern = "[0-9]+[0-9]*.*[0-9]*";
			
			if (!input.matches(validInputPattern))
			{
				System.out.println("Invalid input " + input);
				System.out.println("Enter a numeric value for the budget.");
				continue;
			}
			budget = Double.parseDouble(input);
		} while(budget < 0);

	
		long startTime, estimatedTime;
				
		
		startTime = System.nanoTime();    

		
		ArrayList<Double> purchases = SubsetSum.findSubset(shoppingList, budget);

		// stop the timer
		estimatedTime = System.nanoTime() - startTime;
		
		// report algorithm time
		System.out.println("\nAlgorithm Elapsed Time: "
				+ TimeConverter.convertTimeToString(estimatedTime));

		System.out.println("Purchased grocery prices are:");
		System.out.println(purchases);
		
		System.err.flush();
		System.out.println("Done with ShoppingBag.");
	}
}

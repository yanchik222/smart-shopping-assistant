package portfolio.subsetsum;

import java.util.ArrayList;

/**
 * Finds the combination of grocery prices whose total is closest to a given budget.
 * Author: Yana Loviagina
 */
public class SubsetSum {
    /**
     * This findSubset method finds the closest sum to the target are correct.
     * @param shoppingList list of the prices
     * @param target the budget
     * @return the list of the prices that the closest to the target
     */
    public static ArrayList<Double> findSubset(ArrayList<Double> shoppingList, double target) {
        ArrayList<Double> subset = new ArrayList<>();
        double closestSum = Double.MAX_VALUE;
        int n = shoppingList.size();

        for (int i = 0; i < Math.pow(2, n); i++) {
            double currentSum = 0;
            ArrayList<Double> currentSubset = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((i / (int)Math.pow(2, j)) % 2 == 1) {
                    currentSum += shoppingList.get(j);
                    currentSubset.add(shoppingList.get(j));
                }
            }


            if (currentSum <= target && Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                closestSum = currentSum;
                subset = new ArrayList<>(currentSubset);
            }
        }

        return subset;
    }

}
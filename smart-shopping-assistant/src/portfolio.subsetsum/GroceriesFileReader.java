package portfolio.subsetsum;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *This class reads the groceries file and contains method readFile
 */
public class GroceriesFileReader {

    GroceriesFileReader()
    {

    };

    /**
     * This readFile method reads the CSV (Comma Separated Value) file
     * of groceries and creates a specified ArrayList of grocery prices.
     * @param filePath the path to the groceries and their prices file
     * @return list of grocery prices
     */
    public static ArrayList<Double> readFile(String filePath) {
        ArrayList<Double> priceOfGroceries = new ArrayList<>();

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    double price = Double.parseDouble(parts[1].trim());
                    priceOfGroceries.add(price);
                } else {
                    System.err.println("Invalid format");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Cannot format price to double.");
            e.printStackTrace();
        }

        return priceOfGroceries;
    }
}
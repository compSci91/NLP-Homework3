import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        File file = new File("/Users/JoshuaHowell/Desktop/Texas A&M/Year 2/Fall 2018/Natural Language Processing/pa3-cky/grammar_rules.txt");

        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        Set<ProductionRule> productionRules = new HashSet<ProductionRule>();

        while (fileScanner.hasNextLine()) {
            String productionString = fileScanner.nextLine();

            ProductionRule newProduction = new ProductionRule(productionString);

            System.out.println(newProduction);

            productionRules.add(newProduction);
           //  System.out.println( fileScanner.nextLine());

        }
    }
}

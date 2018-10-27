import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        File grammarFile = new File("/Users/JoshuaHowell/Desktop/Texas A&M/Year 2/Fall 2018/Natural Language Processing/pa3-cky/grammar_rules.txt");
       // File grammarFile = new File(args[0]);


        File sentsFile = new File("/Users/JoshuaHowell/Desktop/Texas A&M/Year 2/Fall 2018/Natural Language Processing/pa3-cky/sents.txt");

       // File sentsFile = new File(args[1]);

        Grammar grammar = new Grammar(grammarFile);

        Scanner sentsScanner = null;
        try {
            sentsScanner = new Scanner(sentsFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> words = new ArrayList<String>();

        while(sentsScanner.hasNext()){
            words.add(sentsScanner.next());
        }

        ProductionRuleList[][] productionRules = new Parser().ckyParse(words, grammar);


        new Printer().print(productionRules, words);



    }

}

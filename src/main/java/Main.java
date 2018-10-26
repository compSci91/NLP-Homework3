import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        File grammarFile = new File("/Users/JoshuaHowell/Desktop/Texas A&M/Year 2/Fall 2018/Natural Language Processing/pa3-cky/grammar_rules.txt");

        Grammar grammar = new Grammar(grammarFile);

        File sentsFile = new File("/Users/JoshuaHowell/Desktop/Texas A&M/Year 2/Fall 2018/Natural Language Processing/pa3-cky/sents.txt");

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


        System.out.println(productionRules[0][1]);


    }

}

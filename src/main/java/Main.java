import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) { //4b64d699-5b90-4150-a1c4-d3d3b8b12a5b

        //File grammarFile = new File("/Users/JoshuaHowell/Desktop/Texas A&M/Year 2/Fall 2018/Natural Language Processing/pa3-cky/grammar_rules.txt");
         File grammarFile = new File(args[0]);


        //File sentsFile = new File("/Users/JoshuaHowell/Desktop/Texas A&M/Year 2/Fall 2018/Natural Language Processing/pa3-cky/sents.txt");

        File sentsFile = new File(args[1]);

        Grammar grammar = new Grammar(grammarFile);

        Scanner sentsScanner = null;
        try {
            sentsScanner = new Scanner(sentsFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        while (sentsScanner.hasNextLine()) {
                String sentence = sentsScanner.nextLine();

                Scanner sentenceScanner = new Scanner(sentence);

                List<String> words = new ArrayList<String>();

            while (sentenceScanner.hasNext()) {
                words.add(sentenceScanner.next());
            }

            ProductionRuleList[][] productionRules = new Parser().ckyParse(words, grammar);


            new Printer().print(productionRules, words);

            System.out.println();
            System.out.println("**********");
            System.out.println();
    }


    }

}

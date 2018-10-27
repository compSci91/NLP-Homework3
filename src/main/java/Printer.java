import java.util.List;

public class Printer {
    public void print(ProductionRuleList[][] productionRules, List<String> words){

        for(int i = 0; i < words.size(); i++){
            System.out.println("SPAN: " + words.get(i));
            System.out.println(productionRules[i][i+1]);


        }


    }
}

import java.util.List;

public class Printer {
    public void print(ProductionRuleList[][] productionRules, List<String> words) {


        for (int lengthOfSpan = 1; lengthOfSpan <= words.size(); lengthOfSpan++) {
            for (int beginOfSpan = 0; beginOfSpan < words.size(); beginOfSpan++) {
                int endOfSpan = beginOfSpan + lengthOfSpan;

                if(endOfSpan < words.size() + 1) {

                    System.out.print("SPAN: ");
                    for (int i = beginOfSpan; i < beginOfSpan + lengthOfSpan; i++) {
                        System.out.print(words.get(i) + " ");
                    }

                    System.out.println();
                    System.out.println(productionRules[beginOfSpan][beginOfSpan + lengthOfSpan]);

                }
            }
        }


    }
}

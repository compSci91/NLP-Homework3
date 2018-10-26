import java.util.List;

public class Parser {
    public ProductionRuleList[][] ckyParse(List<String> words, Grammar grammar){
        ProductionRuleList[][] table = new ProductionRuleList[words.size() + 1][words.size() + 1];

        for(int j = 1; j<=words.size(); j++){
            List<ProductionRule> productionRules = grammar.retrieveProductionRules(words.get(j-1));

            ProductionRuleList productionRuleList = new ProductionRuleList(productionRules);
            table[j-1][j] = productionRuleList;


//            for(int productionRuleNumber = 0; productionRuleNumber<productionRules.size(); productionRuleNumber++){
//               ProductionRule productionRule = productionRules.get(productionRuleNumber);
//
//                //System.out.println(productionRule);
//                table[j-1][j][productionRuleNumber] = productionRule;
//            }


//
//            for(int i = j-2; j>=0; j--){
//                for(int k = i + 1; k<=j-1; k++){
//
//
//                }
//            }










        }

        return table;
    }
}

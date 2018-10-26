import java.util.List;

public class Parser {
    public ProductionRule[][][] ckyParse(List<String> words, Grammar grammar){
        ProductionRule[][][] table = new ProductionRule[words.size() + 1][words.size() + 1][10];

        for(int j = 1; j<=words.size(); j++){
            List<ProductionRule> productionRules = grammar.retrieveProductionRules(words.get(j-1));

            for(int productionRuleNumber = 0; productionRuleNumber<productionRules.size(); productionRuleNumber++){
                table[j-1][j][productionRuleNumber] = productionRules.get(productionRuleNumber);
            }
        }

        return table;
    }
}

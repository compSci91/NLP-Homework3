import java.util.ArrayList;
import java.util.List;

public class Parser {
    public ProductionRuleList[][] ckyParse(List<String> words, Grammar grammar){
        ProductionRuleList[][] table = new ProductionRuleList[words.size() + 1][words.size() + 1];

        for(int row = 0; row<words.size()+1; row++){
            for(int col = 0; col<words.size()+1; col++){

                table[row][col] = new ProductionRuleList(new ArrayList<ProductionRule>());
            }
        }


        List<ProductionRule> productionRulesWithNonTerminals = grammar.retrieveProductionRulesWithTwoNonTerminals();


        for(int j = 1; j<=words.size(); j++){
            List<ProductionRule> productionRulesWithTerminals = grammar.retrieveProductionRules(words.get(j-1));

            ProductionRuleList productionRuleList = new ProductionRuleList(productionRulesWithTerminals);
            table[j-1][j] = productionRuleList;


            //need to handle unary!

            boolean someWereAdded = true;
            while(someWereAdded){

                someWereAdded = false;
                List<ProductionRule> unaryProductionRules = grammar.retrieveProductionRulesWithOneNonTerminal();

                for(ProductionRule unaryProductionRule : unaryProductionRules){
                    String nonTerminal = unaryProductionRule.getFirstNonTerminal();

                    if (productionRuleList.hasProductionRuleWithLeftHandSide(nonTerminal)) {
                        double foundProductionRuleProbability = productionRuleList.getProbabilityForProductionRuleWithLeftHandSide(nonTerminal);
                        double unaryProductionRuleProbability = unaryProductionRule.getProbability();


                        ProductionRule newUnaryProductionRule = unaryProductionRule.createNewProductionRule(foundProductionRuleProbability * unaryProductionRuleProbability);
                        if(!table[j-1][j].contains(newUnaryProductionRule)){
                            table[j-1][j].add(newUnaryProductionRule);
                            someWereAdded = true;
                        }


                    }
                }


            }




//            for(int i = j-2; i>=0; i--){
//                for(int k = i + 1; k<=j-1; k++){
//                    for(ProductionRule productionRuleWithNonTerminal : productionRulesWithNonTerminals) {
//
//                        try {
//                            String bProductionString = productionRuleWithNonTerminal.getFirstNonTerminal();
//                            String cProductionString = productionRuleWithNonTerminal.getSecondtNonTerminal();
//
//                            ProductionRuleList ikProductionRuleList = table[i][k];
//                            ProductionRuleList kjProductionRuleList = table[k][j];
//
//                            if (ikProductionRuleList.hasProductionRuleWithLeftHandSide(bProductionString) && kjProductionRuleList.hasProductionRuleWithLeftHandSide(cProductionString)) {
//                                double ikProbability = ikProductionRuleList.getProbabilityForProductionRuleWithLeftHandSide(bProductionString);
//                                double kjProbability = kjProductionRuleList.getProbabilityForProductionRuleWithLeftHandSide(cProductionString);
//                                double productRuleProbability = productionRuleWithNonTerminal.getProbability();
//
//                                ProductionRule newProductRule = productionRuleWithNonTerminal.createNewProductionRule(ikProbability * kjProbability * productRuleProbability);
//
//                                table[i][j].add(newProductRule);
//
//
//                            }
//                        } catch(ArrayIndexOutOfBoundsException e){
//                            //do nothing
//                        }
//
//                    }
//
//
//
//                }
//           }










        }

        return table;
    }
}

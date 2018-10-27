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
                        if(table[j-1][j].contains(newUnaryProductionRule)){

                        } else {



                            table[j-1][j].add(newUnaryProductionRule);
                            someWereAdded = true;
                        }


                    }
                }


            }




            for(int i = j-2; i>=0; i--){
                for(int k = i + 1; k<=j-1; k++){
                    for(ProductionRule productionRuleWithNonTerminal : productionRulesWithNonTerminals) {

//                        try { // HANDLE UNARIES
//                            someWereAdded = true;
//                            while(someWereAdded){
//
//                                someWereAdded = false;
//                                List<ProductionRule> unaryProductionRules = grammar.retrieveProductionRulesWithOneNonTerminal();
//
//                                for(ProductionRule unaryProductionRule : unaryProductionRules){
//                                    String nonTerminal = unaryProductionRule.getFirstNonTerminal();
//
//                                    if (productionRuleList.hasProductionRuleWithLeftHandSide(nonTerminal)) {
//                                        double foundProductionRuleProbability = productionRuleList.getProbabilityForProductionRuleWithLeftHandSide(nonTerminal);
//                                        double unaryProductionRuleProbability = unaryProductionRule.getProbability();
//
//
//                                        ProductionRule newUnaryProductionRule = unaryProductionRule.createNewProductionRule(foundProductionRuleProbability * unaryProductionRuleProbability);
//
//                                        if(table[i][j].contains(newUnaryProductionRule)){
//
//                                        }
//
//
////                                        else if(table[i][j].containsWithSameLeftHandSide(newUnaryProductionRule)) {
////                                            ProductionRule productionRuleWithSameLeftHandSide = table[i][j].getProductionRuleWithSameLeftHandSide(newUnaryProductionRule);
////
////                                            if(newUnaryProductionRule.getProbability() > productionRuleWithSameLeftHandSide.getProbability()){
////                                                table[i][j].replaceProductionRuleWithSameLeftHandSide(newUnaryProductionRule);
////                                                someWereAdded = true;
////                                            }
////
////                                        }
//
//
//                                        else {
//                                            table[i][j].add(newUnaryProductionRule);
//                                            someWereAdded = true;
//                                        }
//
//
//                                    }
//                                }
//
//
//                            }
//                        } catch(ArrayIndexOutOfBoundsException e){
//                            //do nothing
//                        }






                        try { // HANDLE PRODUCTION RULES WITH TWO NON-TERMINALS

                            someWereAdded = true;
                            while(someWereAdded){
                                someWereAdded = false;
                                String bProductionString = productionRuleWithNonTerminal.getFirstNonTerminal();
                                String cProductionString = productionRuleWithNonTerminal.getSecondtNonTerminal();

                                ProductionRuleList ikProductionRuleList = table[i][k];
                                ProductionRuleList kjProductionRuleList = table[k][j];

                                if (ikProductionRuleList.hasProductionRuleWithLeftHandSide(bProductionString) && kjProductionRuleList.hasProductionRuleWithLeftHandSide(cProductionString)) {
                                    double ikProbability = ikProductionRuleList.getProbabilityForProductionRuleWithLeftHandSide(bProductionString);
                                    double kjProbability = kjProductionRuleList.getProbabilityForProductionRuleWithLeftHandSide(cProductionString);
                                    double productRuleProbability = productionRuleWithNonTerminal.getProbability();

                                    ProductionRule newProductionRule = productionRuleWithNonTerminal.createNewProductionRule(ikProbability * kjProbability * productRuleProbability);

//                                    if(!table[i][j].contains(newProductRule)) {
//                                        table[i][j].add(newProductRule);
//                                        someWereAdded = true;
//                                    }

                                    if(table[i][j].contains(newProductionRule)){ //table does not contain the exact same production rule
            //do nothing
                                    }


//                                    else if(table[i][j].containsWithSameLeftHandSide(newProductionRule)) { //is there a productionRule for the same nonterminal?
//                                        ProductionRule productionRuleWithSameLeftHandSide = table[i][j].getProductionRuleWithSameLeftHandSide(newProductionRule); // if there is, get it.
//
//                                        if(newProductionRule.getProbability() > productionRuleWithSameLeftHandSide.getProbability()){ //does the new productRule have the same left hand side but a higher probability if you follow it?
//                                            table[i][j].replaceProductionRuleWithSameLeftHandSide(newProductionRule); //if so, replace the one that was there before
//                                            someWereAdded = true; //mark that one was added
//                                        }
//
//                                    }


                                    else {
                                        table[i][j].add(newProductionRule);
                                        someWereAdded = true;
                                    }

                                }
                            }
                        } catch(ArrayIndexOutOfBoundsException e){
                            //do nothing
                        }


                        //HANDLE UNARIES


                        List<ProductionRule> unaryProductionRules = grammar.retrieveProductionRulesWithOneNonTerminal();

                        ProductionRuleList ijProductionRuleList = table[i][j];
                        List<ProductionRule> ijProductionRules = ijProductionRuleList.getProductionRules();

                        for(ProductionRule unaryProductionRule : unaryProductionRules){
                                    String rightHandSide = unaryProductionRule.getFirstNonTerminal();

                                    if (ijProductionRuleList.hasProductionRuleWithLeftHandSide(rightHandSide)) {
                                        double foundProductionRuleProbability = ijProductionRuleList.getProbabilityForProductionRuleWithLeftHandSide(rightHandSide);
                                        double unaryProductionRuleProbability = unaryProductionRule.getProbability();


                                        ProductionRule newUnaryProductionRule = unaryProductionRule.createNewProductionRule(foundProductionRuleProbability * unaryProductionRuleProbability);

                                        if(table[i][j].contains(newUnaryProductionRule)){

                                        }


                                        else if(table[i][j].containsWithSameLeftHandSide(newUnaryProductionRule)) {
                                            ProductionRule productionRuleWithSameLeftHandSide = table[i][j].getProductionRuleWithSameLeftHandSide(newUnaryProductionRule);

                                            if(newUnaryProductionRule.getProbability() > productionRuleWithSameLeftHandSide.getProbability()){
                                                table[i][j].replaceProductionRuleWithSameLeftHandSide(newUnaryProductionRule);
                                                //someWereAdded = true;
                                            }

                                        }


                                        else {
                                            table[i][j].add(newUnaryProductionRule);
                                          //  someWereAdded = true;
                                        }


                                    }
                                }


                    }



                }
           }










        }

        return table;
    }
}

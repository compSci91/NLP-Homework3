import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Grammar {
    private List<ProductionRule> productionRules;

    public Grammar(List<ProductionRule> productionRules){
        this.productionRules = productionRules;
    }

    public boolean contains(ProductionRule productionRule){
        return this.productionRules.contains(productionRule);
    }

    public ArrayList<ProductionRule> retrieveProductionRules(String rightHandSide){
        ArrayList<ProductionRule> productionRulesToReturn = new ArrayList<ProductionRule>();


            for (ProductionRule productionRule : this.productionRules) {
                if (productionRule.hasRightHandSideTerminal(rightHandSide)) {
                    productionRulesToReturn.add(productionRule);
                }

            }

            return productionRulesToReturn;

    }

    @Override
    public String toString(){
        String string = "";

        for (ProductionRule productionRule : this.productionRules) {
            string += productionRule.toString() + "\n";
        }

        return string;
    }

}

import java.rmi.activation.ActivationGroup_Stub;
import java.util.List;

public class ProductionRuleList {
    private List<ProductionRule> productionRuleList;
    private List<ProductionRule> productionRules;

    public ProductionRuleList(List<ProductionRule> productionRuleList){
        this.productionRuleList = productionRuleList;
    }

    public boolean hasProductionRuleWithLeftHandSide(String leftHandSide){
        for(ProductionRule productionRule : productionRuleList){
            if(productionRule.hasLeftHandSide(leftHandSide)){
                return true;
            }
        }

        return false;
    }

    public boolean containsWithSameLeftHandSide(ProductionRule productionRuleToTest) {
        for(ProductionRule productionRule : productionRuleList){
            if(productionRule.getLeftHandSide().equals(productionRuleToTest.getLeftHandSide())){
                return true;
            }
        }

        return false;
    }

    public ProductionRule getProductionRuleWithSameLeftHandSide(ProductionRule productionRuleToTest) {
        for(ProductionRule productionRule : productionRuleList){
            if(productionRule.getLeftHandSide().equals(productionRuleToTest.getLeftHandSide())){
               return productionRule;
            }
        }

        return null;
    }

    public boolean contains(ProductionRule productionRule){
        return productionRuleList.contains(productionRule);


    }

    public ProductionRule getProductionRuleWithSameLeftHandSide(String leftHandSide){
        for(ProductionRule productionRule : productionRuleList){
            if(productionRule.getLeftHandSide().equals(leftHandSide)){
                return productionRule;
            }
        }

        return null;
    }

    public void replaceProductionRuleWithSameLeftHandSide(ProductionRule productionRule){
        for(int i = 0; i < productionRuleList.size(); i++) {
            if(productionRuleList.get(i).getLeftHandSide().equals(productionRule.getLeftHandSide())){
                productionRuleList.set(i, productionRule);
            }
        }
    }
    public boolean add(ProductionRule productionRule){
        return productionRuleList.add(productionRule);
    }

    public double getProbabilityForProductionRuleWithLeftHandSide(String leftHandSide){
        for(ProductionRule productionRule : productionRuleList){
            if(productionRule.hasLeftHandSide(leftHandSide)){
                return productionRule.getProbability();
            }
        }

        return -1000000;
    }

    @Override
    public String toString(){
        String string = "";

        for (ProductionRule productionRule : this.productionRuleList) {
            string += productionRule.toString() + "\n";
        }

        return string;
    }


    public List<ProductionRule> getProductionRules() {
        return productionRules;
    }
}

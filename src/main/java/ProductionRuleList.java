import java.util.List;

public class ProductionRuleList {
    private List<ProductionRule> productionRuleList;

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

    public boolean contains(ProductionRule productionRule){
        return productionRuleList.contains(productionRule);

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

}

import java.util.List;

public class ProductionRuleList {
    private List<ProductionRule> productionRuleList;

    public ProductionRuleList(List<ProductionRule> productionRuleList){
        this.productionRuleList = productionRuleList;
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

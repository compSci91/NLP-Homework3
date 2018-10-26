import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductionRule {
    private String leftHandSide;
    private List<String> rightHandSide;
    private double probability;

    public ProductionRule(String leftHandSide, List<String> rightHandSide, double probablitilty){
        this.leftHandSide = leftHandSide;
        this.rightHandSide = rightHandSide;
        this.probability = probablitilty;
    }

    public ProductionRule(String productionString){
        Scanner productionStringScanner = new Scanner(productionString);

        List<String> tokens = new ArrayList<String>();

        while(productionStringScanner.hasNext()){
            tokens.add(productionStringScanner.next());
        }

        this.leftHandSide = tokens.get(0);
        this.rightHandSide = tokens.subList(1 , tokens.size()-1);
        this.probability = Double.parseDouble(tokens.get(tokens.size()-1));


    }

    public boolean hasRightHandSideTerminal(String rightHandSide) {
        if(this.rightHandSide.size() == 1 && this.rightHandSide.get(0).equals(rightHandSide)){
            return true;
        }
        return false;
    }

    public boolean hasLeftHandSide(String leftHandSide){
        return this.leftHandSide == leftHandSide;
    }

    public String getLeftHandSide(){
        return this.leftHandSide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductionRule otherProductionRule = (ProductionRule) o;

        if(this.leftHandSide != otherProductionRule.leftHandSide){
            return false;
        }

        if(this.rightHandSide.size() != otherProductionRule.rightHandSide.size()){
            return false;
        }

        for(String productionString : rightHandSide){
            if(!otherProductionRule.rightHandSide.contains(productionString))
                return false;
        }

        return true;

    }

    @Override
    public int hashCode() {
        int result = leftHandSide != null ? leftHandSide.hashCode() : 0;
        result = 31 * result + (rightHandSide != null ? rightHandSide.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return this.leftHandSide + "  ==>  " + rightHandSide + "   " + probability;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductionRule {
    private String leftHandSide;
    private List<String> rightHandSide;
    private double probability;
    private int split;

    public ProductionRule(String leftHandSide, List<String> rightHandSide, double probablitilty){
        this.leftHandSide = leftHandSide;
        this.rightHandSide = rightHandSide;
        this.probability = probablitilty;

        this.split = -1;
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

    public boolean hasRightHandSideOfOneNonTerminal(){
        return this.rightHandSide.size() == 1;
    }

    public boolean hasRightHandSideOfNonTerminals(){
        return this.rightHandSide.size() == 2;
    }

    public boolean hasLeftHandSide(String leftHandSide){
        return this.leftHandSide.equals(leftHandSide);
    }

    public String getFirstNonTerminal(){
        return rightHandSide.get(0);
    }

    public String getSecondtNonTerminal(){
        return rightHandSide.get(1);
    }

    public double getProbability(){
        return probability;
    }

    public ProductionRule createNewProductionRule(double probability){
        return new ProductionRule(this.leftHandSide, this.rightHandSide, probability);
    }

    public String getLeftHandSide(){
        return this.leftHandSide;
    }

    public void setSplit(int split){
        this.split = split;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductionRule otherProductionRule = (ProductionRule) o;

        if(!this.leftHandSide.equals(otherProductionRule.leftHandSide)) {
            return false;
        }

        if(this.rightHandSide.size() != otherProductionRule.rightHandSide.size()){
            return false;
        }

        for (int i = 0; i < rightHandSide.size(); i++){
            if(!rightHandSide.get(i).equals(otherProductionRule.rightHandSide.get(i))){
                return false;
            }
        }

        if(probability != otherProductionRule.probability){
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

    private boolean isRightHandSideNonTerminal(){
        return rightHandSide.get(0).toUpperCase().equals(rightHandSide.get(0));
    }

    @Override
    public String toString(){
        String printString = "P(" + this.leftHandSide + ") = " + this.probability + " ";

        if(isRightHandSideNonTerminal()){
//            printString += "(BackPointer = " + this.rightHandSide.get(0) +  ")";

            String rightSideRepresentation = "";

            if(this.rightHandSide.size() == 1){
                rightSideRepresentation = this.rightHandSide.get(0);
            } else {
                rightSideRepresentation = "(" + this.split + ", " + this.rightHandSide.get(0) + ", " + this.rightHandSide.get(1) + ")";
            }
            printString += "(BackPointer = " + rightSideRepresentation +  ")";

        }

        return printString;



        //return this.leftHandSide + "  ==>  " + rightHandSide + "   " + probability;
    }
}

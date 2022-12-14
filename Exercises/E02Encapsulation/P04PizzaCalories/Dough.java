package Exercises.E02Encapsulation.P04PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (flourType.equals("White") || flourType.equals("Wholegrain")) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy") || bakingTechnique.equals("Homemade")) {
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public double calculateCalories() {
        double modifier1 = 0;
        double modifier2 = 0;
        if (flourType.equals("White")) {
            modifier1 = 1.5;
        } else {
            modifier1 = 1.0;
        }
        if (bakingTechnique.equals("Crispy")) {
            modifier2 = 0.9;
        } else if (bakingTechnique.equals("Chewy")) {
            modifier2 = 1.1;
        } else {
            modifier2 = 1.0;
        }
        return (2 * weight) * modifier1 * modifier2;
    }
}
package exercise1;

public abstract class Insurance {
    protected String typeOfInsurance;
    protected double insuranceCost;

    public String getTypeOfInsurance() {
        return typeOfInsurance;
    }

    public double getMonthlyCost() {
        return insuranceCost;
    }

    public abstract void displayInfo();
    public abstract void setInsuranceCost(double insuranceCost);
}

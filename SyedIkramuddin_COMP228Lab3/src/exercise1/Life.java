package exercise1;

public class Life extends Insurance{
    Life(){
        this.typeOfInsurance = "Life";
        this.insuranceCost = insuranceCost;
    }
    @Override
    public void displayInfo() {
        System.out.println("type of insurance: "+typeOfInsurance+"\n"+"insurance cost: $"+insuranceCost);
    }

    @Override
    public void setInsuranceCost(double insuranceCost) {
        this.insuranceCost = insuranceCost;
    }
}

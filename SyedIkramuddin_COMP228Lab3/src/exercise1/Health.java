package exercise1;

public class Health extends Insurance{
    Health(){
        this.typeOfInsurance = "Health";
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

package exercise3;

public abstract class Mortgage implements MortgageConstants{
    int mortgageNumber;
    String customerName;
    double amountOfMortgage;
    double interestRate;
    double term;
    Mortgage(int mortgageNumber, String customerName, double amountOfMortgage, double term){
        this.customerName = customerName;
        this.mortgageNumber = mortgageNumber;
        this.amountOfMortgage = amountOfMortgage;
        this.term = term;
    }
    public abstract void displayMortgageInfo();

    public abstract void checkMortgageAmount();
}


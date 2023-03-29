package exercise3;

public class PersonalMortgage extends Mortgage{
    PersonalMortgage(int mortgageNumber, String customerName, double amountOfMortgage,double interestRate, double term){
        super(mortgageNumber, customerName, amountOfMortgage, term);
        this.interestRate = 2/interestRate;
    }
    public void checkMortgageAmount(){
        if(amountOfMortgage > maximumMortgageAmount){
            System.out.println("Your mortgage value is greater than 300,000.");
            amountOfMortgage = 0;
        }
    }
    public String checkTerm(){
        if(term <= shortTerm)
            return "Short term";
        else if(term <= mediumTerm)
            return "Medium term";
        else
            return "Long term";
    }
    @Override
    public void displayMortgageInfo() {
        System.out.println(
                bankName+
                " Personal Mortgage" +
                "\nmortgageNumber= " + mortgageNumber +
                "\ncustomerName= " + customerName +
                "\namountOfMortgage= " + amountOfMortgage +
                "\ninterestRate= " + interestRate +
                "\nterm= " + term +"years. "+ checkTerm());
    }
}

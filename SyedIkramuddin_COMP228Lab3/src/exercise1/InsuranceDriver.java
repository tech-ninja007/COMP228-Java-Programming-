package exercise1;

import java.util.Scanner;

public class InsuranceDriver {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Insurance[] insurances = new Insurance[3];

        for(int i = 0; i < 2; i++){
            System.out.print("Enter type of insurance:");
            String typeOfInsurance = scanner.next();
            System.out.print("Enter insurance amount:");
            double insuranceCost = scanner.nextDouble();
            if(typeOfInsurance.equals("life")){
                insurances[i] = new Life();
                insurances[i].setInsuranceCost(insuranceCost);
                System.out.println("You have created an insurance.");
            }
            else if(typeOfInsurance.equals("health")){
                insurances[i] = new Health();
                insurances[i].setInsuranceCost(insuranceCost);
                System.out.println("You have created an insurance.\n");
            }
            else{
                i--;
                System.out.println("You entered incorrect insurance type. Try Again.");
            }
        }
        for(int i = 0; i < 2; i++){
            System.out.println("\n Insurance"+(i+1));
            insurances[i].displayInfo();
        }
    }
}

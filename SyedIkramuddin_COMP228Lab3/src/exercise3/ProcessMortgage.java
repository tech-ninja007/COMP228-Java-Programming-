package exercise3;

import exercise1.Health;
import exercise1.Life;

import java.util.Scanner;

public class ProcessMortgage {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Mortgage[] mortgages = new Mortgage[3];
        System.out.println("Enter the current interest rate: ");
        double currentInterestRate = scanner.nextDouble();
        for(int i = 0; i < 3;i++){
            System.out.print("Enter type of insurance:");
            String typeOfMortgage = scanner.next();
            if(typeOfMortgage.equals("personal")){
                System.out.print("Enter mortgage number:");
                int mortgageNumber = scanner.nextInt();
                System.out.print("Enter customer name:");
                String name = scanner.next();
                System.out.print("Enter amount of mortgage:");
                double amountOfMortgage = scanner.nextDouble();
                System.out.print("Enter the term:");
                double term = scanner.nextDouble();
                mortgages[i] = new PersonalMortgage(mortgageNumber,name,amountOfMortgage,currentInterestRate,term);
                mortgages[i].checkMortgageAmount();
                System.out.println("You have created a Mortgage.\n");
            }
            else if(typeOfMortgage.equals("business")){
                System.out.print("Enter mortgage number:");
                int mortgageNumber = scanner.nextInt();
                System.out.print("Enter customer name:");
                String name = scanner.next();
                System.out.print("Enter amount of mortgage:");
                double amountOfMortgage = scanner.nextDouble();
                System.out.print("Enter the term:");
                double term = scanner.nextDouble();
                mortgages[i] = new BusinessMortgage(mortgageNumber, name, amountOfMortgage,currentInterestRate,term);
                mortgages[i].checkMortgageAmount();
                System.out.println("You have created a Mortgage.\n");
            }
            else{
                i--;
                System.out.println("You entered incorrect mortgage type. Try Again.");
            }
        }
        for(int i = 0; i < 3;i++){
            System.out.println("\nMortgage"+(i+1));
            mortgages[i].displayMortgageInfo();
        }
    }
}

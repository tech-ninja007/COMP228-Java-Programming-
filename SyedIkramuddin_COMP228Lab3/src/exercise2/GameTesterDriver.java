package exercise2;

import java.util.Scanner;

public class GameTesterDriver {
    public static void main(String[] args){
        GameTester[] gameTesters = new GameTester[3];
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < 2; i++){
            System.out.println("Enter name of game tester:");
            String name = scanner.next();
            System.out.println("Enter status of game tester(full-time/part-time):");
            String status = scanner.next();
            if(status.equals("full-time")){
                gameTesters[i] = new FullTimeGameTester(name, true);
                System.out.println("You have created a GameTester.");
            }
            else if(status.equals("part-time")){
                System.out.println("Enter number of hours game tester work:");
                double hrs = scanner.nextDouble();
                gameTesters[i] = new PartTimeGameTester(name, false, hrs);
                System.out.println("You have created a GameTester.");
            }
            else{
                System.out.println("wrong status of gamer. Try again.");
                i--;
            }
        }
        for(int i = 0 ; i < 2; i++){
            System.out.println("GameTester"+(i+1));
            System.out.println(gameTesters[i].toString());
            System.out.println("Game Tester salary: $"+ gameTesters[i].determineSalary());
        }
    }
}

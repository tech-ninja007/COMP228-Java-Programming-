package exercise2;

public class PartTimeGameTester extends GameTester{
    double noOfHours;
    PartTimeGameTester(String name, boolean statusOfGameTester, double noOfHours){
        this.name = name;
        this.statusOfGameTester = statusOfGameTester;
        this.noOfHours = noOfHours;
    }

    @Override
    public double determineSalary() {
        return noOfHours*20;
    }

    @Override
    public String toString() {
        return "PartTimeGameTester: " +
                "name= " + name  +
                ", statusOfGameTester= " + (statusOfGameTester? "Full Timer": "Part Timer") +
                ", noOfHours= " + noOfHours;
    }
}

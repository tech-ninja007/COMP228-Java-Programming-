package exercise2;

public class FullTimeGameTester extends GameTester{
    FullTimeGameTester(String name, boolean statusOfGameTester){
        this.name = name;
        this.statusOfGameTester = statusOfGameTester;
    }

    @Override
    public double determineSalary() {
        return 3000;
    }

    @Override
    public String toString() {
        return "FullTimeGameTester: " +
                "name= " + name +
                ", statusOfGameTester= " + (statusOfGameTester? "Full Timer": "Part Timer");
    }
}

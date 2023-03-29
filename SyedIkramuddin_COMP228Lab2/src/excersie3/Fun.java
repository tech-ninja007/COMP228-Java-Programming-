package excersie3;

public class Fun {
    static void foo(int x, int y){
        System.out.println("\nThis is a Normal foo method.\nI get as input"+x+" "+y );
        System.out.println("sum="+(x+y));
    }
    static void foo(double x,double y){
        System.out.println("\nThis is a Integer foo method.\n I got input as "+x+" "+y);
        System.out.println("sum="+(x+y));
    }
    static void foo(String mssg1 ,String mssg2){
        System.out.println("\nThis is a String foo method.\n I got input as "+mssg1+" "+mssg2);
        System.out.println("sum="+mssg1+mssg2);
    }
}

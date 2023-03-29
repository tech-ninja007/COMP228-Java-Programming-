package excersie2;

import java.util.Random;

public class Lotto {
    int ranNum1;
    int ranNum2;
    int ranNum3;
    Lotto(){
        Random random = new Random();
        this.ranNum1= random.nextInt(9)+1;
        this.ranNum2= random.nextInt(9)+1;
        this.ranNum3= random.nextInt(9)+1;
    }

    public int getRanNum1() {
        return ranNum1;
    }

    public void setRanNum1(int ranNum1) {
        this.ranNum1 = ranNum1;
    }

    public int getRanNum2() {
        return ranNum2;
    }

    public void setRanNum2(int ranNum2) {
        this.ranNum2 = ranNum2;
    }

    public int getRanNum3() {
        return ranNum3;
    }

    public void setRanNum3(int ranNum3) {
        this.ranNum3 = ranNum3;
    }
}

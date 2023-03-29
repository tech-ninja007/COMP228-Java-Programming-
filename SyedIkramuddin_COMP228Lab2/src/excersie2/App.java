package excersie2;

import javax.swing.*;

public class App {
    public static void main(String[] args){
        LottoGame lottoGame = new LottoGame();
        int flag = 0;
        //lottoGame.newLotto();
        //System.out.println(lottoGame.getLottoNumber()+" "+ lottoGame.lotto.getRanNum1()+" " +lottoGame.lotto.getRanNum2()+" "+lottoGame.lotto.getRanNum3());
        //lottoGame.newLotto();
        //System.out.println(lottoGame.getLottoNumber()+" "+ lottoGame.lotto.getRanNum1()+" " +lottoGame.lotto.getRanNum2()+" "+lottoGame.lotto.getRanNum3());
        String value = JOptionPane.showInputDialog("Enter value between 3 & 27","enter value");
        int userValue = Integer.parseInt(value);
        String message;
        for(int i = 0; i < 5; i++){
            if(userValue <= 3 && userValue >=27){
                message = "Wrong number: number is not between 3 and 27";
                JOptionPane.showMessageDialog(null,message);
                continue;
            }
            lottoGame.newLotto();
            if(userValue == lottoGame.getLottoNumber()) {
                JOptionPane.showMessageDialog(null, "Your lotto number:" + userValue +"\n Computer lotto number :"+lottoGame.getLottoNumber()+"\n Number matches ");
                flag = 1;
                break;
            }
            else{
                JOptionPane.showMessageDialog(null, "Your lotto number:" + userValue +"\n Computer lotto number :"+lottoGame.getLottoNumber()+"\n Try Again !");
            }
        }
        if(flag == 1)
            JOptionPane.showMessageDialog(null, "\n Congratulations ! You won ");
        else
            JOptionPane.showMessageDialog(null,"\n Computer won !");
    }
}

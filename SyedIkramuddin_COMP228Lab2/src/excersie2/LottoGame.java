package excersie2;

public class LottoGame {
    Lotto lotto;
    int lottoNumber;
    void newLotto(){
        lotto = new Lotto();
        lottoNumber = lotto.getRanNum1() + lotto.getRanNum2() + lotto.getRanNum3();
    }
    int getLottoNumber(){
        return lottoNumber;
    }
}

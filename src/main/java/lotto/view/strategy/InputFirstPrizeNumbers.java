package lotto.view.strategy;

public class InputFirstPrizeNumbers extends InputLottoNumbers {

    private static final String MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";

    @Override
    public String getMessage() {
        return MESSAGE;
    }

}
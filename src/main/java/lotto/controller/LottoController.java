package lotto.controller;

import lotto.domain.lotto.LottoTickets;
import lotto.domain.purchase.PurchaseAmount;
import lotto.domain.purchase.PurchaseMoney;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService service = new LottoService();

    public void run() {
        try {
            PurchaseMoney purchaseMoney = service.getPurchaseMoney(InputView.getPurchaseMoney());
            PurchaseAmount purchaseAmount = purchaseMoney.getPurchaseAmount();
            OutputView.printTicketAmount(purchaseAmount.getAutoTicketAmount());

            LottoTickets lottoTickets = service.issueTickets(purchaseAmount);
            OutputView.printLottoTickets(lottoTickets);

            WinningNumbers winningNumbers = service.getWinningNumbers(InputView.getWinningNumber(), InputView.getBonusNumber());
            WinningResult winningResult = service.getWinningResult(winningNumbers, lottoTickets);
            OutputView.printWinningResult(winningResult);

            float profitRate = service.profitRate(winningResult, purchaseMoney);
            OutputView.printProfitRate(profitRate);

        } catch (RuntimeException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }
}
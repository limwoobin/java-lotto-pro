package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 숫자들 그룹 테스트")
public class LottoNumbersGroupTest {
    private LottoNumbers exampleLottoNumbers1, exampleLottoNumbers2, exampleLottoNumbers3;
    private LottoNumbers prizeLottoNumbers;

    @BeforeEach
    void setup() {
        exampleLottoNumbers1 = Fixture.lottoNumbersOf(1, 2, 3, 4, 5, 6);
        exampleLottoNumbers2 = Fixture.lottoNumbersOf(4, 2, 3, 13, 12, 14);
        exampleLottoNumbers3 = Fixture.lottoNumbersOf(42, 12, 24, 32, 11, 15);

        prizeLottoNumbers = exampleLottoNumbers1;
    }

    @DisplayName("랜덤 로또 숫자 그룹 생성 테스트")
    @Test
    void generateRandomLottoNumberGroupTest() {
        PurchaseInfo purchaseInfo = new PurchaseInfo(1000);
        LottoNumbersGroup lottoNumbersGroup = new LottoNumbersGroup(purchaseInfo) {
            @Override
            protected List<LottoNumbers> generateRandomLottoNumbers(int amount) {
                List<LottoNumbers> lottoNumbers = new ArrayList<>();
                lottoNumbers.add(new LottoNumbers("1,2,3,4,5,6"));
                return lottoNumbers;
            }
        };

        LottoNumbersGroup lottoNumbersGroup2 = new LottoNumbersGroup(Arrays.asList(prizeLottoNumbers));

        assertThat(lottoNumbersGroup).isEqualTo(lottoNumbersGroup2);
    }

    @DisplayName("로또 숫자 수동 그룹 생성 테스트")
    @Test
    void generateManualLottoNumberGroupTest() {
        String[] myLottoNumbers = new String[]{"1,2,3,4,5,6", "2,3,4,13,12,14", "42,12,24,32,11,15"};
        LottoNumbersGroup lottoNumbersGroup = new LottoNumbersGroup(myLottoNumbers);
        assertThat(lottoNumbersGroup).isEqualTo(new LottoNumbersGroup(getExampleLottoNumbers()));
    }

    private List<LottoNumbers> getExampleLottoNumbers() {
        return Arrays.asList(exampleLottoNumbers1, exampleLottoNumbers2, exampleLottoNumbers3);
    }


    @DisplayName("로또 그룹 결과 테스트")
    @Test
    void getLottoResultFromLottoNumberGroupTest() {
        String[] myLottoNumbers = new String[]{"1,2,3,4,5,6", "2,3,4,13,12,14", "27,13,25,35,9,15"};
        int bonusLottoNumber = 44;
        PrizeLottoNumbers prizeLottoNumbers = new PrizeLottoNumbers(this.prizeLottoNumbers, bonusLottoNumber);
        LottoNumbersGroup lottoNumbersGroup = new LottoNumbersGroup(myLottoNumbers);
        // when
        LottoResults lottoResults = lottoNumbersGroup.getLottoResults(prizeLottoNumbers);
        // then
        assertThat(lottoResults.getMatchAmount(3, false)).isEqualTo(1);
        assertThat(lottoResults.getMatchAmount(6, false)).isEqualTo(1);
    }
}
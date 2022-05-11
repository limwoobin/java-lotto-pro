import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import domain.EmptyPlusStrategy;
import domain.PlusStrategy;
import domain.PlusStrategyFactory;
import domain.SingleNumberPlusStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("더하기 식에 대한 테스트 코드")
class PlusStrategyTest {
    private PlusStrategyFactory factory;

    @BeforeEach
    void setUp() {
        factory = new PlusStrategyFactory();
    }

    @Test
    @DisplayName("팩토리 클래스에 공백을 전달하면 EmptyPlusStrategy 를 반환하고 결과는 0이어야 한다")
    void blank_test() {
        String given = "";
        PlusStrategy plusStrategy = factory.getStrategy(given);

        assertTrue(plusStrategy instanceof EmptyPlusStrategy);
        assertThat(plusStrategy.result(given)).isEqualTo(0);
    }

    @Test
    @DisplayName("팩토리 클래스에 null을 전달하면 EmptyPlusStrategy 를 반환하고 결과는 0이어야 한다")
    void null_test() {
        String given = null;
        PlusStrategy plusStrategy = factory.getStrategy(given);

        assertTrue(plusStrategy instanceof EmptyPlusStrategy);
        assertThat(plusStrategy.result(given)).isEqualTo(0);
    }

    @DisplayName("팩토리 클래스에 숫자 하나를 문자열로 전달할 경우 SingleNumberPlusStrategy 가 반환되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void single_number_test(String input) {
        PlusStrategy plusStrategy = factory.getStrategy(input);

        assertThat(plusStrategy.getClass()).isEqualTo(SingleNumberPlusStrategy.class);
    }

    @DisplayName("팩토리 클래스에 숫자 하나를 문자열로 전달할 경우 해당 문자가 숫자로 반환되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void single_number_test_2(String input) {
        PlusStrategy plusStrategy = factory.getStrategy(input);

        assertThat(plusStrategy.result(input)).isEqualTo(Integer.parseInt(input));
    }
}
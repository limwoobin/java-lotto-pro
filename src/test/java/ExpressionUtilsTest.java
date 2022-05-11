import static org.junit.jupiter.api.Assertions.assertTrue;

import domain.ExpressionUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("더하기 Expression 유효성 테스트")
class ExpressionUtilsTest {

    @DisplayName("빈 값인지 체크하는 로직에 null 혹은 공백을 넘기면 정상적으로 통과되어야 한다")
    @Test
    void empty_expression_test() {
        assertTrue(ExpressionUtils.isEmptyExpression(""));
        assertTrue(ExpressionUtils.isEmptyExpression(null));
    }

    @DisplayName("숫자 하나인지 체크하는 로직에 숫자 하나를 문자열로 넘기면 정상적으로 통과되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void single_number_expression_test(String input) {
        assertTrue(ExpressionUtils.isSingleNumberExpression(input));
    }
}
package lotto.domain.validator;

import java.util.Arrays;
import java.util.List;
import lotto.domain.validator.impl.LottoNumberSizeValidator;
import lotto.domain.validator.impl.NumberFormatValidator;

public class BonusNumberValidatorGroup {
    private final List<NumberValidator> validators;

    private BonusNumberValidatorGroup() {
        this.validators = Arrays.asList(
            new NumberFormatValidator(),
            new LottoNumberSizeValidator()
        );
    }

    private static class LazyHolder {
        private static BonusNumberValidatorGroup instance = new BonusNumberValidatorGroup();
    }

    public static BonusNumberValidatorGroup getInstance() {
        return LazyHolder.instance;
    }

    public void validate(String number) {
        this.validators.forEach(validators -> validators.validate(number));
    }
}
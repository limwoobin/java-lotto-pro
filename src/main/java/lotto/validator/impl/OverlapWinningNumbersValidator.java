package lotto.validator.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.WinningNumbers;
import lotto.exception.ExceptionType;
import lotto.validator.WinningNumbersValidator;

public class OverlapWinningNumbersValidator implements WinningNumbersValidator {

    @Override
    public void validate(String winningNumbers) {
        List<String> numbers = Arrays.asList(winningNumbers.split(WinningNumbers.SPLIT_SYMBOL));
        Set<String> target = new HashSet<>(numbers);

        if (numbers.size() != target.size()) {
            throw new IllegalArgumentException(
                ExceptionType.IS_NOT_OVERLAP_WINNING_NUMBER.getMessage());
        }
    }
}
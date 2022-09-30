package baseball.game;

import baseball.common.error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputNumbersTest {

    @DisplayName("입력 문자는 숫자3개만 가능하다.")
    @ParameterizedTest(name = "{displayName} input: \"{0}\"")
    @ValueSource(strings = {"12f", "1.3", "asd"})
    void inputValidationCheck1(String numStr){
        assertThatThrownBy(() -> {
            new InputNumbers(numStr);
        }).withFailMessage(ErrorMessage.IS_NOT_NUMBER.getMessage());

    }

    @DisplayName("3개의 숫자가 입력되어야 한다.")
    @ParameterizedTest(name = "{displayName} input: \"{0}\"")
    @ValueSource(strings = {"1234", "12"})
    void inputSizeTest(String numStr){
        assertThatThrownBy(() -> {
            new InputNumbers(numStr);
        }).withFailMessage(ErrorMessage.INPUT_LENGTH_ERROR.getMessage());
    }

    @DisplayName("서로 다른 숫자를 입력해야 한다.")
    @ParameterizedTest(name = "{displayName} input: \"{0}\"")
    @CsvSource(value = {"111","121", "332"})
    void inputValidationCheck3(String wrongInput){
        assertThatThrownBy(() -> {
            new InputNumbers(wrongInput);
        }).withFailMessage(ErrorMessage.CANNOT_INPUT_SAME_NUMBER.getMessage());
    }

}
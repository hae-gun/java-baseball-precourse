package baseball.game;

import baseball.common.error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputNumbersTest {

    private String CORRECT_INPUTS = "1 2 3";

    @DisplayName("입력 문자열은 공백을 포함한 숫자만 입력 가능하다.")
    @ParameterizedTest
    @CsvSource(value = {"1 2 f", "1.3", "asd"})
    void inputValidationCheck1(String numStr){
        assertThatThrownBy(() -> {
            new InputNumbers(numStr);
        }).withFailMessage(ErrorMessage.IS_NOT_NUMBER.getMessage());

    }

    @DisplayName("3개의 숫자가 입력되어야 한다.")
    @Test
    void inputSizeTest(){
        InputNumbers inputNumbers = new InputNumbers(CORRECT_INPUTS);
        assertThat(inputNumbers.size()).isEqualTo(3);
    }

    @DisplayName("숫자 1~9 사이의 값만 입력가능하다.")
    @Test
    void inputValidationCheck2(){
        assertThatThrownBy(() -> {
            new InputNumbers("1 2 10");
        }).withFailMessage(ErrorMessage.INPUT_NUMBER_ERROR.getMessage());
    }

    @DisplayName("서로 다른 숫자를 입력해야 한다.")
    @Test
    void inputValidationCheck3(){
        InputNumbers inputNumbers = new InputNumbers(CORRECT_INPUTS);

        BaseballNumber first = inputNumbers.number(0);
        BaseballNumber second = inputNumbers.number(1);
        BaseballNumber third = inputNumbers.number(2);

        assertThat(first).isNotEqualTo(second);
        assertThat(second).isNotEqualTo(third);
        assertThat(third).isNotEqualTo(first);

    }

}
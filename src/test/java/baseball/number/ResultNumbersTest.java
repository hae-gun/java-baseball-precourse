package baseball.number;

import baseball.common.error.ErrorMessage;
import baseball.number.BaseballNumber;
import baseball.number.ResultNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultNumbersTest {
    private ResultNumbers answer;

    @BeforeEach
    void init(){
        int startInclusive = 1;
        int endInclusive = 9;
        answer = new ResultNumbers(startInclusive, endInclusive);
    }

    @DisplayName("end 값은 항상 start 보다 커야한다.")
    @Test
    void inputValidationTest2(){
        int start = 5;
        int end = 1;
        assertThatThrownBy(() -> {
            new ResultNumbers(start, end);
        }).withFailMessage(ErrorMessage.END_GREATER_THAN_START.getMessage());
    }

    @Test
    void 항상_크기가_3인_리스트를_만든다(){
        assertThat(answer.numbers().size()).isEqualTo(3);
    }

    @Test
    void 숫자_3개는_서로_다른숫자이다(){
        BaseballNumber first = answer.number(0);
        BaseballNumber second = answer.number(1);
        BaseballNumber third = answer.number(2);

        assertThat(first).isNotEqualTo(second);
        assertThat(second).isNotEqualTo(third);
        assertThat(third).isNotEqualTo(first);
    }

}
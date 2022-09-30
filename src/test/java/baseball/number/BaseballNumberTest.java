package baseball.number;

import baseball.common.error.ErrorMessage;
import baseball.number.BaseballNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {

    @DisplayName("게임 숫자 생성")
    @Test
    void create(){
        BaseballNumber baseballNumber = new BaseballNumber(5);
        assertThat(baseballNumber.number()).isEqualTo(5);
    }

    @DisplayName("1~9 사이 숫자만 입력가능하다.")
    @ParameterizedTest(name ="{displayName} input : {0}")
    @ValueSource(ints = {-1,-5,0,10})
    void validationTest(int number){
        assertThatThrownBy(() -> {
            new BaseballNumber(number);
        }).withFailMessage(ErrorMessage.INPUT_NUMBER_ERROR.getMessage());
    }

    @DisplayName("숫자 문자입력으로 생성 가능")
    @Test
    void inputTest(){
        BaseballNumber baseballNumber = BaseballNumber.of("5");
        assertThat(baseballNumber.number()).isEqualTo(5);
    }

    @DisplayName("value 값이 같으면 두객체는 서로 같은 값이다.")
    @Test
    void equalsTest(){
        BaseballNumber number1 = new BaseballNumber(1);
        BaseballNumber number2 = new BaseballNumber(1);
        assertThat(number1).isEqualTo(number2);
    }

    @DisplayName("value 값이 같으면 두객체는 서로 같은 값이다.")
    @Test
    void equalsTest2(){
        BaseballNumber number1 = BaseballNumber.of("1");
        BaseballNumber number2 = BaseballNumber.of("1");
        assertThat(number1).isEqualTo(number2);
    }
}
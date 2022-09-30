package baseball.game;

import baseball.number.BaseballNumber;
import baseball.number.InputNumbers;
import org.assertj.core.internal.Numbers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CompareTest {

    private Compare compare;
    private static List<BaseballNumber> result;

    @BeforeAll
    static void init(){
        result  = new ArrayList<>();
        result.add(new BaseballNumber(1));
        result.add(new BaseballNumber(2));
        result.add(new BaseballNumber(3));
    }

    @BeforeEach
    void reset(){
        compare = new Compare();
    }

    @DisplayName("스트라이크 테스트")
    @Test
    void testStrike(){
        List<BaseballNumber> input = new ArrayList<>();
        input.add(new BaseballNumber(1));
        input.add(new BaseballNumber(2));
        input.add(new BaseballNumber(3));

        assertThat(compare.compare(input, result).toString()).isEqualTo("3스트라이크");
    }

    @DisplayName("볼 테스트")
    @Test
    void ballStrike(){
        List<BaseballNumber> input = new ArrayList<>();
        input.add(new BaseballNumber(3));
        input.add(new BaseballNumber(1));
        input.add(new BaseballNumber(2));

        assertThat(compare.compare(input, result).toString()).isEqualTo("3볼");
    }

    @DisplayName("낫싱 테스트")
    @Test
    void nothingStrike(){
        List<BaseballNumber> input = new ArrayList<>();
        input.add(new BaseballNumber(4));
        input.add(new BaseballNumber(5));
        input.add(new BaseballNumber(6));

        assertThat(compare.compare(input, result).toString()).isEqualTo("낫싱");
    }

    @DisplayName("1볼 1스트라이크 테스트")
    @Test
    void oneBallTwoStrike(){
        List<BaseballNumber> input = new ArrayList<>();
        input.add(new BaseballNumber(1));
        input.add(new BaseballNumber(5));
        input.add(new BaseballNumber(2));

        assertThat(compare.compare(input, result).toString()).isEqualTo("1볼 1스트라이크");
    }
}
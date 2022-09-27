package jutnitest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set size 메서드 테스트")
    void check_size(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int input){
        assertThat(numbers.contains(input)).isTrue();
    }
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true","4:false","5:false"}, delimiter = ':')
    void containsTest2_is_true_or_false(int input, boolean result){
        assertThat(numbers.contains(input)).isEqualTo(result);
    }

}

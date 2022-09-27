package jutnitest;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void 콤마로_스플릿하기(){
        String str = "1,2";

        assertThat(str.split(",")).contains("1","2");
    }

    @Test
    void 콤마없는_문자열_콤마로스플릿하기(){
        String str = "1";

        assertThat(str.split(",")).containsExactly("1");
    }

    @Test
    void 괄호포함된_문자열_괄호제거후_반환하기(){
        String str = "(1,2)";

        assertThat(str.substring(1, str.length()-1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 인덱스 벗어나면 에러 발생")
    void 문자열_charAt_메서드_테스트(){
        String str = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(()->{
                    str.charAt(3);
                }).withMessageMatching("String index out of range: \\d+");
    }
}

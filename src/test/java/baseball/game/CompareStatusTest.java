package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CompareStatusTest {

    @DisplayName("스트라이크")
    @Test
    void strikeTest(){
        CompareStatus status = new CompareStatus(1,0);
        assertThat(status).isEqualTo(CompareStatus.strike());
    }

    @DisplayName("볼")
    @Test
    void ballTest(){
        CompareStatus status = new CompareStatus(0,1);
        assertThat(status).isEqualTo(CompareStatus.ball());
    }

    @DisplayName("낫싱")
    @Test
    void nothingTest(){
        CompareStatus status = new CompareStatus(0,0);
        assertThat(status).isEqualTo(CompareStatus.nothing());
    }
}
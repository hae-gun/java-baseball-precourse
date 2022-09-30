package baseball.computer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @DisplayName("컴퓨터 객체 생성시 ResultNumbers 객체를 갖는다.")
    @Test
    void create(){
        Computer computer = new Computer();
        assertThat(computer.resultNumbers()).isNotNull();
    }
}
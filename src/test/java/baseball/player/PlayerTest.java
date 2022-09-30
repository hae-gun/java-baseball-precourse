package baseball.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @DisplayName("플레이어 생성시 InputNumbers 객체를 갖는다.")
    @Test
    void create(){
        Player player = new Player("123");
        assertThat(player.inputNumbers()).isNotNull();
    }

}
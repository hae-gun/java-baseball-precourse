package baseball;

import baseball.game.BaseballGame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        game.run();
    }
}

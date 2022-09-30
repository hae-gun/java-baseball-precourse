package baseball.player;

import baseball.number.InputNumbers;

public class Player {
    private InputNumbers inputNumbers;

    public Player(final String input) {
        this.inputNumbers = new InputNumbers(input);
    }
    public InputNumbers inputNumbers() {
        return inputNumbers;
    }
}

package baseball.computer;

import baseball.number.ResultNumbers;

public class Computer {
    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 9;

    private ResultNumbers answers;

    public Computer(){
        this.answers = new ResultNumbers(START_INCLUSIVE,END_INCLUSIVE);
    }

    public void retry(){
        this.answers = new ResultNumbers(START_INCLUSIVE,END_INCLUSIVE);
    }

    public ResultNumbers resultNumbers(){
        return answers;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "answers=" + answers +
                '}';
    }
}

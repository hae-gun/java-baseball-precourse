package baseball.game;

public enum GameStatus {

    READY(1), END(2), RUN(3);


    public int value;

    GameStatus(int value) {
        this.value = value;
    }


}

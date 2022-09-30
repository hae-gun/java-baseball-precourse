package baseball.game;

import java.util.Objects;

public class CompareStatus {
    final int FINISH_COUNT = 3;
    private int strike;
    private int ball;

    public CompareStatus(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static CompareStatus strike(){
        return new CompareStatus(1,0);
    }

    public static CompareStatus ball(){
        return new CompareStatus(0,1);
    }

    public static CompareStatus nothing(){
        return new CompareStatus(0, 0);
    }

    public boolean isFinish(){
        return this.strike == FINISH_COUNT;
    }


    public CompareStatus add(CompareStatus compareStatus){
        return new CompareStatus(this.strike + compareStatus.strike, this.ball + compareStatus.ball);
    }

    @Override
    public String toString() {
        if (this.ball + this.strike == 0) {
            return "낫싱";
        }
        StringBuilder sb = new StringBuilder();

        if(this.ball > 0){
            sb.append(String.format("%s볼 ", this.ball));
        }

        if(this.strike > 0){
            sb.append(String.format("%s스트라이크", this.strike));
        }

        return sb.toString().trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompareStatus that = (CompareStatus) o;
        return strike == that.strike && ball == that.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}

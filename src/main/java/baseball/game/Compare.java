package baseball.game;

import baseball.computer.Computer;
import baseball.number.BaseballNumber;
import baseball.number.InputNumbers;
import baseball.player.Player;
import org.assertj.core.internal.Numbers;

import java.util.List;
import java.util.Objects;

public class Compare {
    private CompareStatus gameResult;

    public CompareStatus compare(List<BaseballNumber> input, List<BaseballNumber> result) {
        gameResult = CompareStatus.nothing();

        for (int idx = 0; idx < input.size(); idx++) {
            CompareStatus set = compare(idx, input, result);
            gameResult = gameResult.add(set);
        }

        return gameResult;
    }

    private CompareStatus compare(int idx, List<BaseballNumber> input, List<BaseballNumber> result) {
        if (isStrike(input.get(idx), result.get(idx))) {
            return CompareStatus.strike();
        }
        if (isBall(input.get(idx), result)) {
            return CompareStatus.ball();
        }
        return CompareStatus.nothing();
    }

    private boolean isBall(BaseballNumber number, List<BaseballNumber> resultNumbers) {
        return resultNumbers.contains(number);
    }

    private boolean isStrike(BaseballNumber input, BaseballNumber result) {
        return input.equals(result);
    }

    public boolean isFinish(){
        return this.gameResult.isFinish();
    }

    public void reset() {
        this.gameResult = CompareStatus.nothing();
    }
}

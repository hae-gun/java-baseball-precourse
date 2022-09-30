package baseball.number;

import baseball.common.error.ErrorMessage;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResultNumbers {
    private final int LIST_SIZE = 3;
    private final int MIN_NUM = 1;
    private final int MAX_NUM = 9;

    private List<BaseballNumber> answers;

    public ResultNumbers(int startInclusive, int endInclusive){

        inputValidation(startInclusive, endInclusive);
        Set<BaseballNumber> set = new HashSet<>();
        while(set.size() != LIST_SIZE){
            set.add(new BaseballNumber(Randoms.pickNumberInRange(startInclusive, endInclusive)));
        }
        answers = new ArrayList<>(set);
    }

    public List<BaseballNumber> numbers() {
        return new ArrayList<>(answers);
    }

    private void inputValidation(int start, int end){
        if(start < MIN_NUM || end < MIN_NUM || start > MAX_NUM || end > MAX_NUM){
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_ERROR.getMessage());
        }
        if(start >= end){
            throw new IllegalArgumentException(ErrorMessage.END_GREATER_THAN_START.getMessage());
        }

    }

    public BaseballNumber number(int i) {
        return answers.get(i);
    }

    public boolean contains(BaseballNumber number) {
        return this.answers.contains(number);
    }

    @Override
    public String toString() {
        return "ResultNumbers{" +
                "answers=" + answers +
                '}';
    }
}

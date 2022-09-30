package baseball.number;

import baseball.common.error.ErrorMessage;

import java.util.Objects;

public class BaseballNumber {
    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 9;

    private int value;

    public BaseballNumber(int value) {
        validation(value);
        this.value = value;
    }

    public static BaseballNumber of (String value){
        int input = Integer.valueOf(value);
        return new BaseballNumber(input);
    }

    private void validation(int value) {
        if(value > MAX_VALUE || value < MIN_VALUE){
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_ERROR.getMessage());
        }
    }

    public int number(){
        return this.value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumber that = (BaseballNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "{" +
                value +
                '}';
    }
}

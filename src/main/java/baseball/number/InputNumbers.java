package baseball.number;

import baseball.common.error.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class InputNumbers {
    private final String DELIMITER = "";
    private final int LIST_SIZE = 3;
    private List<BaseballNumber> numbers = new ArrayList<>();

    public InputNumbers(String numStr) {
        String[] arr = numStr.split(DELIMITER);
        validationSize(arr);
        validation(arr);
        for(String number : arr){
            numbers.add(BaseballNumber.of(number));
        }
    }

    private void validation(String[] arr) {
        if(arr[0].equals(arr[1]) || arr[1].equals(arr[2]) || arr[2].equals(arr[0])){
            throw new IllegalArgumentException(ErrorMessage.CANNOT_INPUT_SAME_NUMBER.getMessage());
        }
    }

    private void validationSize(String[] arr){
        if(arr.length != LIST_SIZE){
            throw new IllegalArgumentException(ErrorMessage.INPUT_LENGTH_ERROR.getMessage());
        }
    }

    public int size() {
        return this.numbers.size();
    }

    public BaseballNumber number(int i) {
        return this.numbers.get(i);
    }

    @Override
    public String toString() {
        return "InputNumbers{" +
                "numbers=" + numbers +
                '}';
    }

    public List<BaseballNumber> numbers() {
        return new ArrayList<>(numbers);
    }
}

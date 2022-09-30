package baseball.game;

import baseball.common.error.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputNumbers {
    private List<BaseballNumber> numbers = new ArrayList<>();

    public InputNumbers(String numStr) {
        String[] arr = numStr.split(" ");
        validation(arr);
        for(String number : arr){
            numbers.add(BaseballNumber.of(number));
        }
    }

    private void validation(String[] arr) {
        for(String str: arr){
            try{
                Integer.valueOf(str);
            }catch (Exception e){
                throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER.getMessage());
            }
        }
    }


    public int size() {
        return this.numbers.size();
    }

    public BaseballNumber number(int i) {
        return this.numbers.get(i);
    }
}

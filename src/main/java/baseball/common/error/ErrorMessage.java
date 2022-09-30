package baseball.common.error;

public enum ErrorMessage {

    INPUT_NUMBER_ERROR("1~9 숫자만 입력가능합니다."),
    END_GREATER_THAN_START("start 값은 항상 end 값보다 작아야 합니다."),
    IS_NOT_NUMBER("숫자가 아닌값이 입력되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

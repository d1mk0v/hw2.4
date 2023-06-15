package pro.sky.springExeptions.exceptions;

public class WrongConfirmPasswordException extends RuntimeException {
    public WrongConfirmPasswordException(String message) {
        super(message);
    }
}

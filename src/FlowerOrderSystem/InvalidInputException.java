package src.FlowerOrderSystem;
public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }

    public static class WeakPassword extends Exception{
        public WeakPassword(String message) {
            super(message);
        }
    }
}

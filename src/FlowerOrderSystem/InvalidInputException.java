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

    public static class PasswordMismatch extends Exception{
        public PasswordMismatch(String message) {
            super(message);
        }
    }

    public static class InvalidName extends Exception{
        public InvalidName(String message) {
            super(message);
        }
    }

    public static class InvalidEmail extends Exception{
        public InvalidEmail(String message) {
            super(message);
        }
    }

    public static class InvalidPhone extends Exception{
        public InvalidPhone(String message) {
            super(message);
        }
    }
}

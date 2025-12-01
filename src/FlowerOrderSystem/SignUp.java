package src.FlowerOrderSystem;

public class SignUp {
    private User user;
    private String succesful = "Your Hiraya Cebu account has been created. Please refresh and log in to continue.";
    private String fullName;
    private String email;
    private String contactNum;
    private String userName;
    private String Password;

    public SignUp(String firstName, String lastName, String emailAddress, String contactNumber, String username, String password, String confirmPassword) throws InvalidInputException{
        user = new User(firstName, lastName, emailAddress, contactNumber, username, password);
    }

    /*Will be displayed sa dialog box telling the user to refresh */
    public String getSuccesful(){
        return succesful;
    }
}

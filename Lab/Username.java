package Lab;

public class Username {
    public static void main(String[] args) {
        String email = "farhanzaief@gmail.com";
        String username = email.substring(0, email.indexOf("@"));
        System.out.println("Username: " + username);

    }

}

package LibraryConsoleApp.userInterfaces;

public class RegistrationView {

    public RegistrationView() {
    }

    public void askRegistrationMenu(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Do you wont to be registered user?" + "\r\n" + "\r\n" + "\r\n" +
                "1.Yes" + "\r\n" + "\r\n" +
                "2.No" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }


    public void registrationMenuLogin(){
        System.out.println("----------------REGISTRATION----------------" + "\r\n" + "\r\n" + "\r\n" +
                "You need to write login" + "\r\n" + "\r\n" + "\r\n" +
                "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );

    }

    public void registrationMenuPassword(){
        System.out.println("----------------REGISTRATION----------------" + "\r\n" + "\r\n" + "\r\n" +
                "You need to write password" + "\r\n" + "\r\n" + "\r\n" +
                "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );

    }

    public void registrationMenuPasswordApproving(){
        System.out.println("----------------REGISTRATION----------------" + "\r\n" + "\r\n" + "\r\n" +
                "Reaped your password" + "\r\n" + "\r\n" + "\r\n" +
                "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );

    }

    public void unregisteredCantEnterMenu() {
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Sorry, but to use this application you need to be registered." + "\r\n" + "\r\n" + "\r\n" +
                "1.Go to login menu" + "\r\n" + "\r\n" +
                "2.Go to registration menu" + "\r\n" + "\r\n" +
                "3.Exit" + "\r\n" + "\r\n" +
                "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }
}

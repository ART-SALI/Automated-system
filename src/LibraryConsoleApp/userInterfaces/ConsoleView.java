package LibraryConsoleApp.userInterfaces;

public class ConsoleView {

    public ConsoleView() {
    }

    public void firstMenu(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Are you registered user?" + "\r\n" + "\r\n" + "\r\n" +
                "1.Yes" + "\r\n" + "\r\n" +
                "2.No" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void registrationMenuSomethingWrong(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Something went wrong. Do you want to reaped from the start?" + "\r\n" + "\r\n" + "\r\n" +
                "1.Yes" + "\r\n" + "\r\n" +
                "2.No(Exit)" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );

    }

    public void somethingWentAbsoluteWrong(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Something went totally wrong" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );

    }
}

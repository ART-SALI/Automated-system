package LibraryConsoleApp;

import LibraryConsoleApp.userInterfaces.ConsoleView;

import java.util.Objects;
import java.util.Scanner;

public class SomethingWrongMenu {

    public SomethingWrongMenu() {
    }

    public int error(){

        ConsoleView console = new ConsoleView();
        String userReaction;
        Scanner scanner = new Scanner(System.in);
        FileSavingSystem dataBase = new FileSavingSystem();

        dataBase.saveLog("something went wrong");

        console.registrationMenuSomethingWrong();
        userReaction = scanner.nextLine();

        int stage = 0;


        if (!Objects.equals(userReaction, "1") && !userReaction.equals("2")) {
            console.somethingWentAbsoluteWrong();
            dataBase.saveLog("something went totally wrong");
        } else if (userReaction.equals("1")) stage = 1;

        return stage;
    }
}

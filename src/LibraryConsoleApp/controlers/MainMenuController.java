package LibraryConsoleApp.controlers;
import LibraryConsoleApp.FileSavingSystem;
import LibraryConsoleApp.userInterfaces.MainMenuView;
import LibraryConsoleApp.users.ReaderUser;

import java.util.Objects;
import java.util.Scanner;

public class MainMenuController {

    public MainMenuController() {
    }

    public int main(ReaderUser currentUser){

        FileSavingSystem dataBase = new FileSavingSystem();
        MainMenuView console = new MainMenuView();
        Scanner scanner = new Scanner(System.in);
        String userReaction;


        dataBase.saveLog("user <id=" +
                currentUser.getId() + "|" + currentUser.getLogin() +
                "> entered mein menu");

        console.mainMenuUser();
        userReaction = scanner.nextLine();
        int stage = -1;

        if (!Objects.equals(userReaction, "1") && !userReaction.equals("2") && !userReaction.equals("3") && !userReaction.equals("4")) {

            dataBase.saveLog("something went wrong");

            return -1;
        } else if (userReaction.equals("1")) {

            dataBase.saveLog("user <id=" +
                    currentUser.getId() + "|" + currentUser.getLogin() +
                    "> went to searching books");

            stage = new SearchBookController().search(currentUser);

        } else if (userReaction.equals("2")) {

            dataBase.saveLog("user <id=" +
                    currentUser.getId() + "|" + currentUser.getLogin() +
                    "> went to order book");

            stage = new OrderingController().startOrdering(currentUser);

        } else if (userReaction.equals("3")) {

            dataBase.saveLog("user <id=" +
                    currentUser.getId() + "|" + currentUser.getLogin() +
                    "> went to personal cabinet");

            stage = new PersonalCabinetController().personalCabinetMenu(currentUser);
        } else if (userReaction.equals("4")) {

            dataBase.saveLog("user <id=" +
                    currentUser.getId() + "|" + currentUser.getLogin() +
                    "> went to exit");

            return 0;
        }
        return stage;
    }
}

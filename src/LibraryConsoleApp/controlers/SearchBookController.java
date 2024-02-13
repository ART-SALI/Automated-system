package LibraryConsoleApp.controlers;

import LibraryConsoleApp.FileSavingSystem;
import LibraryConsoleApp.library.Library;
import LibraryConsoleApp.userInterfaces.SearchBookView;
import LibraryConsoleApp.users.User;

import java.util.Objects;
import java.util.Scanner;

public class SearchBookController {

    public SearchBookController() {
    }

    public int search(User currentUser){

        SearchBookView console = new SearchBookView();
        Scanner scanner = new Scanner(System.in);
        String userReaction;
        FileSavingSystem dataBase = new FileSavingSystem();

        console.searchingBookOptions();
        userReaction = scanner.nextLine();

        if (!Objects.equals(userReaction, "1") && !userReaction.equals("2") && !userReaction.equals("3")) {

            dataBase.saveLog("something went wrong");

            return -1;
        } else if (userReaction.equals("1")) {

            dataBase.saveLog("user <id=" +
                    currentUser.getId() + "|" + currentUser.getLogin() +
                    "> started searching by name");

            //input name
            console.searchByName();
            userReaction = scanner.nextLine();

            //output result of searching
            console.searchByName(new Library(dataBase.readBooksData()), userReaction);
            userReaction = scanner.nextLine();


        } else if (userReaction.equals("2")) {

            dataBase.saveLog("user <id=" +
                    currentUser.getId() + "|" + currentUser.getLogin() +
                    "> started searching by author");

            //input author
            console.searchByAuthor();
            userReaction = scanner.nextLine();

            //output result of searching
            console.searchByAuthor(new Library(dataBase.readBooksData()), userReaction);
            userReaction = scanner.nextLine();


        } else if (userReaction.equals("3")) {

            dataBase.saveLog("user <id=" +
                    currentUser.getId() + "|" + currentUser.getLogin() +
                    "> went to main menu");

        }
        return 6;
    }
}

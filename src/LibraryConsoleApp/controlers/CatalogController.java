package LibraryConsoleApp.controlers;

import LibraryConsoleApp.FileSavingSystem;
import LibraryConsoleApp.library.Library;
import LibraryConsoleApp.userInterfaces.CatalogView;
import LibraryConsoleApp.users.User;

import java.util.Objects;
import java.util.Scanner;

public class CatalogController {

    public CatalogController() {
    }

    public int seeCatalog(User currentUser) {

        CatalogView console = new CatalogView();
        Scanner scanner = new Scanner(System.in);
        String userReaction;
        FileSavingSystem dataBase = new FileSavingSystem();
        Library library = new Library(dataBase.readBooksData());

        dataBase.saveLog("user <id=" + currentUser.getId() + "|"
                + currentUser.getLogin() + "> started watching catalog");
        console.searchBookIdByCatalog(library);
        userReaction = scanner.nextLine();
        int stage = -1;

        if (userReaction.equals("1")
                || userReaction.equals("2")
                || userReaction.equals("3")
                || userReaction.equals("4")
                || userReaction.equals("5")) if (userReaction.equals("1")) stage = 18;
        else if (userReaction.equals("2")) stage = 19;
        else if (userReaction.equals("3")) stage = 20;
        else if (userReaction.equals("4")) stage = 21;
        else stage = 8;


        while (stage != 8 && stage != -1){
            if (stage == 18) {

                dataBase.saveLog("user <id=" + currentUser.getId() + "|"
                        + currentUser.getLogin() + "> started watching catalog sorted by name");
                console.searchBookIdByCatalogSortedByName(library);
                userReaction = scanner.nextLine();

                if (!userReaction.equals("1") && !userReaction.equals("2")
                        && !userReaction.equals("3") && !userReaction.equals("4")) stage = -1;
                else if (userReaction.equals("1")) stage = 19;
                else if (userReaction.equals("2")) stage = 20;
                else if (userReaction.equals("3")) stage = 21;
                else stage = 8;


            }

            //searching bookId to order the book which sorted by author
            if (stage == 19) {


                dataBase.saveLog("user <id=" + currentUser.getId() + "|"
                        + currentUser.getLogin() + "> started watching catalog sorted by author");
                console.searchBookIdByCatalogSortedByAuthor(library);
                userReaction = scanner.nextLine();

                if (!Objects.equals(userReaction, "1") && !userReaction.equals("2")
                        && !userReaction.equals("3") && !userReaction.equals("4")) stage = -1;
                else if (userReaction.equals("1")) stage = 18;
                else if (userReaction.equals("2")) stage = 20;
                else if (userReaction.equals("3")) stage = 21;
                else stage = 8;


            }

            //searching bookId to order the book which sorted by publication
            if (stage == 20) {

                dataBase.saveLog("user <id=" + currentUser.getId() + "|"
                        + currentUser.getLogin() + "> started watching catalog sorted by publication");
                console.searchBookIdByCatalogSortedByPublication(library);
                userReaction = scanner.nextLine();

                if (!Objects.equals(userReaction, "1") && !userReaction.equals("2")
                        && !userReaction.equals("3") && !userReaction.equals("4")) stage = -1;
                else if (userReaction.equals("1")) stage = 19;
                else if (userReaction.equals("2")) stage = 18;
                else if (userReaction.equals("3")) stage = 21;
                else if (userReaction.equals("4")) stage = 8;


            }

            //searching bookId to order the book which sorted by dateOfPublication
            if (stage == 21) {

                dataBase.saveLog("user <id=" + currentUser.getId() + "|"
                        + currentUser.getLogin() + "> started watching catalog sorted by dateOfPublication");
                console.searchBookIdByCatalogSortedByDateOfPublication(library);
                userReaction = scanner.nextLine();

                if (!userReaction.equals("1") && !userReaction.equals("2")
                        && !userReaction.equals("3") && !userReaction.equals("4")) stage = -1;
                else if (userReaction.equals("1")) stage = 19;
                else if (userReaction.equals("2")) stage = 20;
                else if (userReaction.equals("3")) stage = 18;
                else stage = 8;

            }
        }

        if (stage == 8) return new OrderingController().orderCreating(library, currentUser);
        return stage;
    }
}

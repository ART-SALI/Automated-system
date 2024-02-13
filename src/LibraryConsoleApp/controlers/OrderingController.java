package LibraryConsoleApp.controlers;

import LibraryConsoleApp.FileSavingSystem;
import LibraryConsoleApp.library.BookSubscriptionRequest;
import LibraryConsoleApp.library.Library;
import LibraryConsoleApp.userInterfaces.OrderingView;
import LibraryConsoleApp.users.User;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class OrderingController {

    public OrderingController() {
    }

    public int startOrdering(User currentUser){

        FileSavingSystem dataBase = new FileSavingSystem();
        Scanner scanner = new Scanner(System.in);
        OrderingView console = new OrderingView();
        String userReaction;

        console.bookOrdering();
        userReaction = scanner.nextLine();

        int stage = -1;

        if (!Objects.equals(userReaction, "1") && !userReaction.equals("2") && !userReaction.equals("3")) {

            dataBase.saveLog("something went wrong");

            return -1;
        } else if (userReaction.equals("1")) {

            dataBase.saveLog("user <id=" +
                    currentUser.getId() + "|" + currentUser.getLogin() +
                    "> started ordering the book by id");

            stage = this.orderCreating(new Library(dataBase.readBooksData()), currentUser);
        } else if (userReaction.equals("2")) {

            dataBase.saveLog("user <id=" +
                    currentUser.getId() + "|" + currentUser.getLogin() +
                    "> went to catalog");

            stage = new CatalogController().seeCatalog(currentUser);
        } else if (userReaction.equals("3")) {

            dataBase.saveLog("user <id=" +
                    currentUser.getId() + "|" + currentUser.getLogin() +
                    "> went to main menu");

            stage = 6;
        }

        return stage;
    }

    public int orderCreating(Library library, User currentUser){

        FileSavingSystem dataBase = new FileSavingSystem();
        Scanner scanner = new Scanner(System.in);
        OrderingView console = new OrderingView();
        List<BookSubscriptionRequest> requests = dataBase.readRequestData();
        String userReaction;

        console.bookOrdering();
        userReaction = scanner.nextLine();
        int stage = -1;
        dataBase.saveLog("user <id=" +
                currentUser.getId() + "|" + currentUser.getLogin() +
                "> gave bookId to order the book");
        console.bookOrderingGetId();
        userReaction = scanner.nextLine();
        if (Integer.parseInt(userReaction) <= library.getNumberOfUniqueBooks() && Integer.parseInt(userReaction) >= 0) {
            requests.add(new BookSubscriptionRequest(Integer.parseInt(userReaction), currentUser.getId()));
            dataBase.saveRequestData(requests);
            console.bookRequestSanded();
            dataBase.saveLog("user <id=" +
                    currentUser.getId() + "|" + currentUser.getLogin() +
                    "> created order successfully");
            userReaction = scanner.nextLine();
            if (!Objects.equals(userReaction, "1") && !userReaction.equals("2")) {

                return -1;
            } else if (userReaction.equals("1")) {

                dataBase.saveLog("user <id=" +
                        currentUser.getId() + "|" + currentUser.getLogin() +
                        "> went to main menu");
                stage = 6;
            } else if (userReaction.equals("2")) {

                dataBase.saveLog("user <id=" +
                        currentUser.getId() + "|" + currentUser.getLogin() +
                        "> went to exit");
                stage = 0;
            }

        }
        return stage;
    }
}

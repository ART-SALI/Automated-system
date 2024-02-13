package LibraryConsoleApp.controlers;

import LibraryConsoleApp.*;
import LibraryConsoleApp.library.BookSubscriptionRequest;
import LibraryConsoleApp.library.Library;
import LibraryConsoleApp.userInterfaces.ConsoleView;
import LibraryConsoleApp.users.Librarian;
import LibraryConsoleApp.users.ReaderUser;
import LibraryConsoleApp.users.ReadersBase;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class LibraryController {
    public LibraryController() {
    }

    public void start(){

        //take data from files
        FileSavingSystem dataBase = new FileSavingSystem();
        ReadersBase readersBase = new ReadersBase(dataBase.readReadersData());
        Library library = new Library(dataBase.readBooksData());
        List<BookSubscriptionRequest> requests = dataBase.readRequestData();
        List<Librarian> librarians = dataBase.readLibrariansData();

        //creating interface to communicate with user
        ConsoleView console = new ConsoleView();
        String userReaction;
        Scanner scanner = new Scanner(System.in);
        ReaderUser currentUser = null;

        int stage = 1;

        while (stage != 0) {

            if (stage == -3) stage = new LibrarianController().active();

            if (stage == -2) stage = new AdminController().activate();

            if (stage == -1) stage = new SomethingWrongMenu().error();

            //start stage to know if user is registered
            if (stage == 1) {

                dataBase.saveLog("program started");

                console.firstMenu();
                userReaction = scanner.nextLine();
                if (!Objects.equals(userReaction, "1") && !userReaction.equals("2")) stage = -1;
                else stage += Integer.parseInt(userReaction);
            }

            if (stage == 2) {
                currentUser = new LoginController().logging();
                if (currentUser == null) stage = -1;
                else if (currentUser.getId() == -2) stage = -2;
                else if (currentUser.getId() == -3) stage = -3;
                else stage = 6;
            }

            if (stage == 3) {
                currentUser = new RegistrationController().registration(readersBase);
                if (currentUser == null) stage = -1;
                else if (currentUser.getId() == -1) stage = 0;
                else stage = 6;
            }

            if (stage == 6) stage = new MainMenuController().main(currentUser);


        }

    }
}

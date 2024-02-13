package LibraryConsoleApp.controlers;

import LibraryConsoleApp.FileSavingSystem;
import LibraryConsoleApp.library.BookSubscription;
import LibraryConsoleApp.userInterfaces.PersonalCabinetView;
import LibraryConsoleApp.users.ReaderUser;
import LibraryConsoleApp.users.ReadersBase;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class PersonalCabinetController {

    public PersonalCabinetController() {
    }

    public int personalCabinetMenu(ReaderUser currentUser){

        FileSavingSystem dataBase = new FileSavingSystem();
        PersonalCabinetView console = new PersonalCabinetView();
        Scanner scanner = new Scanner(System.in);
        String userReaction;
        int stage = -1;

        console.personalCabinet(currentUser);
        userReaction = scanner.nextLine();

        if (userReaction.equals("1") || userReaction.equals("2")
                || userReaction.equals("3") || userReaction.equals("4") || userReaction.equals("5"))
            if (userReaction.equals("1")) stage = this.changeLogin(currentUser, console, dataBase);
        else if (userReaction.equals("2")) stage = this.changePassword(currentUser, console, dataBase);
        else if (userReaction.equals("3")) stage = this.bookReturn(currentUser, console, dataBase);
        else if(currentUser.getFine() == 0) {
                if (userReaction.equals("4")) stage = 6;
            }else if (userReaction.equals("4")) stage = this.payFine(currentUser, console, dataBase);
             else stage = 6;


        return  stage;
    }

    public int changeLogin(ReaderUser currentUser, PersonalCabinetView console, FileSavingSystem dataBase){

        dataBase.saveLog("user <id=" + currentUser.getId() + "|" + currentUser.getLogin() +
                "> started changing login");
        String userReaction;
        Scanner scanner = new Scanner(System.in);
        int stage = -1;

        console.loginChanging();
        userReaction = scanner.nextLine();
        currentUser.setLogin(userReaction);

        ReadersBase readersBase = new ReadersBase(dataBase.readReadersData());
        dataBase.saveReadersData(readersBase.updateReader(currentUser));

        console.loginChangingSuccess();
        dataBase.saveLog("user <id=" + currentUser.getId() + "|" + currentUser.getLogin() +
                "> changing login successfulLy");
        userReaction = scanner.nextLine();
        if (userReaction.equals("1") || userReaction.equals("2"))
            if (userReaction.equals("1")) stage = 6;
        else stage = 0;

        return stage;
    }

    public int changePassword(ReaderUser currentUser, PersonalCabinetView console, FileSavingSystem dataBase){

        String userReaction;
        Scanner scanner = new Scanner(System.in);
        int stage = -1;

        dataBase.saveLog("user <id=" + currentUser.getId() + "|" + currentUser.getLogin() +
                "> started changing password");
        console.passwordChanging();
        userReaction = scanner.nextLine();
        currentUser.setPassword(userReaction);

        ReadersBase readersBase = new ReadersBase(dataBase.readReadersData());
        dataBase.saveReadersData(readersBase.updateReader(currentUser));

        console.passwordChangingSuccess();
        dataBase.saveLog("user <id=" + currentUser.getId() + "|" + currentUser.getLogin() +
                "> changing password successfulLy");
        userReaction = scanner.nextLine();
        if (userReaction.equals("1") || userReaction.equals("2"))
            if (userReaction.equals("1")) stage = 6;
            else stage = 0;

        return stage;
    }

    public int payFine(ReaderUser currentUser, PersonalCabinetView console, FileSavingSystem dataBase){
        String userReaction;
        Scanner scanner = new Scanner(System.in);
        int stage = -1;

        dataBase.saveLog("user <id=" + currentUser.getId() + "|" + currentUser.getLogin() +
                "> payed fine");
        console.finePayingSuccess();
        currentUser.setFine(0);

        ReadersBase readersBase = new ReadersBase(dataBase.readReadersData());
        dataBase.saveReadersData(readersBase.updateReader(currentUser));

        userReaction = scanner.nextLine();
        if (userReaction.equals("1") || userReaction.equals("2"))
            if (userReaction.equals("1")) stage = 6;
        else stage = 0;


        return stage;
    }

    public int bookReturn(ReaderUser currentUser, PersonalCabinetView console, FileSavingSystem dataBase){
        Scanner scanner = new Scanner(System.in);
        LocalDate today;
        BookSubscription bookSubscription;
        if (currentUser.getBooksInSubscriptions() == null) {
            console.noBookToReturn();
            scanner.nextLine();
        } else {
            console.bookReturnId();
            while (true) try {
                int bookId = Integer.parseInt(scanner.nextLine());
                if (currentUser.getBooksInSubscriptions().stream().filter(bookSubscription1 ->
                        bookSubscription1.getBookId() == bookId).toList().isEmpty()) throw new Exception();
                bookSubscription = currentUser.getBooksInSubscriptions().stream().filter(bookSubscription1 ->
                        bookSubscription1.getBookId() == bookId).toList().get(0);
                break;
            } catch (Exception e){
                System.out.println("Try again" + "\r\n");
            }
            console.todayDate();
            while (true) try {
                today = LocalDate.parse(scanner.nextLine());
                break;
            } catch (Exception e){
                System.out.println("Try again" + "\r\n");
            }
            if (today.isAfter(bookSubscription.getDateOfPossibleReturn())) {
                currentUser.setFine(currentUser.getFine() + bookSubscription.getFineIfNotReturned());
            }

            BookSubscription finalBookSubscription = bookSubscription;
            currentUser.setBooksInSubscriptions(currentUser.getBooksInSubscriptions().stream().filter(
                    bookSubscription1 -> bookSubscription1.getBookId() != finalBookSubscription.getBookId()
            ).toList());
            ReadersBase readersBase = new ReadersBase(dataBase.readReadersData());
            readersBase.updateReader(currentUser);
            dataBase.saveReadersData(readersBase.getReaders());

        }
        return 6;
    }
}

package LibraryConsoleApp.controlers;

import LibraryConsoleApp.FileSavingSystem;
import LibraryConsoleApp.library.BookSubscription;
import LibraryConsoleApp.library.BookSubscriptionRequest;
import LibraryConsoleApp.library.Library;
import LibraryConsoleApp.userInterfaces.BlockUserView;
import LibraryConsoleApp.userInterfaces.LibrarianView;
import LibraryConsoleApp.users.Librarian;
import LibraryConsoleApp.users.ReaderUser;
import LibraryConsoleApp.users.ReadersBase;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class LibrarianController {
    public LibrarianController() {
    }

    FileSavingSystem dataBase = new FileSavingSystem();
    ReadersBase readersBase = new ReadersBase(dataBase.readReadersData());
    Library library = new Library(dataBase.readBooksData());
    List<BookSubscriptionRequest> requests = dataBase.readRequestData();
    List<Librarian> librarians = dataBase.readLibrariansData();
    String userReaction;
    Scanner scanner = new Scanner(System.in);

    LibrarianView console = new LibrarianView();
    public int active(){

        int stage = -3;

        while (stage != 0) {

            while(true)try {

                console.librarianMainMenu();
                userReaction = scanner.nextLine();

                if (!userReaction.equals("1") && !userReaction.equals("2")
                        && !userReaction.equals("3") && !userReaction.equals("4")
                        && !userReaction.equals("5")) throw new Exception();
                else if (userReaction.equals("1")) stage = new BlockUserController().listOfReaders();
                else if (userReaction.equals("2")) stage = this.listOfRequests();
                else if (userReaction.equals("3")) stage = this.addBookSub();
                else if (userReaction.equals("4")) stage = new AdminController().listOfBooks();
                else stage = 0;
                break;
            } catch (Exception e){
                System.out.println("\r\n" + "Try again" + "\r\n");
            }

        }
        return stage;
    }

    private int listOfRequests(){
        console.listOfRequests();
        scanner.nextLine();

        return -3;
    }
    private int addBookSub(){
        BookSubscription bookSubscription = new BookSubscription();
        BookSubscriptionRequest bookSubscriptionRequest = new BookSubscriptionRequest();
        while (true)try {
            console.requestBookId();
            while (true) try {
                bookSubscription.setBookId(Integer.parseInt(scanner.nextLine()));
                bookSubscriptionRequest.setBookId(bookSubscription.getBookId());
                break;
            } catch (Exception e) {
                System.out.println("Try again" + "\r\n");
            }
            console.requestReaderId();
            while (true) try {
                bookSubscriptionRequest.setReaderId(Integer.parseInt(scanner.nextLine()));
                break;
            } catch (Exception e) {
                System.out.println("Try again" + "\r\n");
            }
            if (requests.stream().filter(request -> request.equals(bookSubscriptionRequest)).toList().isEmpty()) throw new Exception();
            break;
        } catch (Exception e) {
            System.out.println("No request for this user" + "\r\n");
        }
        console.BookSubDate();
        while (true) try{
            bookSubscription.setDateOfPossibleReturn(LocalDate.parse(scanner.nextLine()));
            break;
        } catch (Exception e) {
            System.out.println("Try again" + "\r\n");
        }

        console.BookSubFine();
        while (true) try{
            bookSubscription.setFineIfNotReturned(Integer.parseInt(scanner.nextLine()));
            break;
        } catch (Exception e) {
            System.out.println("Try again" + "\r\n");
        }
        requests = requests.stream().filter(request -> !request.equals(bookSubscriptionRequest)).toList();
        dataBase.saveRequestData(requests);
        readersBase.searchById(bookSubscriptionRequest.getReaderId()).addBookInSubscription(bookSubscription);
        dataBase.saveReadersData(readersBase.getReaders());

        return -3;
    }


}

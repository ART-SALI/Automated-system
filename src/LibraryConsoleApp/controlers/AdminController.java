package LibraryConsoleApp.controlers;

import LibraryConsoleApp.FileSavingSystem;
import LibraryConsoleApp.library.Book;
import LibraryConsoleApp.library.BookSubscriptionRequest;
import LibraryConsoleApp.library.Library;
import LibraryConsoleApp.userInterfaces.AdminView;
import LibraryConsoleApp.userInterfaces.ConsoleView;
import LibraryConsoleApp.userInterfaces.MainMenuView;
import LibraryConsoleApp.users.Administrator;
import LibraryConsoleApp.users.Librarian;
import LibraryConsoleApp.users.ReaderUser;
import LibraryConsoleApp.users.ReadersBase;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AdminController {

    AdminView console = new AdminView();
    Administrator admin = new Administrator();
    public AdminController() {
    }

    public int activate(){
        //take data from files
        FileSavingSystem dataBase = new FileSavingSystem();
        ReadersBase readersBase = new ReadersBase(dataBase.readReadersData());
        Library library = new Library(dataBase.readBooksData());
        List<BookSubscriptionRequest> requests = dataBase.readRequestData();
        List<Librarian> librarians = dataBase.readLibrariansData();

        //creating interface to communicate with user

        String userReaction;
        Scanner scanner = new Scanner(System.in);

        dataBase.saveLog("Admin entered the system");

        int stage = -2;


        while (stage != 0) {

            console.mainAdminMenu();
            userReaction = scanner.nextLine();

            while(true)try {

                if (!userReaction.equals("1") && !userReaction.equals("2")
                        && !userReaction.equals("3") && !userReaction.equals("4")
                        && !userReaction.equals("5") && !userReaction.equals("6")
                        && !userReaction.equals("7") && !userReaction.equals("8")
                        && !userReaction.equals("9") && !userReaction.equals("10")
                        && !userReaction.equals("11") && !userReaction.equals("12")) throw new Exception();
                else if (userReaction.equals("1")) stage = this.addBook();
                else if (userReaction.equals("2")) stage = this.deleteBook();
                else if (userReaction.equals("3")) stage = new ChangeBookController().change();
                else if (userReaction.equals("4")) stage = new LibrarianChangeController().addLibrarian();
                else if (userReaction.equals("5")) stage = new LibrarianChangeController().deleteLibrarian();
                else if (userReaction.equals("6")) stage = new LibrarianChangeController().listOfLibrarians();
                else if (userReaction.equals("7")) stage = new BlockUserController().block();
                else if (userReaction.equals("8")) stage = new BlockUserController().unblock();
                else if (userReaction.equals("9")) stage = new BlockUserController().listOfReaders();
                else if (userReaction.equals("10")) stage = this.listOfBooks();
                else stage = 0;
                break;
            } catch (Exception e){
                System.out.println("\r\n" + "Try again" + "\r\n");
            }

        }
        return stage;
    }

    private int addBook(){
        Scanner scanner = new Scanner(System.in);

        int stage = -2;
        Book book = new Book();

        console.addBookName();
        book.setName(scanner.nextLine());
        console.addBookAuthor();
        book.setAuthor(scanner.nextLine());
        console.addBookPublication();
        book.setPublication(scanner.nextLine());
        console.addBookDateOfPublication();
        while (book.getDateOfPublication() == null){
           try{
               book.setDateOfPublication(LocalDate.parse(scanner.nextLine()));
           } catch (Exception e) {
               System.out.println("Try again" + "\r\n");
           }
        }

        console.addBookNumberOfCopy();
        while (book.getNumberOfCopy() == 0){
            try{
                book.setNumberOfCopy(Integer.parseInt(scanner.nextLine()));
            } catch (Exception e) {
                System.out.println("Try again" + "\r\n");
            }
        }


        admin.addBook(book);

        return stage;
    }

    private int deleteBook(){
        Scanner scanner = new Scanner(System.in);

        console.deleteBook();
        while (true){
            try{
                admin.deleteBook(Integer.parseInt(scanner.nextLine()));
                break;
            } catch (Exception e) {
                System.out.println("Try again" + "\r\n");
            }
        }


        return -2;
    }

    public int listOfBooks(){
        console.listOfBooks();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        return -2;
    }

}

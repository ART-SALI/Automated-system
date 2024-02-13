package LibraryConsoleApp.controlers;

import LibraryConsoleApp.userInterfaces.ChangeBookView;
import LibraryConsoleApp.userInterfaces.LibrarianChangeView;
import LibraryConsoleApp.users.Administrator;

import java.time.LocalDate;
import java.util.Scanner;

public class LibrarianChangeController {

    LibrarianChangeView console = new LibrarianChangeView();
    Scanner scanner = new Scanner(System.in);
    String userReaction;

    Administrator admin = new Administrator();


    public LibrarianChangeController() {
    }

    public int listOfLibrarians(){
        console.listOfLibrarions();
        scanner.nextLine();
        return -2;
    }

    public int deleteLibrarian(){
        console.librarianDelete();
        while (true)try{
                admin.deleteLibrarian(Integer.parseInt(scanner.nextLine()));
                break;
            } catch (Exception e) {
                System.out.println("Try again" + "\r\n");
            }
        return -2;
    }

    public int addLibrarian(){
        console.librarianLogin();
        userReaction = scanner.nextLine();
        while (true)try{
            console.librarianPassword();
            String password = scanner.nextLine();
            console.librarianPasswordRepeat();
            if (!password.equals(scanner.nextLine())) throw new Exception();
            else admin.addLibrarian(userReaction, password);
            break;
        } catch (Exception e) {
            System.out.println("\r\n" + "Try again" + "\r\n");
        }
        return -2;
    }
}

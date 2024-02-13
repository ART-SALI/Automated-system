package LibraryConsoleApp.userInterfaces;

import LibraryConsoleApp.FileSavingSystem;
import LibraryConsoleApp.users.Librarian;

import java.util.List;

public class LibrarianChangeView {

    public LibrarianChangeView() {
    }

    public void librarianLogin(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write librarian login" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }
    public void librarianPassword(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write librarian password" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void librarianPasswordRepeat(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write librarian password second time to be sure password right" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void librarianDelete(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n" + "\r\n" +
                "Write id of librarian you want to delete" + "\r\n" + "\r\n" + "\r\n" +
                "--------------------------------------------"
        );
    }

    public void listOfLibrarions(){
        System.out.println("--------------------------------------------" + "\r\n" + "\r\n");
        FileSavingSystem fileSavingSystem = new FileSavingSystem();
        List<Librarian> librarians = fileSavingSystem.readLibrariansData();
        librarians.forEach(librarian ->
                System.out.println(librarian.getId() + " | " +
                    librarian.getLogin() + " | " +
                    librarian.getPassword())
        );
        System.out.println("\r\n" + "\r\n" + "--------------------------------------------");
    }

}

package LibraryConsoleApp.controlers;

import LibraryConsoleApp.FileSavingSystem;
import LibraryConsoleApp.userInterfaces.LoginView;
import LibraryConsoleApp.users.Librarian;
import LibraryConsoleApp.users.ReaderUser;
import LibraryConsoleApp.users.ReadersBase;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class LoginController {

    public LoginController() {
    }

    public ReaderUser logging(){

        String adminLog = "admin";
        String adminPass = "admin";
        //take data from files
        FileSavingSystem dataBase = new FileSavingSystem();
        ReadersBase readersBase = new ReadersBase(dataBase.readReadersData());
        List<Librarian> librarians = dataBase.readLibrariansData();
        //creating interface to communicate with user
        LoginView console = new LoginView();
        String userReaction;
        Scanner scanner = new Scanner(System.in);
        ReaderUser currentUser = null;

        dataBase.saveLog("login of registred user");
        String finalUserReaction;
        String password;
        AtomicReference<String> finalPassword = new AtomicReference<>();
        console.registeredEnteringLogin();
        userReaction = scanner.nextLine();
        if (userReaction.equals(adminLog)) {
            console.registeredEnteringPassword();
            userReaction = scanner.nextLine();
            if (userReaction.equals(adminPass)) {
                return new ReaderUser(-2, adminLog, adminPass);
            } else {
                finalUserReaction = adminLog;
                password = readersBase.searchByLogin(adminLog).getPassword();
            }
        } else {
            finalUserReaction = userReaction;
            String finalUserReaction1 = userReaction;
            librarians.forEach(librarian -> {
                if(librarian.getLogin().equals(finalUserReaction1)){
                    finalPassword.set(librarian.getPassword());
                }
            });
            try {
                password = readersBase.searchByLogin(userReaction).getPassword();
            } catch (Exception e){
                password = null;
            }
            console.registeredEnteringPassword();
            userReaction = scanner.nextLine();
            if (finalPassword.get() != null) {
                if(userReaction.equals(finalPassword.get())){
                    return new ReaderUser(-3, "lib", finalPassword.get());
                }
            }
        }

        if (password.equals(userReaction)) {

            console.congratulationWithEntering();

            currentUser = readersBase.searchByLogin(finalUserReaction);

            dataBase.saveLog("user <id=" +
                    currentUser.getId() + "|" + currentUser.getLogin() +
                    "> entered the system");

            userReaction = scanner.nextLine();
        }

        return currentUser;
    }

}

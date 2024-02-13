package LibraryConsoleApp.controlers;

import LibraryConsoleApp.FileSavingSystem;
import LibraryConsoleApp.userInterfaces.RegistrationView;
import LibraryConsoleApp.users.ReaderUser;
import LibraryConsoleApp.users.ReadersBase;

import java.util.Objects;
import java.util.Scanner;

public class RegistrationController {

    public RegistrationController() {
    }

    public ReaderUser registration(ReadersBase readersBase){

        //take data from files
        FileSavingSystem dataBase = new FileSavingSystem();

        //creating interface to communicate with user
        RegistrationView console = new RegistrationView();
        String userReaction;
        Scanner scanner = new Scanner(System.in);

        int stage = 3;

        dataBase.saveLog("unregistered user is asked to be registred");
        console.askRegistrationMenu();
        userReaction = scanner.nextLine();
        if (!Objects.equals(userReaction, "1") && !userReaction.equals("2")) {
            return null;
        } else {
            stage += Integer.parseInt(userReaction);
        }

        //choose of login/registration/exit
        if (stage == 5) {

            dataBase.saveLog("unregistered user did not agree to be registred and is asked to login, register or exit");

            console.unregisteredCantEnterMenu();
            userReaction = scanner.nextLine();

            if (!Objects.equals(userReaction, "1") && !userReaction.equals("2") && !userReaction.equals("3")) {

                return null;

            } else if (userReaction.equals("1")) {

                dataBase.saveLog("unregistered user choose login");
                return new LoginController().logging();
            } else if (userReaction.equals("2")) {

                dataBase.saveLog("unregistered user choose registration");
                stage = 4;
            } else if (userReaction.equals("3")) {

                dataBase.saveLog("unregistered user choose exit");
                ReaderUser exit = new ReaderUser();
                exit.setId(-1);
                return exit;
            }

        }


        //registration block
        if (stage == 4) {

            dataBase.saveLog("unregistered user agreed to be registred and start registration");
            ReaderUser readerUser = new ReaderUser();

            console.registrationMenuLogin();
            userReaction = scanner.nextLine();

            readerUser.setLogin(userReaction);

            console.registrationMenuPassword();
            String password = scanner.nextLine();

            console.registrationMenuPasswordApproving();
            userReaction = scanner.nextLine();

            //password checking
            if (Objects.equals(password, userReaction)) {
                readerUser.setPassword(password);

                //adding user to readers
                readerUser.setId(readersBase.getMaxId());
                readersBase.setMaxId(readersBase.getMaxId() + 1);
                readersBase.add(readerUser);



                dataBase.saveLog("new user <id=" +
                        readerUser.getId() + "|" + readerUser.getLogin() +
                        "> successfully registred and entered the system");

                return readerUser;
            } else {

                dataBase.saveLog("something went wrong with registration");
                return null;
            }
        }


        return null;
    }
}

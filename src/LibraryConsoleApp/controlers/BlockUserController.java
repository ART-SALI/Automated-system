package LibraryConsoleApp.controlers;

import LibraryConsoleApp.FileSavingSystem;
import LibraryConsoleApp.userInterfaces.BlockUserView;
import LibraryConsoleApp.users.Administrator;
import LibraryConsoleApp.users.ReadersBase;

import java.util.Scanner;

public class BlockUserController {

    FileSavingSystem dataBase = new FileSavingSystem();
    BlockUserView console = new BlockUserView();

    Scanner scanner = new Scanner(System.in);
    String userReaction;

    Administrator admin = new Administrator();

    ReadersBase readersBase = new ReadersBase(dataBase.readReadersData());

    public BlockUserController() {
    }

    public int listOfReaders(){
        console.listOfReaders();
        scanner.nextLine();
        return -2;
    }

    public int block(){
        console.block();
        while (true)try{
            admin.blockReader(Integer.parseInt(scanner.nextLine()));
            break;
        } catch (Exception e) {
            System.out.println("Try again" + "\r\n");
        }
        return -2;
    }

    public int unblock(){
        console.unblock();
        while (true)try{
            admin.unblockReader(Integer.parseInt(scanner.nextLine()));
            break;
        } catch (Exception e) {
            System.out.println("Try again" + "\r\n");
        }
        return -2;
    }
}

package LibraryConsoleApp.controlers;

import LibraryConsoleApp.userInterfaces.ChangeBookView;
import LibraryConsoleApp.users.Administrator;

import java.time.LocalDate;
import java.util.Scanner;

public class ChangeBookController {
    ChangeBookView console = new ChangeBookView();
    Scanner scanner = new Scanner(System.in);
    String userReaction;

    Administrator admin = new Administrator();
    public ChangeBookController() {
    }

    public int change(){

        console.changeBookMenu();
        while (true) try {

            userReaction = scanner.nextLine();
            if (!userReaction.equals("1") && !userReaction.equals("2")
                    && !userReaction.equals("3") && !userReaction.equals("4")
                    && !userReaction.equals("5") && !userReaction.equals("6")) throw new Exception();
            else if (userReaction.equals("1")) this.changeName();
            else if (userReaction.equals("2")) this.changeAuthor();
            else if (userReaction.equals("3")) this.changePublication();
            else if (userReaction.equals("4")) this.changeDateOfPublication();
            else if (userReaction.equals("5")) this.changeNumBerOfCopyMenu();
            else return -2;
            break;
        } catch (Exception e) {
            System.out.println("Try again" + "\r\n");
        }

        return -2;
    }

    private void changeName(){
        int bookId;
        console.changeBookGetId();
        while (true) try{
                bookId = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Try again" + "\r\n");
            }
        console.changeBookName();
        admin.changeBookName(bookId, scanner.nextLine());
    }
    private void changeAuthor(){
        int bookId;
        console.changeBookGetId();
        while (true) try{
            bookId = Integer.parseInt(scanner.nextLine());
            break;
        } catch (Exception e) {
            System.out.println("Try again" + "\r\n");
        }
        console.changeBookAuthor();
        admin.changeBookAuthor(bookId, scanner.nextLine());
    }
    private void changePublication(){
        int bookId;
        console.changeBookGetId();
        while (true) try{
            bookId = Integer.parseInt(scanner.nextLine());
            break;
        } catch (Exception e) {
            System.out.println("Try again" + "\r\n");
        }
        console.changeBookPublication();
        admin.changeBookPublication(bookId, scanner.nextLine());
    }
    private void changeDateOfPublication(){
        int bookId;
        console.changeBookGetId();
        while (true) try{
            bookId = Integer.parseInt(scanner.nextLine());
            break;
        } catch (Exception e) {
            System.out.println("Try again" + "\r\n");
        }
        console.changeBookDateOfPublication();
        while (true) try {
            admin.changeBookDateOfPublication(bookId, LocalDate.parse(scanner.nextLine()));
        }catch (Exception e) {
                System.out.println("Try again" + "\r\n");
            }
    }
    private void changeNumBerOfCopyMenu(){
        int bookId;
        console.changeBookGetId();
        while (true) try{
            bookId = Integer.parseInt(scanner.nextLine());
            break;
        } catch (Exception e) {
            System.out.println("Try again" + "\r\n");
        }

        console.changeBookNumberOfCopyMenu();

        while (true) try {

            userReaction = scanner.nextLine();
            if (!userReaction.equals("1") && !userReaction.equals("2")
                    && !userReaction.equals("3") && !userReaction.equals("4")) throw new Exception();
            else if (userReaction.equals("1")) {
                console.changeBookNumberOfCopySet();
                while (true) try{
                    admin.changeBookNumberOfCopy(bookId, Integer.parseInt(scanner.nextLine()));
                    break;
                } catch (Exception e) {
                    System.out.println("Try again" + "\r\n");
                }
            } else if (userReaction.equals("2")) {
                console.changeBookNumberOfCopyAdd();
                while (true) try{
                    admin.addBookNumberOfCopy(bookId, Integer.parseInt(scanner.nextLine()));
                    break;
                } catch (Exception e) {
                    System.out.println("Try again" + "\r\n");
                }
            } else if (userReaction.equals("3")) {
                console.changeBookNumberOfCopyMinus();
                while (true) try{
                    admin.minusBookNumberOfCopy(bookId, Integer.parseInt(scanner.nextLine()));
                    break;
                } catch (Exception e) {
                    System.out.println("Try again" + "\r\n");
                }
            }
            break;
        } catch (Exception e) {
            System.out.println("Try again" + "\r\n");
        }
    }
}

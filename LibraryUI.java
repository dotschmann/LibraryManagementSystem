import java.util.Scanner;

public class LibraryUI {

    private LibraryService libraryService;
    private Scanner scanner;



    public LibraryUI(LibraryService libraryService, Scanner scanner) {
        this.libraryService = libraryService;
        this.scanner = scanner;
    }
    



    public void menuDisplay() {
        System.out.println();	
        System.out.println("-----------------------------------------");
        System.out.println("         Welcome to the Library!");
        System.out.println("-----------------------------------------");
        System.out.println();
        System.out.println("0. Register as a new user");
        System.out.println("1. View all books");
        System.out.println("2. View available books");
        System.out.println("3. View borrowed books");
        System.out.println("4. Borrow a book");
        System.out.println("5. Return a book");
        System.out.println("6. View my borrowd books");
        System.out.println("7. View all registered users");
        System.out.println("8. Find Author's books");

        System.out.println("9. Exit");
        System.out.println();	
    }


    public boolean userInput(int userChoose) {
			if (userChoose < 0 || userChoose > 9) {
				System.out.print("Wrong number selected! ");
				System.out.println("Enter a number between(1-7): ");
			}


			switch (userChoose) {
				case 0:
					// All books
					System.out.println("                   Register");
					System.out.println("--------------------------------------------------------");
					System.out.print("Enter new User Id: ");
					long userID = scanner.nextLong();
					scanner.nextLine();
					System.out.print("Enter your name: ");
					String name = scanner.nextLine();
					libraryService.registeredUsers(userID, name);
					break;
				case 1:
					// All books
					System.out.println("                   All Books()");
					System.out.println("--------------------------------------------------------");
					libraryService.printAllBooks(libraryService.getAllBooks());
					break;
				case 2:
					//a Available books
					System.out.println("                   Available Books");
					System.out.println("--------------------------------------------------------");
					//library.printAvailableOrBorrowedBooks(library.getAvailableBooks());
					libraryService.printAvailableOrBorrowedBooks(libraryService.getBooksAvailability(true));
					break;
				case 3:
					// Borrowed books
					System.out.println("                   Borrowed Books");
					System.out.println("--------------------------------------------------------");
					//library.printAvailableOrBorrowedBooks(library.getBorrowedBooks());
					libraryService.printAvailableOrBorrowedBooks(libraryService.getBooksAvailability(false));
					break;
				case 4:
					//Borrow a book
					long isbn;
					System.out.print("Enter your ID: ");
					userID = scanner.nextLong();
                    if (!libraryService.doesUserExit(userID)) {
                        System.out.println("User not found! You are not registered");
                        break;
                    }

					System.out.print("Enter ISBN of the book: ");
					isbn = scanner.nextLong();
					libraryService.borrowBook(userID, isbn);		
					break;
				case 5:
					// Return a book
					System.out.print("Enter your ID: ");
					userID = scanner.nextLong();
                    if (!libraryService.doesUserExit(userID)) {
                        System.out.println("User not found! You are not registered");
                        break;
                    }

					System.out.print("Enter ISBN of the book: ");
					isbn = scanner.nextLong();
					libraryService.returnBook(userID, isbn);
					break;

				case 6:
					//View my borrowed books
					System.out.print("Enter your ID: ");
					userID = scanner.nextLong();
					libraryService.myBorrowedBook(userID);
					break;
				case 7:
					//View all registered users
					System.out.println("                List of registered Users");
					System.out.println("--------------------------------------------------------");
					libraryService.listRegisteredUsers();	
					
					break;
				case 8:
					//View all Author's books
					System.out.print("Enter Author's name: ");
					scanner.nextLine();
					String authorName = scanner.nextLine();
					
					
					System.out.println("                \"" + authorName + "\" search results: ");
					System.out.println("--------------------------------------------------------");
					String searchAuthor = authorName.toLowerCase();
					libraryService.printAuthorBooks(libraryService.getBooksByMatchingAuthor(searchAuthor));
					break;
				case 9:
					//Exiting the menu
					System.out.println("Exiting library menu...");
					//running = false; //exit from loop
                    return false; // loop stops

                default: System.out.println("invalid option!");

			}     
            return true;   

    }
    
}

import java.util.Scanner;

public class LibraryUI {

    private LibraryService libraryService;
    private Scanner scanner;
    private long userID;
    private long isbn;



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

			switch (userChoose) {
				case 0 -> {
					// All books
					System.out.println("                   Register");
					System.out.println("--------------------------------------------------------");
					System.out.print("Enter new User Id: ");
					userID = scanner.nextLong();
					scanner.nextLine();
					System.out.print("Enter your name: ");
					String name = scanner.nextLine();
					libraryService.registeredUsers(userID, name);
                }
				case 1 -> {
					// All books
					System.out.println("                   All Books()");
					System.out.println("--------------------------------------------------------");
					libraryService.printAllBooks(libraryService.getAllBooks());
					break;
                }
				case 2 -> {
					//a Available books
					System.out.println("                   Available Books");
					System.out.println("--------------------------------------------------------");
					//library.printAvailableOrBorrowedBooks(library.getAvailableBooks());
					libraryService.printAvailableOrBorrowedBooks(libraryService.getBooksAvailability(true));					
                }
				case 3 -> {
					// Borrowed books
					System.out.println("                   Borrowed Books");
					System.out.println("--------------------------------------------------------");
					//library.printAvailableOrBorrowedBooks(library.getBorrowedBooks());
					libraryService.printAvailableOrBorrowedBooks(libraryService.getBooksAvailability(false));
                }
					
				case 4 -> {
					//Borrow a book
					System.out.print("Enter your ID: ");
					userID = scanner.nextLong();
                    if (!libraryService.doesUserExit(userID)) {
                        System.out.println("User not found! You are not registered");
                        break;
                    }
                    System.out.print("Enter ISBN of the book: ");
                    isbn = scanner.nextLong();
                    libraryService.borrowBook(userID, isbn);		
                }
				case 5 -> {
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
                }

				case 6 -> {
					//View my borrowed books
					System.out.print("Enter your ID: ");
					userID = scanner.nextLong();
					libraryService.myBorrowedBook(userID);
                }
				case 7 -> {
					//View all registered users
					System.out.println("                List of registered Users");
					System.out.println("--------------------------------------------------------");
					libraryService.listRegisteredUsers();	
                }
				case 8 -> {

					//View all Author's books
					System.out.print("Enter Author's name: ");
					scanner.nextLine();
					String authorName = scanner.nextLine();
					
					System.out.println("                \"" + authorName + "\" search results: ");
					System.out.println("--------------------------------------------------------");
					String searchAuthor = authorName.toLowerCase();
					libraryService.printAuthorBooks(libraryService.getBooksByMatchingAuthor(searchAuthor));
                }
				case 9 -> {
					//Exiting the menu
					System.out.println("Exiting library menu...");
                    return false; // loop stops
                }
                default -> System.out.print("Wrong number selected! Enter a number between(0-9): \nInvalid option!"); 
			}     
            return true;   
    }
    
}

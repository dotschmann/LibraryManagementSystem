//import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {

    public static void borrowdAndReturned() {

	}


	public static void libraryMenu(List<Person> people,Library library, Person person, Scanner scanner, LibraryService libraryService) {
        int userChoose;
		boolean running = true;

		while (running) {

			//Menu Display
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

			//Read user input			
			System.out.print("Enter your choice: ");
			userChoose = scanner.nextInt();
			System.out.println();

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
				library.printAllBooks(library.getAllBooks());
				break;
			case 2:
				//a Available books
				System.out.println("                   Available Books");
				System.out.println("--------------------------------------------------------");
				//library.printAvailableOrBorrowedBooks(library.getAvailableBooks());
				library.printAvailableOrBorrowedBooks(library.getBooksAvailability(true));
				break;
			case 3:
				// Borrowed books
				System.out.println("                   Borrowed Books");
				System.out.println("--------------------------------------------------------");
				//library.printAvailableOrBorrowedBooks(library.getBorrowedBooks());
				library.printAvailableOrBorrowedBooks(library.getBooksAvailability(false));
				break;
			case 4:
				//Borrow a book
				long isbn;
				System.out.print("Enter your ID: ");
				userID = scanner.nextLong();
				// Person borrowPerson = people.stream().filter(b -> b.getUserID() == userID)
				// 	.findFirst()
				// 	.orElse(null);

				Person borrowPerson = libraryService.findUserById(userID);
				if (borrowPerson == null) {
					System.out.println("User not found! Please register first");
					break;
				}
				System.out.print("Enter ISBN of the book: ");
				isbn = scanner.nextLong();
				List<Book> bookToBorrow = library.getBookNameByISBN(isbn);
				if (bookToBorrow.isEmpty()) {
					System.out.println("Book not found!");
					break;
				}
				// library.printBookByISBN(bookToBorrow);
				borrowPerson.borrowedBook(bookToBorrow);
				borrowPerson.printBorrowedBooks();
				//person.borrowedBook(library.getBookNameByISBN(isbn));
				//person.setUserID(userID);
				//person.printBorrowedBooks();			
				break;
			case 5:
				// Return a book
				System.out.print("Enter your ID: ");
				userID = scanner.nextLong();
				Person returnPerson = libraryService.findUserById(userID);
				if (returnPerson == null) {
					System.out.println("User not found! You may not a registered!");
					break;
				}
				System.out.print("Enter ISBN of the book: ");
				isbn = scanner.nextLong();
				List<Book> bookToReturn = library.getBookNameByISBN(isbn);
				if (bookToReturn.isEmpty()) {
					System.out.println("Not a registered library book. Report error!");
					break;
				}
				returnPerson.returnedBook(bookToReturn);
				returnPerson.printReturnedBooks();			
				// library.printReturnedBookByISBN(bookToReturn);
				// person.returnedBook(library.getBookNameByISBN(isbn));
				// person.setUserID(userID);
				break;

			case 6:
				//View my borrowed books
				System.out.print("Enter your ID: ");
				userID = scanner.nextLong();
				person.myBorrowedBook(userID, people);
				break;
			case 7:
				//View all registered users
				System.out.println("                List of registered Users");
				System.out.println("--------------------------------------------------------");
				person.registeredUsers(people);	
				
				break;
			case 8:
				//View all Author's books
				System.out.print("Enter Author's name: ");
				scanner.nextLine();
				String authorName = scanner.nextLine();
				
				
				System.out.println("                \"" + authorName + "\" search results: ");
				System.out.println("--------------------------------------------------------");
				String searchAuthor = authorName.toLowerCase();
				library.printAuthorBooks(library.getBooksByMatchingAuthor(searchAuthor));
				break;
			case 9:
				//Exiting the menu
				System.out.println("Exiting library menu...");
				running = false; //exit from loop

				break;

			}

	    }
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList<Book> books = new ArrayList<>();
		Library library = new Library();
		Person person = new Person(0, null);
		Scanner scanner =  new Scanner(System.in);
		List<Person> people = new ArrayList<>();
		LibraryService libraryService = new LibraryService(people);

		library.addBook(new Book("Go Your Way", "Emmanuel Dotse", 123456789L, true));
		library.addBook(new Book("Shadows of Tomorrow", "Amelia Clark", 987654321L, true));
		library.addBook(new Book("The Last Horizon", "Daniel Stone", 192837465L, true));
		library.addBook(new Book("Code of Silence", "Sophia Turner", 564738291L, true));
		library.addBook(new Book("Dreamcatcher’s Path", "Michael Rivers", 837261945L, true));
		library.addBook(new Book("Echoes in Time", "Isabella Hughes", 374829105L, true));
		library.addBook(new Book("The Hidden Truth", "David Johnson", 918273645L, true));
		library.addBook(new Book("Beyond the Stars", "Olivia Carter", 746382910L, true));
		library.addBook(new Book("Winds of Change", "James Bennett", 1029384756L, true));
		library.addBook(new Book("Whispers in the Dark", "Emma Wilson", 5647382910L, true));
		library.addBook(new Book("Action alleviates Anxiety", "Emmanuel Dotse", 123489789L, true));




		libraryMenu(people, library, person, scanner, libraryService);




		scanner.close();

  }
}
		

		
		
		
		
		//library.printBooks(library.getBooksByAuthor("Emmanuel Dotse"));
		
		
		//System.out.println("Title: " + books.getTitle());
		
		// Loop through and print all books
		/*
		 * System.out.println("Library Books: "); for (Book book : books) {
		 * System.out.println(book); }
		 * 
		 * System.out.println("");
		 * 
		 * for (Book book : books) { System.out.println("ISBN: " + book.getIsbn()); }
		 * 
		 * System.out.println("");
		 * 
		 * for (Book book : books) { System.out.println("Author: " + book.getAuthor());
		 * }
		 * 
		 * System.out.println("");
		 * 
		 * for (Book book : books) { if (book.isAvailable()) {
		 * System.out.println("Available: " + book.getTitle()); } }
		 * 
		 * System.out.println(""); for (Book book : books) { if (!book.isAvailable()) {
		 * System.out.println("Unavailable: " + book.getTitle()); } }
		 * 
		 * // using .equal() for String comparision System.out.println(""); String
		 * targetAuthor = "Emmanuel Dotse";
		 * 
		 * System.out.println("Search: " + targetAuthor);
		 * System.out.println("----------------------------------------------");
		 * 
		 * for (Book book : books) { if
		 * (book.getAuthor().equalsIgnoreCase(targetAuthor)) {
		 * System.out.println(book.getTitle()); } }
		 */



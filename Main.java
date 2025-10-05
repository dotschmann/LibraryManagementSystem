//import java.util.ArrayList;

import java.util.Scanner;

public class Main {




	public static void libraryMenu(int userChoose, Library library, Person person, Scanner scanner) {

		
		while (userChoose < 1 || userChoose > 4) {
			
			if (userChoose < 1 || userChoose > 4) {
				System.out.println("Wrong number selected!");
				System.out.print("Enter your choice(1-4): ");
				userChoose = scanner.nextInt();
				System.out.println("");
			}
		}
		
		
		switch (userChoose) {
		case 1:
			// All books
			System.out.println("                   All Books");
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
			int userID;
			long isbn;
			System.out.print("Enter your ID: ");
			userID = scanner.nextInt();
			System.out.print("Enter ISBN of the book: ");
			isbn = scanner.nextLong();
			library.printBookByISBN(library.getBookNameByISBN(isbn));
			person.borrowedBook(library.getBookNameByISBN(isbn));
			person.setUserID(userID);
			person.printBorrowedBooks();			
			break;
		case 5:
			// Return a book
			
			break;
		case 6:
			//View my borrowed books
			
			break;

		default:
			break;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList<Book> books = new ArrayList<>();
		Library library = new Library();
		Person person = new Person(0, null);
		
		library.addBook(new Book("Go Your Way", "Emmanuel Dotse", 123456789L, true));
		library.addBook(new Book("Shadows of Tomorrow", "Amelia Clark", 987654321L, true));
		library.addBook(new Book("The Last Horizon", "Daniel Stone", 192837465L, false));
		library.addBook(new Book("Code of Silence", "Sophia Turner", 564738291L, true));
		library.addBook(new Book("Dreamcatcher’s Path", "Michael Rivers", 837261945L, true));
		library.addBook(new Book("Echoes in Time", "Isabella Hughes", 374829105L, false));
		library.addBook(new Book("The Hidden Truth", "David Johnson", 918273645L, true));
		library.addBook(new Book("Beyond the Stars", "Olivia Carter", 746382910L, true));
		library.addBook(new Book("Winds of Change", "James Bennett", 1029384756L, false));
		library.addBook(new Book("Whispers in the Dark", "Emma Wilson", 5647382910L, true));
		library.addBook(new Book("Action alleviates Anxiety", "Emmanuel Dotse", 123489789L, true));
		
		
		
		
		System.out.println();
		System.out.println("Welcome to the Library!");
		System.out.println("------------------------");
		System.out.println("");
		System.out.println("1. View all books");
		System.out.println("2. View available books");
		System.out.println("3. View borrowed books");
		System.out.println("4. Borrow a book");
		System.out.println("5. Return a book");
		System.out.println("6. View my borrowd books");
		System.out.println();
		
		

		
		//Read user input
        
		Scanner scanner =  new Scanner(System.in);
		System.out.print("Enter your choice: ");
	    int userChoose = scanner.nextInt();
		System.out.println("");

		libraryMenu(userChoose, library, person, scanner);
		
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


//import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {

	public static void libraryMenu(Scanner scanner, LibraryUI libraryUI) {
        int userChoose;
		boolean running = true;

		while (running) {

			//Menu Display
			libraryUI.menuDisplay();


			//Read user input			
			System.out.print("Enter your choice: ");
			userChoose = scanner.nextInt();
			System.out.println();

			libraryUI.userInput(userChoose, running);

	    }
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList<Book> books = new ArrayList<>();
		Library library = new Library();
		Person person = new Person(0, null);
		Scanner scanner =  new Scanner(System.in);
		List<Person> people = new ArrayList<>();
		LibraryService libraryService = new LibraryService(people,library, person);
		LibraryUI libraryUI = new LibraryUI(libraryService, scanner);

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




		libraryMenu(scanner, libraryUI);




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



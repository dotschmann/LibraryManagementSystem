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

			running = libraryUI.userInput(userChoose);

	    }
	}


	public static void main(String[] args) {
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
		
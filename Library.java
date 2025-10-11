import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Library {
	
	private List<Book> books; // Holding all the books in the library
	//private List<Person> person;

	// When you create a new Library object, this constructor initializes the books list as an empty ArrayList
	public Library() {
		books = new ArrayList<>();
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public List<Book> getAllBooks() {
		return books.stream()
				.collect(Collectors.toList());
	}
	
	/*
	 * public List<Book> getAvailableBooks() { return books.stream()
	 * .filter(Book::isAvailable) // or filter .collect(Collectors.toList()); }
	 * 
	 * public List<Book> getBorrowedBooks() { return books.stream() .filter(book ->
	 * !book.isAvailable()) // or filter .collect(Collectors.toList()); }
	 */
	
	
	public List<Book> getBooksAvailability(boolean available) {
		return books.stream()
				.filter(book -> book.isAvailable() == available)
				.collect(Collectors.toList());
	}
	
	public List<Book> getBooksByAuthor(String author) {
		return books.stream()
				.filter(book -> book.getAuthor().equalsIgnoreCase(author))
				.collect(Collectors.toList());
	}
	
	public List<Book> getBookNameByISBN(long isbn){
		return books.stream()
				.filter(book -> book.getIsbn() == isbn)
                .collect(Collectors.toList());
	}
	
	public void printAllBooks(List<Book> bookList) {
		int i = 1;
		for (Book book : bookList) {
			String status;
			if(book.isAvailable()) {
				status = "Available";
			} else {
				status = "Borrowed";
			}
			System.out.println(i + ". " + book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ") - "  + status);			
			i++;
		}
		
	}	
	
	public void printAvailableOrBorrowedBooks(List<Book> bookList) {
		int i = 1;
		if (bookList.isEmpty()) {
			System.out.println("No Book borrowed yet!");
		} else {			
			for (Book book : bookList) {
					System.out.println(i + ". " + book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ")");			
					i++;
			}
		}

	}

	public void printAuthorBooks(List<Book> bookListofAuthor) {
		int i = 1;
		if (bookListofAuthor.isEmpty()) {
			System.out.println("Author is not on our List");
		} else {
			for (Book book : bookListofAuthor) {
				String status;
				if(book.isAvailable()) {
					status = "Available";
				} else {
					status = "Borrowed";
				}
				System.out.println(i + ". " + book.getTitle() + " [" + status +"]");
				i++;
			}
		}
	}
	
	// public void printBookByISBN(List<Book> bookList) {
	// 	for (Book book : bookList) {
	// 		System.out.println("Book " + "\"" + book.getTitle() + "\" borrowed successfully");			
			
	//    }
	// }
	// public void printReturnedBookByISBN(List<Book> bookList) {
	// 	for (Book book : bookList) {
	// 		System.out.println("Book " + "\"" + book.getTitle() + "\" return successfully");			
			
	//    }
	// }
	

}

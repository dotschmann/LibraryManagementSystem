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
	
	public List<Book> getBooksByMatchingAuthor(String author) {
		return books.stream()
				.filter(book -> book.getAuthor().toLowerCase().contains(author))
				.collect(Collectors.toList());
	}
	
	public List<Book> getBookNameByISBN(long isbn){
		return books.stream()
				.filter(book -> book.getIsbn() == isbn)
                .collect(Collectors.toList());
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

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	// create id and name of person who have borrrowed book. the books they have borrowed and the ones they have returned. store user id with name and book borrowed
	private long userID;
	private String userName;
	private List<Book> borrowedBooks;
	
	public Person(long userID, String userName) {
		this.userID = userID;
		this.userName = userName;
		this.borrowedBooks = new ArrayList<>();
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public List<Book> getBorrowedBooks() {	
		return borrowedBooks;
	}
	
	
	//borrowd a book
	
	public void borrowedBook(List<Book> list) {
		for (Book book : list) {
			if (!book.isAvailable()) { // unavailable - false
				System.out.println(book.getTitle() + " by " + book.getAuthor() + " is not available");
			} else {
				borrowedBooks.add(book);
				book.isAvailable(false);			// set tp false to make it unavailable
			}
		}
	}
	
	public void printBorrowedBooks() {	
		System.out.println(getUserID() + " has borrowed:");
		if (borrowedBooks.isEmpty()) {
			System.out.println("No books borrowed yet");
			return;
		}
		for (Book book : borrowedBooks) {
				System.out.println("- " + book.getTitle());	
		}
	}



}

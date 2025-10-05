
public class Book {

	/**
	 * 
	 */
	
	//title
	private String title;
	//author
	private String author;
	//ISBN
	private long isbn;
	//status - available/borrowed
	private boolean status;
	
	
	public Book(String title, String author, long isbn, boolean status) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.status = status;
	}

    
	// Getters
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public long getIsbn() {
		return isbn;
	}
	
	public boolean isAvailable() {
		return status;
	}
	
	
	// Setters
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public void isAvailable(boolean status) {
		this.status = status;
	}
	
	//For printing directly
	
	@Override
	public String toString() {
		return "\"" + title + "\" by " + author + " (ISBN: " + isbn + ") - " + (status ? "Available": "Borrowed");
	}
	
	
	
	
	


}

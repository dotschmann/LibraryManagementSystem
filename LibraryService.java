import java.util.List;
//import java.util.concurrent.LinkedTransferQueue;

public class LibraryService {
    private List<Person> users;
    private Library library;
    private Person person;
  


    public LibraryService(List<Person> users, Library library, Person person) {
        this.users = users;
        this.library = library;
        this.person = person;
    }

    public void registeredUsers(long userID, String name){
        boolean exist = users.stream().anyMatch(pn -> pn.getUserID() == userID);
        if (exist) {
            System.out.println("User with this ID already exists!");
        } else {	
            users.add(new Person(userID, name));
            System.out.println("User registered successfully");
        }
    }

    public Person findUserById(long id) {
        return users.stream().filter(u -> u.getUserID() == id)
            .findFirst()
            .orElse(null);
    }

    public void borrowBook (long userID, long ISBN) {
        Person borrowPerson = findUserById(userID);
        if (borrowPerson == null) {
            System.out.println("User not found! Please register first");
            return;
        }

        List<Book> bookList = library.getBookNameByISBN(ISBN);
        if(bookList.isEmpty()) {
            System.out.println("Book not found!");
            return;
        }

        borrowPerson.borrowedBook(bookList);
        borrowPerson.printBorrowedBooks();
    }


    public void returnBook(long userID, long ISBN) {
        Person returnPerson = findUserById(userID);
        if (returnPerson == null) {
            System.out.println("USer not found! You are not registered!");
            return;
        }
        
        List<Book> bookList = library.getBookNameByISBN(ISBN);
        if (bookList.isEmpty()) {
            System.out.println("Not a registered library book. Report error!");
            return;
        }

        returnPerson.returnedBook(bookList);
        returnPerson.printReturnedBooks();
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


    public void myBorrowedBook(long borrowerID) {
		boolean existID = users.stream().anyMatch(id -> id.getUserID() == borrowerID);
		Person foundID = users.stream().filter(p -> p.getUserID() == borrowerID).findFirst().orElse(null);
		if(foundID == null) {
			System.out.println("User not found! Please register first.");
			return;
		}
		if (existID) {
			if (foundID.getBorrowedBooks().isEmpty()) {
				System.out.println(foundID.getUserID() + " has not borrowed any book yet!");
				System.out.println();
				System.out.println();
				return;
			} else {
				System.out.println("    " + foundID.getUserName() + " borrowed Book(s): ");
				System.out.println("-----------------------------------------");
				for (Book book : foundID.getBorrowedBooks()) {
					System.out.println(" - " + book.getTitle());
				}
				System.out.println();
				System.out.println();
			}
		} else {
			System.out.println("You have no borrowed books!");
		}
	}

    public void printAuthorBooks(List<Book> bookListofAuthor) {
		int i = 1;
		if (bookListofAuthor.isEmpty()) {
			System.out.println("Author is not on our List");
		} else {
			for (Book book : bookListofAuthor) {
				String status;
				if (book.isAvailable()) {
					status = "Available";
				} else {
					status = "Borrowed";
				}
				System.out.println(i + ". " + book.getAuthor() + ": " + book.getTitle() + " [" + status +"]");
				i++;
			}
		}
	}

    public void listRegisteredUsers() {
        person.registeredUsers(users);
    }

    public List<Book> getAllBooks() {
        return library.getAllBooks();
    }

    public List<Book> getBooksAvailability(boolean available) {
        return library.getBooksAvailability(available);
    }
    public List<Book> getBooksByMatchingAuthor(String author) {
        return library.getBooksByMatchingAuthor(author);
    }



}

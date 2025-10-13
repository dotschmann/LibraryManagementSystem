import java.util.List;

public class LibraryService {
    private List<Person> users;


    public LibraryService(List<Person> users) {
        this.users = users;
    }

    public Person findUserById(long id) {
        return users.stream().filter(u -> u.getUserID() == id)
            .findFirst()
            .orElse(null);
    }



}

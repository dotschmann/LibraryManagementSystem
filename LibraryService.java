import java.util.List;

public class LibraryService {
    private List<Person> users;
  


    public LibraryService(List<Person> users) {
        this.users = users;
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



}


import java.util.ArrayList;
import java.util.Random;

public class Seats {

    private String name;
    private String email;
    private Random rnd = new Random();
    private boolean available = rnd.nextBoolean();

    public Seats() {

    }
    public Seats(String name, String email)
    {
      this.name = name;
      this.email = email;
    }
// Sets the users name(optional if we dont want to include these two)
    public void setName(String customer) {
        this.name = customer;
    }
// Returns the users name as a String
    public String getName() {
        return name;
    }
// Sets user email
    public void setEmail(String contact) {
        this.email = contact;
    }
// returns the email as a string
    public String getEmail() {
        return email;
    }
// Books the seat if the random check is true
    public boolean bookSeat(String customer, String contact) {
        if (this.available != true) {
            return false;
        } else {
            this.name = customer;
            this.email = contact;
            this.available = false;
            return true;
        }
    }
}

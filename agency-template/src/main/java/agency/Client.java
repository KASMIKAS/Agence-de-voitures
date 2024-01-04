package agency;
import java.util.Objects;

public class Client {
    private final String firstName ;
    private final String lastName;
    private final int birthay;

    public Client(String firstName, String lastName, int birthay){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthay = birthay;
    }

    public String getFirstName(){
        return firstName ;
    }

    public String getLastName(){
        return lastName ;
    }

    public int getYearOfBirth(){
        return birthay ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return birthay == client.birthay && firstName.equals(client.firstName) && lastName.equals(client.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthay);
    }
}

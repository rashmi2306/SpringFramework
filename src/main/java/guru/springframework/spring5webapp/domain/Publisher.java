package guru.springframework.spring5webapp.domain;
import javax.persistence.*;
import java.util.*;

@Entity

public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String addressline1;
    private String city;
    private String state;
    private String zip;

    @OneToMany
    @JoinColumn(name = "publisher_id" )
    private Set<Book> books = new HashSet<>();

    public Publisher() {
    }

    public Publisher(long id, String name, String addressline1, String city, String state, String zip) {
        this.id = id;
        this.name = name;
        this.addressline1 = addressline1;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return id == publisher.id &&
                Objects.equals(name, publisher.name) &&
                Objects.equals(addressline1, publisher.addressline1) &&
                Objects.equals(city, publisher.city) &&
                Objects.equals(state, publisher.state) &&
                Objects.equals(zip, publisher.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, addressline1, city, state, zip);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressline1='" + addressline1 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

}

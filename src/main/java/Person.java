import jakarta.persistence.*;
import java.util.List;

/**
 * Represents a Person name, email.
 */

@Entity
@Table(name = "person")
@NamedQueries({
//        @NamedQuery(name = "Building.findByAddress",
//                query = "SELECT b FROM Building b WHERE b.address LIKE CONCAT('%',:address, '%'"),
        @NamedQuery(name = "Person.findAll",
                query = "from Person p join Resident r on r.person = p where r.entryRight = true and size(p.apartmentOwnerships) < 2")
})

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<Resident> residents;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<ApartmentOwnership> apartmentOwnerships;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", residents=" + residents +
                ", apartmentOwnerships=" + apartmentOwnerships +
                '}';
    }
}

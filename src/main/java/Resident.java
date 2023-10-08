import jakarta.persistence.*;


/**
 * Represents a Resident entity with a person and apartment association.
 */

@Entity
@Table(name = "resident")
public class Resident {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;


    @Column(name = "entry_right")
    private boolean entryRight;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPersonId() {
        return person;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "id=" + id +
                ", entryRight=" + entryRight +
                ", apartment=" + apartment +
                '}';
    }
}

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
    private boolean entry_right;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "apartment_id")
    private Apartment apartmentId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person personId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPersonId() {
        return personId;
    }

}

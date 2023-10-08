import jakarta.persistence.*;
/*
    Represents an Apartment Ownership entity.
 */
@Entity
@Table(name = "apartment_ownership")

public class ApartmentOwnership {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Person building;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    @Override
    public String toString() {
        return "ApartmentOwnership{" +
                "id=" + id +
                '}';
    }
}

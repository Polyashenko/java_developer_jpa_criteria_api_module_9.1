import jakarta.persistence.*;

import java.util.List;

/**
 * Represents a Building entity with a section number and address .
 */
@Entity
@Table(name = "building")

public class Building {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "address")
    private String address;

     @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
     private List<Apartment> apartments;



    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
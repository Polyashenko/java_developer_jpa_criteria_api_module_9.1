import jakarta.persistence.*;

/**
 * Represents a Building entity with a section number and address .
 */
@Entity
@Table(name = "building")
@NamedQueries({
//        @NamedQuery(name = "Building.findByAddress",
//                query = "SELECT b FROM Building b WHERE b.address LIKE CONCAT('%',:address, '%'"),
        @NamedQuery(name = "Building.findAll",
                query = "SELECT b FROM Building b")
})
public class Building {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "address")
    private String address;

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
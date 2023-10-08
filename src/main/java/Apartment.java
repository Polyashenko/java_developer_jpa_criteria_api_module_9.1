import jakarta.persistence.*;

/**
 * Represents an Apartment entity with a unique number, area.
 */
@Entity
@Table(name = "apartment")
public class Apartment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;

    @Column(name = "number")
    private int number;

    @Column(name = "area")
    private double area;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "building_id")
    private Building building;

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public double getArea() {
        return area;
    }

    public Building getBuilding() {
        return building;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", number=" + number +
                ", area=" + area +
                ", building=" + building +
                '}';
    }
}
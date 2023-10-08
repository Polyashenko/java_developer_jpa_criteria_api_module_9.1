
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


import static java.nio.charset.StandardCharsets.UTF_8;

public class DatabaseStatistics {
    public static final String RESIDENTS_WITH_OWNERSHIP_AND_ACCESS_PERMISSIONS_QUERY = "SELECT" +
            " p.name AS name," +
            " p.email AS email," +
            " b.address AS address," +
            " a.number AS number," +
            " a.area AS area" +
            " FROM" +
            " person AS p" +
            " JOIN apartment_ownership AS o ON p.id = o.person_id" +
            " JOIN apartment AS a ON o.apartment_id = a.id" +
            " JOIN building AS b ON a.building_id = b.id" +
            " JOIN resident AS r ON p.id = r.person_id" +
            " WHERE" +
            " r.entry_right = 1" +
            " GROUP BY" +
            " p.id, b.address, a.number, a.area" +
            " HAVING" +
            " COUNT(a.id) < 2";

    private final String url;
    private final String username;
    private final String password;

    public DatabaseStatistics(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void printResidentsWithOwnershipAndAccessPermissions() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("osbb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        Query query = entityManager.createNamedQuery("Person.findAll",
                Building.class);
        List<Person> result = query.getResultList();
        System.out.println(result);


    }
}

public class DatabaseApplication {

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/osbb";
    //The username for the database connection.
    public static final String USERNAME = "root";
    // The password for the database connection.
    public static final String PASSWORD = "rootroot";

    public void run() {
        new DatabaseMigration(JDBC_URL, USERNAME,PASSWORD).migrate();
        new DatabaseStatistics(JDBC_URL, USERNAME,PASSWORD).printResidentsWithOwnershipAndAccessPermissions();
    }
}


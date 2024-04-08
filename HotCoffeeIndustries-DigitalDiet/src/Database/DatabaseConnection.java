package Database;
import java.io.IOException;
import java.sql.*;

public class DatabaseConnection {

    private static Connection instance = null;

    private DatabaseConnection() {
        String url = "jdbc:sqlite:database.db";
        try {
            instance = DriverManager.getConnection(url);
        } catch (SQLException sqlEx) {
            System.err.println(sqlEx);
        }
    }

    public static Connection getInstance() {
        if (instance == null) {
            new DatabaseConnection();
        }
        return instance;
    }

    /*static final private String host = "localhost";
    static final private String port = "3306";
    static final private String database = "digitaldiet";
    static final private String user = "root";
    static final private String password = "admin";
    static final private String url = String.format("jdbc:mysql://%s:%s/%s?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", host, port, database);
     private Connection connection = connect();
     private Statement statement = initialise();

    public Database() throws SQLException {
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(
            url,
            user,
            password
        );
    }

    private Statement initialise() throws SQLException {
        return connection.createStatement();
    }

    public ResultSet selectQuery(String sqlQuery) throws SQLException {
        this.statement = initialise();
        ResultSet query = statement.executeQuery(sqlQuery);
        return query;
    }

    public void insertQuery(String sqlQuery) throws SQLException {
        this.statement = initialise();
        statement.executeUpdate(sqlQuery);
    }

    public void close() throws SQLException {
        connection.close();
    }*/
}

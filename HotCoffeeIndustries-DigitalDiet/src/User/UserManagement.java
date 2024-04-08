package User;
import App.App;

import java.sql.SQLException;
import java.util.ArrayList;


public interface UserManagement {
    String username = null;
    String password = null;
    ArrayList<App> Apps = new ArrayList<>();


    Boolean login(String username, String password) throws SQLException;

    Boolean register(String username, String password) throws SQLException;
    private Boolean isExistingUser(String username) throws SQLException {
        return null;
    };
}

package User;
import App.App;
import Database.*;
import java.sql.*;
import java.util.ArrayList;


public class User implements UserManagement{

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private String username;
    private String password;
    private ArrayList<App> Apps;

    Connection db = DatabaseConnection.getInstance();

    private Boolean isExistingUser(String username) throws SQLException {

        ResultSet users = null;
        try {
            Statement statement = db.createStatement();
            //String username = user.getUsername().toLowerCase();
            String query = "select username from users where username = " + username;
            users = statement.executeQuery(query);
        } catch (SQLException SQLex) {
            System.err.println(SQLex.getMessage());
            return null;
        }

        //Database db = new Database();
        //ResultSet users = db.selectQuery("select username from users where username = '" + username + "'");

        return users.next();
    }

    public Boolean login(String username, String password) throws SQLException {
        if (Boolean.TRUE.equals(isExistingUser(username))) {

            ResultSet users = null;
            try {
                Statement statement = db.createStatement();
                String query = "select password from users where username = " + username;
                users = statement.executeQuery(query);
            } catch (SQLException SQLex) {
                System.err.println(SQLex.getMessage());
                return null;
            }

            //Database db = new Database();
            //ResultSet users = db.selectQuery("select password from users where username = '" + username + "'");
            if (users.next()) {
                String result_password = users.getString("password");

                if (result_password.equals(password)) {
                    setUsername(username);
                    setPassword(password);

                    db.close();
                    return true;
                } else {
                    db.close();
                    return false;
                }
            } else {
                db.close();
                return false;
            }

        }
        return false;
    }

    public Boolean register(String username, String password) throws SQLException {



        if (!isExistingUser(username)) {
            try {
                Statement statement = db.createStatement();
                String query = String.format("insert into users (username, password) values ('%s','%s')", username, password);
                statement.executeQuery(query);
            } catch (SQLException SQLex) {
                System.err.println(SQLex.getMessage());
                return null;
            }

            setUsername(username);
            setPassword(password);
            this.username = username;
            this.password = password;

            return true;

        }

        return false;
    }
}

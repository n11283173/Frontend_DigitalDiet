package App;
import Category.*;
import Database.*;
import User.*;

import java.sql.*;
import java.util.ArrayList;

public class AppManager {

    public ArrayList<App> initialiseApps(User user) throws SQLException {
        Connection db = DatabaseConnection.getInstance();

        ResultSet apps = null;
        try {
            Statement statement = db.createStatement();
            String username = user.getUsername().toLowerCase();
            String query = "select * from apps where user = " + username;
            apps = statement.executeQuery(query);
        } catch (SQLException SQLex) {
            System.err.println(SQLex.getMessage());
        }
        //ResultSet apps = db.selectQuery("select * from apps where user = '" + user.getUsername() + "'");
        ArrayList<App> queryApps = new ArrayList<>();
        CategoryManager categoryManager = new CategoryManager();

        while (apps.next()) {
            App tmpApp = new App();
            tmpApp.initialiseApp(
                    apps.getInt("id"),
                    apps.getString("user"),
                    categoryManager.getCategory(apps.getInt("category")),
                    apps.getString("name"),
                    apps.getString("image_base64")
            );
            queryApps.add(tmpApp);
        }

        db.close();
        return queryApps;
    }


}

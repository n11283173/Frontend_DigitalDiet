import Database.*;
import User.*;
import Category.*;
import App.*;

import java.sql.*;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws SQLException {
        User user = new User();
        user.login("dale", "123");
        System.out.println(user.getUsername());

        AppManager appManager = new AppManager();
        ArrayList<App> apps = appManager.initialiseApps(user);

        for (App app : apps) {
            System.out.print(app.getName());
            System.out.print(", ");
            System.out.print(app.getCategory().getName());
            System.out.println();
        }
        System.out.println();

        //User user = new User();
        user.login("amit", "123");
        System.out.println(user.getUsername());
        //AppManager appManager = new AppManager();
        ArrayList<App> apps1 = appManager.initialiseApps(user);

        for (App app : apps1) {
            System.out.print(app.getName());
            System.out.print(", ");
            System.out.print(app.getCategory().getName());
            System.out.println();
        }

        /*
        Category categoryManager = new Category();
        ArrayList<Category> categories = categoryManager.initialiseCategories();

        for (Category category : categories) {
            System.out.println(category.updateLimit(category.getId(), 0).getLimit());
        }*/


        //User user = new User();
        //System.out.println(user.register("dale9", "123"));
        //System.out.println(user.login("dale8", "123"));



        /*Database db = new Database();
        ResultSet users = db.query("select * from users");

        System.out.println("Users");
        while(users.next()) {
            String username = users.getString("username");
            String password = users.getString("password");
            System.out.println(username);
            System.out.println(password);
            System.out.println();
        }

        System.out.println("Apps");
        ResultSet apps = db.query("select * from apps");
        while(apps.next()) {
            String name = apps.getString("name");
            String category = apps.getString("category");
            System.out.println(name);
            System.out.println(category);
            System.out.println();
        }

        System.out.println("Categories");
        ResultSet categories = db.query("select * from categories");
        while(categories.next()) {
            String name = categories.getString("name");
            String limit = categories.getString("limit");
            System.out.println(name);
            System.out.println(limit);
            System.out.println();
        }

        System.out.println("Logs");
        ResultSet logs = db.query("select * from logs");
        while(categories.next()) {
            String app = logs.getString("app");
            Date date = logs.getDate("date");
            Integer minutes = logs.getInt("minutes");
            System.out.println(app);
            System.out.println(date);
            System.out.println(minutes);
            System.out.println();
        }

        db.close();

         */
    }
}

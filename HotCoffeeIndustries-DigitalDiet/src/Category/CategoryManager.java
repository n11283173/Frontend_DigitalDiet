package Category;

import Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryManager {
    Connection db = DatabaseConnection.getInstance();
    public ArrayList<Category> initialiseCategories() throws SQLException {

        ResultSet categories = null;
        try {
            Statement statement = db.createStatement();
            String query = "select * from categories";
            categories = statement.executeQuery(query);
        } catch (SQLException SQLex) {
            System.err.println(SQLex.getMessage());
            return null;
        }

        ArrayList<Category> queryCategories = new ArrayList<>();

        while(categories.next()) {
            Category tmpCategory = new Category();
            tmpCategory.initialiseCategory(
                    categories.getInt("id"),
                    categories.getString("name"),
                    categories.getString("image_base64"),
                    categories.getInt("limit")
            );
            queryCategories.add(tmpCategory);
        }

        return queryCategories;
    }

    public Category getCategory(Integer categoryId) throws SQLException{
        //Connection db = DatabaseConnection.getInstance();

        ResultSet category = null;
        try {
            Statement statement = db.createStatement();
            String query = "select * from categories";
            category = statement.executeQuery(query);
        } catch (SQLException SQLex) {
            System.err.println(SQLex.getMessage());
            return null;
        }

        if (!category.next()) {
            db.close();
            return null;
        }

        Category tmpCategory = new Category();
        tmpCategory.initialiseCategory(
                category.getInt("id"),
                category.getString("name"),
                category.getString("image_base64"),
                category.getInt("limit")
        );
        return tmpCategory;
    }

}

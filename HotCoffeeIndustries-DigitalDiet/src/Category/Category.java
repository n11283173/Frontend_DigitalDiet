package Category;
import Database.DatabaseConnection;

import java.sql.*;

public class Category implements CategoryManagement{
    private Integer id;
    private String name;
    private String icon;
    private Integer limit;

    protected void initialiseCategory(int newId, String newName, String newIcon, int newLimit) {
        setId(newId);
        setName(newName);
        setIcon(newIcon);
        setLimit(newLimit);
    }

    public Category updateLimit(Integer lookupId, Integer newLimit) throws SQLException {
        if (newLimit < 0) {
            return null;
        }

        Connection db = DatabaseConnection.getInstance();

        try {
            Statement statement = db.createStatement();
            String query = "update categories set `limit` = " + newLimit + " where id = " + lookupId;
            statement.executeQuery(query);
            return this;
        } catch (SQLException SQLex) {
            System.err.println(SQLex.getMessage());
            return null;
        }
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    private void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getLimit() {
        return limit;
    }

    private void setLimit(Integer limit) {
        this.limit = limit;
    }


}

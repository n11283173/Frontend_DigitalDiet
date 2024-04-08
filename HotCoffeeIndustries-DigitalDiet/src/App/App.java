package App;
import Category.Category;
import Log.Log;
import java.util.ArrayList;
public class App implements AppManagement {
    private Integer id;
    private String user;
    private String name;
    private String icon;
    private ArrayList<Log> logs;
    private Category category;

    protected void initialiseApp(Integer newId, String newUser, Category newCategory, String newName, String newIcon) {
        setId(newId);
        setUser(newUser);
        setCategory(newCategory);
        setName(newName);
        setIcon(newIcon);
    }

    public App createApp(String name, String icon, Category category) {
        return null;
    }
    public App readApp() {
        return null;
    }
    public App updateApp(String name, String icon, Category category) {
        return null;
    }
    public void deleteApp() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public ArrayList<Log> getLogs() {
        return logs;
    }

    public void setLogs(ArrayList<Log> logs) {
        this.logs = logs;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}

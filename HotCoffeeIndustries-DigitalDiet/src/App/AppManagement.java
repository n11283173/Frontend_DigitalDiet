package App;
import Category.Category;
import Log.Log;
import java.util.ArrayList;
public interface AppManagement {
    String name = null;
    String icon = null;
    ArrayList<Log> logs = new ArrayList<>();
    Category category = null;

    App createApp(String name, String icon, Category category);
    App readApp();
    App updateApp(String name, String icon, Category category);
    void deleteApp();
}

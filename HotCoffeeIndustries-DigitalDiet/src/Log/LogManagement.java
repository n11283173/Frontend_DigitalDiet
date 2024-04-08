package Log;
import java.util.Date;

public interface LogManagement {
    Date date = null;
    Integer minutes = 0;

    Log createLog(Date date, Integer minutes);
    Log readLog();
    Log updateLog(Date date, Integer minutes);
    void deleteLog();
}

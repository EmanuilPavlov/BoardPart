import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventLog {
    private String description;
    private static LocalDateTime localDateTime;
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");

    public String getDescription() {
        return description;
    }

    public static String setDescription(String description) {
        return description = description;
    }

    public static LocalDateTime getLocalDateTime() {
        return localDateTime = LocalDateTime.now();
    }

    public EventLog(String description){
        this.description = description;
    }

    public String viewInfo(){
        String string = String.format("[%s] %s",getLocalDateTime().format(formatter),getDescription());
        if (!string.isEmpty()){
            return string;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}

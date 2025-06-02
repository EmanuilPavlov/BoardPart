import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class BoardItem {
    private String title;
    private final LocalDate localDate;
    protected Status status;
    protected static final ArrayList<EventLog> LIST = new ArrayList<>();
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.length()>5 && title.length()<=30){
            this.title = title;
            EventLog log = new EventLog(String.format("[%s] %s from %s",EventLog.getLocalDateTime().format(EventLog.formatter),EventLog.setDescription("Title changed"),getLocalDate()));
            LIST.add(log);
        }
        else {
            throw new IllegalArgumentException("Title must be between 5 and 30 symbols.");
        }
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
    public void setLocalDate(LocalDate localDate){
        EventLog log = new EventLog(String.format(String.format("[%s] %s from %s to %s",EventLog.getLocalDateTime().format(EventLog.formatter),EventLog.setDescription("DueDate changed"),this.localDate,localDate)));
        LIST.add(log);
    }

    public Status getStatus() {
        return this.status;
    }

    private void setStatus(Status status){
        this.status = status;
    }

    public BoardItem(String title, LocalDate localDate){
        this(title,localDate,Status.OPEN);
    }
    public  BoardItem(String title, LocalDate localDate,Status status){
        this.title = title;
        this.localDate = localDate;
        this.status = status;
    }

    public abstract void revertStatus();
    public abstract void advanceStatus();
    public void viewInfo(){
        EventLog log = new EventLog(String.format("[%s] %s %s, [%s | %s] %n",EventLog.getLocalDateTime().format(EventLog.formatter),EventLog.setDescription("Item created:"),title,localDate,status));
        LIST.add(log);
    }
}

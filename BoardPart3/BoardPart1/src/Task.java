import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task extends  BoardItem{
    private final ArrayList<EventLog> list = new ArrayList<>();
    private String assigment;
    public Task(String title,String assigment, LocalDate localDate){
        super(title,localDate,Status.TODO);
        this.assigment = assigment;
        LIST.add(new EventLog(String.format("[%s] Item created: '%s' , [%s | %s]", EventLog.getLocalDateTime().format(EventLog.formatter),getTitle(),getStatus(),getLocalDate())));
    }
    public String getAssigment(){
        return this.assigment;
    }
    public void setAssigment(String assigment){
        if (assigment.length()>=5 && assigment.length()<=30){
            LIST.add(new EventLog(String.format("[%s] Assignee changed from %s , %s", EventLog.getLocalDateTime().format(EventLog.formatter),getAssigment(),assigment)));
            this.assigment = assigment;
        }
        else {
            throw new IllegalArgumentException("Invalid value!");
        }
    }

    @Override
    public void revertStatus() {
        Status status = this.getStatus();
        switch (getStatus()){
            case TODO -> {
                EventLog log = new EventLog(String.format("[%s] Can't advance, already at %s",EventLog.getLocalDateTime().format(EventLog.formatter),this.status));
                LIST.add(log);
                break;
            }
            case IN_PROGRESS -> {
                this.status = Status.DONE;
                EventLog log = new EventLog(String.format("[%s] %s from %s to %s",EventLog.getLocalDateTime().format(EventLog.formatter),
                        EventLog.setDescription("Task status changed"),Status.IN_PROGRESS,this.status));
                LIST.add(log);
                break;
            }
            case DONE -> {
                this.status = Status.IN_PROGRESS;
                EventLog log = new EventLog(String.format("[%s] %s from %s to %s",EventLog.getLocalDateTime().format(EventLog.formatter),
                        EventLog.setDescription("Task status changed"),Status.DONE,this.status));
                LIST.add(log);
                break;
            }
            case VERIFIED -> {
                this.status = Status.DONE;
                EventLog log = new EventLog(String.format("[%s] %s from %s to %s",EventLog.getLocalDateTime().format(EventLog.formatter),
                        EventLog.setDescription("Task status changed"),Status.VERIFIED,this.status));
                LIST.add(log);
                break;
            }
        }
    }

    @Override
    public void advanceStatus() {
        Status status = this.getStatus();
        switch (status) {
            case TODO -> {
                this.status = Status.IN_PROGRESS;
                EventLog log = new EventLog(String.format("[%s] %s from %s to %s",EventLog.getLocalDateTime().format(EventLog.formatter),
                        EventLog.setDescription("Task status changed"),Status.TODO,this.status));
                LIST.add(log);
                break;
            }
            case IN_PROGRESS -> {
                this.status = Status.DONE;
                EventLog log = new EventLog(String.format("[%s] %s from %s to %s",EventLog.getLocalDateTime().format(EventLog.formatter),
                        EventLog.setDescription("Task status changed"),Status.IN_PROGRESS,this.status));
                LIST.add(log);
                break;
            }
            case DONE -> {
                this.status = Status.VERIFIED;
                EventLog log = new EventLog(String.format("[%s] %s from %s to %s",EventLog.getLocalDateTime().format(EventLog.formatter),
                        EventLog.setDescription("Task status changed"),Status.DONE,this.status));
                LIST.add(log);
                break;
            }
            case VERIFIED -> {
                EventLog log = new EventLog(String.format("[%s] Issue status, already at %s",EventLog.getLocalDateTime().format(EventLog.formatter),this.status));
                LIST.add(log);
                break;
            }
        }
    }
}

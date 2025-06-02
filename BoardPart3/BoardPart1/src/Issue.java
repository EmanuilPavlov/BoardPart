import java.time.LocalDate;

public class Issue extends BoardItem{
    private String description;
    public Issue(String title, String description, LocalDate localDate){
        super(title,localDate,Status.OPEN);
        this.description = description;
        LIST.add(new EventLog(String.format("[%s] Item created: '%s' , [%s | %s]", EventLog.getLocalDateTime().format(EventLog.formatter),getTitle(),getStatus(),getLocalDate())));
    }

    @Override
    public void revertStatus() {
        Status status = this.getStatus();
        switch (getStatus()){
            case VERIFIED -> {
                this.status = Status.OPEN;
                EventLog log = new EventLog(String.format("[%s] %s from %s to %s",EventLog.getLocalDateTime().format(EventLog.formatter),
                        EventLog.setDescription("Issue Status set"),Status.VERIFIED,this.status));
                LIST.add(log);
                break;
            }
            case OPEN -> {
                EventLog log = new EventLog(String.format("[%s] Issue status, already at %s",EventLog.getLocalDateTime().format(EventLog.formatter),this.status));
                LIST.add(log);
                break;
            }
        }
    }

    @Override
    public void advanceStatus() {
        Status status = this.getStatus();
        switch (status) {
            case VERIFIED -> {
                EventLog log = new EventLog(String.format("[%s] Issue status, already at %s",EventLog.getLocalDateTime().format(EventLog.formatter),this.status));
                LIST.add(log);
                break;
            }
            case OPEN -> {
                this.status = Status.VERIFIED;
                EventLog log = new EventLog(String.format("[%s] %s from %s to %s",EventLog.getLocalDateTime().format(EventLog.formatter),
                        EventLog.setDescription("Issue Status set"),Status.OPEN,this.status));
                LIST.add(log);
                break;
            }
        }
    }
}

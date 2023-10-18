import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

final class EventLog {
    private final String description;
    private final LocalDateTime timestamp;

    public EventLog(String description){
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }
    public EventLog(){
        throw new IllegalArgumentException("Description cannot be empty");
    }

    public String getDescription() {
        return description;
    }

    public String viewInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");
        String date = timestamp.format(formatter);
        return "[" + date + "] " + description;
    }

}

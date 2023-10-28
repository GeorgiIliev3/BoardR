import enums.Status;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class BoardItem {
    public static final int MIN_TITLE_LENGTH = 5;
    public static final int MAX_TITLE_LENGTH = 30;
    private String title;
    private LocalDate dueDate;
    protected Status status;
    protected ArrayList<EventLog>history;

    public BoardItem (String title, LocalDate date){
        this.title = title;
        this.dueDate = date;
        this.status = getInitialStatus();
        this.history = new ArrayList<>();
        history.add(new EventLog("Item created: " + viewInfo()));
    }
    public  BoardItem(String title, LocalDate date, Status status){
        this(title,date);
        this.status = status;
        this.history = new ArrayList<>();
        history.add(new EventLog("Item created: " + viewInfo()));
    }
    protected Status getInitialStatus(){
     return  Status.OPEN;
    }
    public Status getStatus() {
        return status;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        if (title.length() < MIN_TITLE_LENGTH || title.length() > MAX_TITLE_LENGTH) {
            throw new IllegalArgumentException(String.format("Please provide a title with length between %s and %s chars",MIN_TITLE_LENGTH,MAX_TITLE_LENGTH));
        }
        history.add(new EventLog(String.format("Title changed from %s to %s",this.title,title)));
        this.title = title;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        if (dueDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Please provide a value that it is not in the past");
        }
        history.add(new EventLog(String.format("DueDate changed from %s to %s",this.dueDate,dueDate)));
        this.dueDate = dueDate;
    }

    public String getHistory() {
        StringBuilder builder = new StringBuilder();

        for (EventLog event : history) {
            builder.append(event.viewInfo()).append(System.lineSeparator());
        }

        return builder.toString();
    }
    public void displayHistory(){
        System.out.println(getHistory());
    }
    public String viewInfo(){
        String status = this.status.toString(getStatus());
        return String.format("'%s', [%s | %s]",title,status,getDueDate());
    }
    public abstract void revertStatus();
    public abstract void advanceStatus();

}


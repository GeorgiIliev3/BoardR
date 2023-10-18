import java.time.LocalDate;
import java.util.ArrayList;

public class BoardItem {
    private String title;
    private LocalDate dueDate;
    private Status status;
    private ArrayList<EventLog>history;

    public BoardItem (String title, LocalDate date){
        this.title = title;
        this.dueDate = date;
        this.status = Status.OPEN;
        this.history = new ArrayList<>();
        EventLog eventLog = new EventLog("Item created: " + viewInfo());
        history.add(eventLog);
    }
    public  BoardItem(String title, LocalDate date, Status status){
        this(title,date);
        this.status = status;
        this.history = new ArrayList<>();
        EventLog eventLog = new EventLog("Item created: " + viewInfo());
        history.add(eventLog);
    }

    public Status getStatus() {
        return status;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        if (title.length() < 5 || title.length() > 30) {
            throw new IllegalArgumentException("Please provide a title with length between 5 and 30 chars");
        }
        history.add(new EventLog("Title changed from " + this.title + " to " + title));
        this.title = title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        if (dueDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Please provide a value that it is not in the past");
        }
        history.add(new EventLog("DueDate changed from " + this.dueDate + " to " + dueDate));
        this.dueDate = dueDate;
    }

    public void displayHistory(){
        for (EventLog element:history) {
            System.out.println(element.viewInfo());
        }
    }

    public String viewInfo(){
        String status = "";
        String date = String.valueOf(this.dueDate);
        switch (String.valueOf(this.status)){
            case "OPEN":
                status = "Open";
                break;
            case "TO_DO":
                status = "To Do";
                break;
            case "IN_PROGRESS":
                status = "In progress";
                break;
            case "DONE":
                status = "Done";
                break;
            case "VERIFIED":
                status = "Verified";
                break;
        }
        return "'" +title + "', ["+ status + " | "+ date+"]";
    }
    public void revertStatus(){
        if (status.equals(Status.OPEN)){
            history.add(new EventLog("Can't revert, already at Open"));
            return;
        }
        if (status.equals(Status.TO_DO)){
            status = Status.OPEN;
            history.add(new EventLog("Status changed from To Do to Open"));
        } else if(status.equals(Status.IN_PROGRESS)) {
            status = Status.TO_DO;
            history.add(new EventLog("Status changed from In progress to To Do"));
        } else if (status.equals(Status.DONE)) {
            status = Status.IN_PROGRESS;
            history.add(new EventLog("Status changed from Done to In progress"));
        } else if (status.equals(Status.VERIFIED)) {
            status = Status.DONE;
            history.add(new EventLog("Status changed from Verified to Done"));
        }
    }
    public void advanceStatus(){
        if (status.equals(Status.VERIFIED)){
            history.add(new EventLog("Can't advance, already at Verified"));
            return;
        }
        if (status.equals(Status.OPEN)){
            status = Status.TO_DO;
            history.add(new EventLog("Status changed from Open to To Do"));
        } else if(status.equals(Status.TO_DO)) {
            status = Status.IN_PROGRESS;
            history.add(new EventLog("Status changed from To Do to In progress"));
        } else if (status.equals(Status.IN_PROGRESS)) {
            status = Status.DONE;
            history.add(new EventLog("Status changed from In progress to Done"));
        } else if (status.equals(Status.DONE)) {
            status = Status.VERIFIED;
            history.add(new EventLog("Status changed from Done to Verified"));
        }
    }

}


import java.time.LocalDate;

public class Task extends BoardItem{
   private String assignee;
    public Task(String title,String assignee, LocalDate date) {
        super(title, date);
        this.assignee = assignee;
    }


    public String getAssignee() {
        return assignee;
    }
    public void setAssignee(String assignee){
        if (assignee.length() < 5 || assignee.length() > 30){
            throw new IllegalArgumentException("Assignee length should be between 5 and 30 characters!");
        }
        history.add(new EventLog(String.format("Assignee changed from %s to %s",getAssignee(),assignee)));
        this.assignee = assignee;
    }

    @Override
    protected Status getInitialStatus() {
        return Status.TO_DO;
    }
}

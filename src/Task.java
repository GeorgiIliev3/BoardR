import enums.Status;

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
//    @Override
//    public String viewInfo() {
//        return String.format("Task: %s, Assignee: %s", super.viewInfo(), getAssignee());
//    }
    @Override
    public void revertStatus() {
        if (super.status.equals(Status.TO_DO)){
            history.add(new EventLog("Can't revert, already at To Do"));
            return;
        }
       if(super.status.equals(Status.IN_PROGRESS)) {
           super.status = Status.TO_DO;
            history.add(new EventLog("Task status changed from In progress to To Do"));
        } else if (super.status.equals(Status.DONE)) {
           super.status = Status.IN_PROGRESS;
            history.add(new EventLog("Task status changed from Done to In progress"));
        } else if (super.status.equals(Status.VERIFIED)) {
           super.status = Status.DONE;
            history.add(new EventLog("Task status changed from Verified to Done"));
        }
    }

    @Override
    public void advanceStatus() {
        if (super.status.equals(Status.VERIFIED)){
            history.add(new EventLog("Can't advance, already at Verified"));
            return;
        }
        if(super.status.equals(Status.TO_DO)) {
            super.status = Status.IN_PROGRESS;
            history.add(new EventLog("Task status changed from To Do to In progress"));
        } else if (super.status.equals(Status.IN_PROGRESS)) {
            super.status = Status.DONE;
            history.add(new EventLog("Task status changed from In progress to Done"));
        } else if (super.status.equals(Status.DONE)) {
            super.status = Status.VERIFIED;
            history.add(new EventLog("Task status changed from Done to Verified"));
        }
    }
}

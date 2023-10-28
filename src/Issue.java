import enums.Status;

import java.time.LocalDate;

public class Issue extends  BoardItem {
    private final String description;
    public Issue(String title, String description, LocalDate date) {
        super(title, date);
        if (description.equals("")) {
            this.description = "No description";
        } else {
            this.description = description;
        }
    }

    public String getDescription() {
        return description;
    }

//    @Override
//    public String viewInfo() {
//        return String.format("Issue: %s, Description: %s", super.viewInfo(), getDescription());
//    }

    @Override
    public void revertStatus() {
        if (super.status.equals(Status.OPEN)) {
            history.add(new EventLog("Issue status already Open"));
            return;
        }
        super.status = Status.OPEN;
        history.add(new EventLog("Issue status set to Open"));
    }

    @Override
    public void advanceStatus() {
        if (super.status.equals(Status.VERIFIED)) {
            history.add(new EventLog("Issue status already Verified"));
            return;
        }
        super.status = Status.VERIFIED;
        history.add(new EventLog("Issue status set to Verified"));
    }
}
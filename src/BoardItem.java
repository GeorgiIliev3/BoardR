import java.time.LocalDate;

public class BoardItem {
    String title;
    LocalDate dueDate;
    Status status;

    public BoardItem (String title, LocalDate date){
        this.title = title;
        this.dueDate = date;
        this.status = Status.Open;
    }
    public  BoardItem(String title, LocalDate date, Status status){
        this(title,date);
        this.status = status;
    }

    public void revertStatus(){
        if (status.equals(Status.ToDo)){
            status = Status.Open;
        } else if(status.equals(Status.InProgress)) {
            status = Status.ToDo;
        } else if (status.equals(Status.Done)) {
            status = Status.InProgress;
        } else if (status.equals(Status.Verified)) {
            status = Status.Done;
        }
    }
    public void advanceStatus(){
        if (status.equals(Status.Open)){
            status = Status.ToDo;
        } else if(status.equals(Status.ToDo)) {
            status = Status.InProgress;
        } else if (status.equals(Status.InProgress)) {
            status = Status.Done;
        } else if (status.equals(Status.Done)) {
            status = Status.Verified;
        }
    }
    public String viewInfo(){
       String status = String.valueOf(this.status);
       String date = String.valueOf(this.dueDate);
       StringBuilder inf = new StringBuilder();
       String info = "'" +title + "', ["+ status + " | "+ date+"]";
       return info;
    }
}


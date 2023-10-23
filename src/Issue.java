import java.time.LocalDate;

public class Issue extends  BoardItem{
   private final String description;

    public Issue(String title,String description, LocalDate date) {
        super(title, date);
        if (description.equals("")){
            this.description = "No description";
        }else {
            this.description = description;
        }
    }

    public String getDescription() {
        return description;
    }
}

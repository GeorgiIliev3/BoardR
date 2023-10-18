import java.util.ArrayList;
import java.util.List;

class Board {
    private List<BoardItem> items;

    public Board(){

        this.items = new ArrayList<>();
    }
    public void addItem(BoardItem item){
        if (items.contains(item)){
            throw new IllegalArgumentException("Item already in the list");
        }
        items.add(item);
    }
    public int totalItems(){
        return items.size();
    }
}

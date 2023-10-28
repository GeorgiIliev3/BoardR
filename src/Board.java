import loggers.Logger;

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
    public void displayHistory(Logger logger) {
        for (BoardItem item : items) {
            logger.log(item.getHistory());
        }
    }
    public void displayHistory(){
        for (BoardItem item: items){
            item.displayHistory();
        }
    }
}

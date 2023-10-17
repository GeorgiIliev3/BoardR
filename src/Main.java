import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
        item.advanceStatus();
        BoardItem anotherItem = new BoardItem("Encrypt user data", LocalDate.now().plusDays(10));

        Board board = new Board();

        board.items.add(item);
        board.items.add(anotherItem);

        for (BoardItem boardItem : board.items) {
            boardItem.advanceStatus();
        }

        for (BoardItem boardItem : board.items) {
            System.out.println(boardItem.viewInfo());
        }
    }
}

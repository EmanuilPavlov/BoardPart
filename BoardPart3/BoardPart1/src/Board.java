import java.util.ArrayList;

public class Board {
    private ArrayList<BoardItem> list = new ArrayList<BoardItem>();
    public  int totalItems(){
        return list.size();
    }
    public void addItem(BoardItem item){
        if (list.isEmpty() || !list.contains(item)){
            list.add(item);
        }
        else {
            throw new IllegalArgumentException("Error!");
        }
    }
    public void displayHistory(){
        for (EventLog log : BoardItem.LIST){
            System.out.println(log.getDescription());
        }
    }
}

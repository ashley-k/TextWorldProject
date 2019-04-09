import java.util.HashMap;

public class TakeCommand implements Command {
    private Graph g;
    private String itemName;

    public TakeCommand(Graph g){
        this.g = g;
    }

    @Override
    public void init(String userString) {
        itemName = getLastWordIn(userString);
    }

    @Override
    public void execute() {
        Player player = g.getPlayer();
        Graph.Node currentRoom = player.getCurrentRoom();

        HashMap<String,Item> validItems = currentRoom.getItems();
        if(validItems.get(itemName) == null) System.out.println("The room does not have this item.");
        else{
            Item item = currentRoom.removeItem(itemName);
            player.addItem(item);
            System.out.println("Item successfully picked up.");
        }
    }

    private String getLastWordIn(String userString) {
        int spaceIndex = userString.indexOf(" ");
        return userString.substring(spaceIndex+1);
    }
}

import java.util.HashMap;

public class DropCommand implements Command {
    private Graph g;
    private String itemName;

    public DropCommand(Graph g){
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

        HashMap<String,Item> validItems = player.getItems();
        if(validItems.get(itemName) == null) System.out.println("You do not have this item.");
        else{
            Item item = player.removeItem(itemName);
            currentRoom.addItem(item);
            System.out.println("Item successfully dropped.");
        }
    }

    private String getLastWordIn(String userString) {
        int spaceIndex = userString.indexOf(" ");
        return userString.substring(spaceIndex+1);
    }
}

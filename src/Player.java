import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private String name, description;
    private HashMap<String, Item> items;
    Graph.Node currentRoom;

    public Player(String name, String description) {
        this.name = name;
        this.description = description;
        items = new HashMap<>();
    }

    public void addItem(Item item){
        items.put(item.getName(), item);
    }

    public Item removeItem(String name){
        return items.remove(name);
    }

    public boolean destroyItem(String name){
        if(items.get(name) == null) return false;
        items.remove(name);
        return true;
    }

    public HashMap<String, Item> getItems(){
        return items;
    }

    public void displayInventory(){
        String inventory = "";
        for(String key : items.keySet()){
            inventory = inventory + key + " ";
        }
        System.out.println(inventory);
    }

    public Graph.Node getCurrentRoom(){
        return currentRoom;
    }

    public void setCurrentRoom(Graph.Node newroom){
        currentRoom = newroom;
    }
}

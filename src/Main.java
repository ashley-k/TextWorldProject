import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode("hall", "a long dank hallway");
        g.addNode("closet", "a dark, dark closet");
        g.addNode("dungeon", "a cold, empty dungeon");

        g.addDirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall", "closet");

        g.getNode("hall").addItem("backpack");
        g.getNode("hall").addItem("gun");
        g.getNode("dungeon").addItem("flashlight");
        g.getNode("closet").addItem("shirt");

        Player player = new Player("User", "Person using this computer.");
        player.setCurrentRoom(g.getNode("hall"));

        String response = "";
        Scanner s = new Scanner(System.in);

        displayCommands();
        do{
            Graph.Node currentRoom = player.getCurrentRoom();
            System.out.println("You are in the " + currentRoom.getName());
            System.out.println("What do you want to do");
            response = s.nextLine();
            int length = response.length();

            if(length >= 3 && response.substring(0,3).equals("go ")){
                String roomName = response.substring(3);
                if(g.getNode(roomName) != null && currentRoom.isNeighbor(roomName))
                    player.setCurrentRoom(g.getNode(roomName));
                else System.out.println("Invalid room name.");
            }
            else if(response.equals("look")){
                System.out.println("Room description: " + currentRoom.getDescription());
                System.out.println("Exits: " + currentRoom.getNeighborNames());
                System.out.println("Items: " + currentRoom.displayItems());
            }
            else if(length >= 8 && response.substring(0,8).equals("add room")) {
                String roomName = response.substring(9);
                g.addNode(roomName);
                g.addDirectedEdge(currentRoom.getName(), roomName);
            }
            else if( response.equals("quit") ){
                break;
            }
            else if(length >= 4 && response.substring(0,4).equals("take")){
                String itemName = response.substring(5);
                HashMap<String,Item> validItems = currentRoom.getItems();
                if(validItems.get(itemName) == null) System.out.println("The room does not have this item.");
                else{
                    Item item = currentRoom.removeItem(itemName);
                    player.addItem(item);
                    System.out.println("Item successfully picked up.");
                }
            }
            else if(length >= 4 && response.substring(0,4).equals("drop")){
                String itemName = response.substring(5);
                HashMap<String,Item> validItems = player.getItems();
                if(validItems.get(itemName) == null) System.out.println("You do not have this item.");
                else{
                    Item item = player.removeItem(itemName);
                    currentRoom.addItem(item);
                    System.out.println("Item successfully dropped.");
                }
            }
            else if(response.equals("display inventory")){
                player.displayInventory();
            }
            else {
                displayCommands();
            }
        } while(!response.equals("quit"));
    }

    private static void displayCommands() {
        System.out.println("You can:\n" +
                "1. Type 'go <roomname>' to go to a room.\n" +
                "2. Type 'look' to display all neighbors.\n" +
                "3. Type 'add room <roomname>' to add a new neighbor to the current room.\n" +
                "4. Type 'quit' to quit the game.");
    }
}

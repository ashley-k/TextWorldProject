import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static HashMap<String, Command> commands;
    private static Graph g;

    public static void main(String[] args) {
        Player player = new Player("User", "Person using this computer.");
        g = new Graph(player);
        g.initialize();
        initCommands();

        player.setCurrentRoom(g.getNode("hall"));

        String response = "";
        Scanner in = new Scanner(System.in);

        displayCommands();
        do{
            promptAction(player);
            response = in.nextLine();

            Command command = lookupCommand(response);
            if(command != null)
                command.execute();
            else{
                if(response.equals("quit")) break;
                System.out.println("Invalid action.");
                displayCommands();
            }

            moveAllCreature(player.getCurrentRoom(), g.getCreatures());
        } while(!response.equals("quit"));
    }

    private static void promptAction(Player player) {
        System.out.println("***");
        Graph.Node currentRoom = player.getCurrentRoom();
        System.out.println("You are in the " + currentRoom.getName() + "." );
        System.out.println("What do you want to do?");
    }

    private static void initCommands(){
        commands = new HashMap<>();
        commands.put("add-room", new AddRoomCommand(g));
        commands.put("display", new DisplayCommand(g));
        commands.put("drop", new DropCommand(g));
        commands.put("go", new GoCommand(g));
        commands.put("look", new LookCommand(g));
        commands.put("take", new TakeCommand(g));
    }

    private static Command lookupCommand(String response) {
        String commandWord = getFirstWordIn(response);
        Command c = commands.get(commandWord);
        if(c == null) return null;

        c.init(response);
        return c;
    }

    private static String getFirstWordIn(String response) {
        String[] words = response.split(" ");
        return words[0];
    }

    private static void moveAllCreature(Graph.Node currentRoom, ArrayList<Creature> creatures) {
        for(Creature c : creatures){
            c.move(currentRoom);
        }
    }

    private static void displayCommands() {
        System.out.println("You can:\n" +
                "1. Type 'go <roomname>' to go to a room.\n" +
                "2. Type 'look' to display all neighbors.\n" +
                "3. Type 'add-room <roomname>' to add a new neighbor to the current room.\n" +
                "4. Type 'take <itemname>' to pick up an item in the current room. \n" +
                "5. Type 'drop <itemname>' to drop an item in the current room. \n" +
                "6. Type 'display' to display your inventory.\n" +
                "7. Type 'quit' to quit the game.");
    }
}

public class LookCommand implements Command {
    private Graph g;

    public LookCommand(Graph g){
        this.g = g;
    }

    @Override
    public void init(String userString) {
        //do nothing
    }

    @Override
    public void execute() {
        Player player = g.getPlayer();
        Graph.Node currentRoom = player.getCurrentRoom();

        System.out.println("Room description: " + currentRoom.getDescription());
        System.out.println("Exits: " + currentRoom.getNeighborNames());
        System.out.println("Items: " + currentRoom.displayItems());
        System.out.println("Creatures: " + currentRoom.getCreatureNames());

    }
}

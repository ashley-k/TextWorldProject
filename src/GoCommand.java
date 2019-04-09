public class GoCommand implements Command {
    private Graph g;
    private String roomName;

    public GoCommand(Graph graph){
        this.g = graph;
    }

    @Override
    public void init(String userString) {
        roomName = getLastWordIn(userString);
    }

    @Override
    public void execute() {
        Player player = g.getPlayer();
        Graph.Node currentRoom = player.getCurrentRoom();

        if(g.getNode(roomName) != null && currentRoom.hasNeighbor(roomName)) {
            player.setCurrentRoom(g.getNode(roomName));
        }
        else System.out.println("Invalid room name.");
    }

    private String getLastWordIn(String userString) {
        int spaceIndex = userString.indexOf(" ");
        return userString.substring(spaceIndex+1);
    }
}

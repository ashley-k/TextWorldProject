public class AddRoomCommand implements Command {
    private Graph g;
    private String roomName;

    public AddRoomCommand(Graph g){
        this.g = g;
    }

    @Override
    public void init(String userString) {
        roomName = getLastWordIn(userString);
    }

    @Override
    public void execute() {
        Player player = g.getPlayer();
        Graph.Node currentRoom = player.getCurrentRoom();

        if(g.hasExistingNode(roomName)){
            Graph.Node n = g.getNode(roomName);
            if(!n.equals(currentRoom)) g.addDirectedEdge(currentRoom, n);
        } else {
            g.addNode(roomName);
            g.addDirectedEdge(currentRoom.getName(), roomName);
        }
    }

    private String getLastWordIn(String userString) {
        int spaceIndex = userString.indexOf(" ");
        return userString.substring(spaceIndex+1);
    }
}

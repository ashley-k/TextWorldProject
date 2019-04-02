import java.util.ArrayList;
import java.util.HashMap;

public class Wumpus extends Creature {
    public Wumpus(Graph.Node currentRoom){
        super(currentRoom);
        this.name = "wumpus";
        this.description = "a wumpus";
    }

    public Wumpus(Graph.Node currentRoom, String name, String description){
        super(currentRoom, name, description);
    }

    @Override
    public void move(Graph.Node playerRoom) {
        if(playerRoom.hasNeighbor(currentRoom.getName())){
            HashMap<String, Graph.Node> neighborMap = currentRoom.getNeighborList();
            ArrayList<Graph.Node> neighbors = new ArrayList<Graph.Node>(neighborMap.values());

            //TO-DO
        }
    }
}

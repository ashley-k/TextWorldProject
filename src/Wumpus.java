import java.util.ArrayList;
import java.util.HashMap;

public class Wumpus extends Creature {
    public Wumpus(Graph.Node currentRoom){
        super(currentRoom);
    }

    public Wumpus(Graph.Node currentRoom, String description){
        super(currentRoom, description);
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

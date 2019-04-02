import java.util.ArrayList;
import java.util.HashMap;

public class Chicken extends Creature {
    public Chicken(Graph.Node currentRoom){
        super(currentRoom);
    }

    public Chicken(Graph.Node currentRoom, String description){
        super(currentRoom, description);
    }

    @Override
    public void move(Graph.Node playerRoom){
        HashMap<String, Graph.Node> neighborMap = currentRoom.getNeighborList();
        ArrayList<Graph.Node> neighbors = new ArrayList<Graph.Node>(neighborMap.values());
        int rand = (int)(Math.random()*neighbors.size());
        setCurrentRoom(neighbors.get(rand));
    }

}


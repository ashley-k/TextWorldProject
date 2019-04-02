import java.util.ArrayList;
import java.util.HashMap;

public class Chicken extends Creature {
    public Chicken(Graph.Node currentRoom){
        super(currentRoom);
        this.name = "chicken";
        this.description = "a white chicken";
    }

    public Chicken(Graph.Node currentRoom, String name, String description){
        super(currentRoom, name, description);
    }

    @Override
    public void move(Graph.Node playerRoom){
        HashMap<String, Graph.Node> neighborMap = currentRoom.getNeighborList();
        ArrayList<Graph.Node> neighbors = new ArrayList<Graph.Node>(neighborMap.values());

        int rand = (int)(Math.random()*neighbors.size());
        Graph.Node newRoom = neighbors.get(rand);

        updateRooms(currentRoom, newRoom);
        setCurrentRoom(neighbors.get(rand));
    }

}


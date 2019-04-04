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
        Graph.Node newRoom = currentRoom.getRandomNeighbor();
        if(newRoom != null) {
            moveToRoom(playerRoom, currentRoom, newRoom);
            //System.out.println(name + " moved to " + newRoom.getName());
        }
    }

}


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
        if(playerRoom.hasNeighbor(currentRoom.getName()) && currentRoom.getNumNeighbors() >= 1){
            if((currentRoom.getNumNeighbors()== 1 && currentRoom.getNeighbor(playerRoom.getName()) == null) || currentRoom.getNumNeighbors() > 1){ //if current has at least 2 neighbors or it has 1 neighbor which is not the playerRoom
                Graph.Node nextRoom = currentRoom.getRandomNeighbor();
                while(nextRoom.equals(playerRoom)){
                    nextRoom = currentRoom.getRandomNeighbor();
                }
                System.out.println(name + " moved from " + currentRoom.getName() + " to " + nextRoom.getName());
                moveToRoom(playerRoom, currentRoom, nextRoom);
            }
        }
    }

}

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
        if(playerRoom.isWithinTwoStepsOf(currentRoom.getName())) {
            if (playerRoom.equals(currentRoom)) { //if in same room
                if((currentRoom.getNumNeighbors()== 1 && currentRoom.getNeighbor(playerRoom.getName()) == null) || currentRoom.getNumNeighbors() > 1){
                    Graph.Node nextRoom = currentRoom.getRandomNeighbor();
                    while(nextRoom.equals(playerRoom)){
                        nextRoom = currentRoom.getRandomNeighbor();
                    }
                    moveToRoom(playerRoom, currentRoom, nextRoom);
                }
            } else if(canMoveAwayFrom(playerRoom)) { //if one or two rooms away & can go to one that is >= 2 rooms away
                Graph.Node nextRoom = currentRoom.getRandomNeighbor();
                while (!isValidRoom(nextRoom, playerRoom)) {
                    nextRoom = currentRoom.getRandomNeighbor();
                }
                moveToRoom(playerRoom, currentRoom, nextRoom);
            }
        }
    }

    private boolean canMoveAwayFrom(Graph.Node playerRoom){
        HashMap<String, Graph.Node> neighbors = currentRoom.getNeighborList();
        for(String roomName : neighbors.keySet()){
            if(!playerRoom.hasNeighbor(roomName) && !playerRoom.equals(neighbors.get(roomName))) return true;
        }
        return false;
    }

    private boolean isValidRoom(Graph.Node nextRoom, Graph.Node playerRoom) {
        return !(nextRoom.equals(playerRoom) || playerRoom.hasNeighbor(nextRoom.getName()));
    }

}

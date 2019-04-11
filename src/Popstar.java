import java.util.HashMap;

public class Popstar extends Creature {
    public Popstar(Graph.Node currentRoom){
        super(currentRoom);
        this.name = "popstar";
        this.description = "a popstar";
    }

    public Popstar(Graph.Node currentRoom, String name, String description){
        super(currentRoom, name, description);
    }

    @Override
    public void move(Graph.Node playerRoom){
        if(currentRoom.isWithinTwoStepsOf(playerRoom.getName())){
            if(currentRoom.equals(playerRoom)){} //do nothing
            else if(currentRoom.hasNeighbor(playerRoom.getName())){ //if one step away
                moveToRoom(playerRoom, currentRoom, playerRoom);
            } else{ //if two steps away
                if(canMoveCloserTo(playerRoom)){
                    Graph.Node nextRoom = currentRoom.getRandomNeighbor();
                    while(!nextRoom.hasNeighbor(playerRoom.getName())){
                        nextRoom = currentRoom.getRandomNeighbor();
                    }
                    moveToRoom(playerRoom, currentRoom, nextRoom);
                }
            }
        }
    }

    private boolean canMoveCloserTo(Graph.Node playerRoom) {
        HashMap<String, Graph.Node> neighbors = currentRoom.getNeighborList();
        for(String roomName : neighbors.keySet()){
            Graph.Node room = neighbors.get(roomName);
            if(room.hasNeighbor(playerRoom.getName())) return true;
        }
        return false;
    }

}


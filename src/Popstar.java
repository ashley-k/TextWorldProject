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
        if(currentRoom.hasNeighbor(playerRoom.getName())){
            moveToRoom(playerRoom, currentRoom, playerRoom);
        }
    }

}


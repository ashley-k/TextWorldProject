public abstract class Creature {
    protected Graph.Node currentRoom;
    protected String description;

    public Creature(Graph.Node currentRoom){
        this.currentRoom = currentRoom;
    }

    public Creature(Graph.Node currentRoom, String description){
        this.currentRoom = currentRoom;
        this.description = description;
    }

    public abstract void move(Graph.Node playerRoom);

    public Graph.Node getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Graph.Node currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

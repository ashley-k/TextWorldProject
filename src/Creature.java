public abstract class Creature {
    protected Graph.Node currentRoom;
    protected String description;
    protected String name;

    public Creature(Graph.Node currentRoom){
        this.currentRoom = currentRoom;
    }

    public Creature(Graph.Node currentRoom, String name, String description){
        this.currentRoom = currentRoom;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

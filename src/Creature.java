public abstract class Creature {
    protected Graph.Node currentRoom;
    protected String description;
    protected String name;

    public Creature(Graph.Node currentRoom){
        this.currentRoom = currentRoom;
        currentRoom.addCreature(this);
    }

    public Creature(Graph.Node currentRoom, String name, String description){
        this.currentRoom = currentRoom;
        this.name = name;
        this.description = description;
        currentRoom.addCreature(this);
    }

    public abstract void move(Graph.Node playerRoom);

    public void updateRooms(Graph.Node prevRoom, Graph.Node newRoom){
        prevRoom.removeCreature(this);
        newRoom.addCreature(this);
    }

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

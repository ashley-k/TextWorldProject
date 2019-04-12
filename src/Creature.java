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

    public void moveToRoom(Graph.Node playerRoom, Graph.Node currentRoom, Graph.Node nextRoom){
        displayEntranceOrExit(playerRoom, currentRoom, nextRoom);

        currentRoom.removeCreature(this);
        setCurrentRoom(nextRoom);
        nextRoom.addCreature(this);
    }

    private void displayEntranceOrExit(Graph.Node playerRoom, Graph.Node currentRoom, Graph.Node nextRoom){
        if(currentRoom.equals(playerRoom))
            System.out.println(name + " moved out of your room into " + nextRoom.getName());
        if(nextRoom.equals(playerRoom))
            System.out.println(name + " moved from the " + currentRoom.getName() + " to your room");
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

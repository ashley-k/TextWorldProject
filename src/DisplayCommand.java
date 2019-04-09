public class DisplayCommand implements Command {
    private Graph g;

    public DisplayCommand(Graph graph){
        this.g = graph;
    }

    @Override
    public void init(String userString) {
        //do nothing
    }

    @Override
    public void execute() {
        Player player = g.getPlayer();
        player.displayInventory();
    }

}

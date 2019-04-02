import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    private HashMap<String, Node> nodes;

    public Graph(){
        nodes = new HashMap<String, Node>();
    }

    public void addNode(String name) {
        Node n = new Node(name, "a " + name);
        nodes.put(name, n);
    }

    public void addNode(String name, String description){
        Node n = new Node(name, description);
        nodes.put(name, n);
    }

    public void addDirectedEdge(String name1, String name2) {
        Node n1 = getNode(name1);
        Node n2 = getNode(name2);
        n1.addNeighbor(n2);
    }

    public void addUndirectedEdge(String name1, String name2) {
        Node n1 = getNode(name1);
        Node n2 = getNode(name2);
        n1.addNeighbor(n2);
        n2.addNeighbor(n1);
    }

    public Node getNode(String name) {
        for(String key : nodes.keySet()){
            if(key.equals(name)) return nodes.get(key);
        }
        return null;
    }

    public class Node{
        private HashMap<String,Node> neighbors;
        private String name;
        private String description;
        private HashMap<String, Item> items;
        private ArrayList<Creature> creatures;

        private Node(String name, String description) {
            neighbors = new HashMap<String, Node>();
            items = new HashMap<String, Item>();
            creatures = new ArrayList<Creature>();
            this.name = name;
            this.description = description;
        }

        private void addNeighbor(Node n){
            neighbors.put(n.getName(), n);
        }

        public HashMap<String, Node> getNeighborList(){
            return neighbors;
        }

        public String getNeighborNames(){
            String neighborName = "";
            for(String name : neighbors.keySet()){
                neighborName = neighborName + name + " ";
            }
            return neighborName;
        }

        public Node getNeighbor(String name){
            return neighbors.get(name);
        }

        public String getName(){
            return name;
        }

        public boolean hasNeighbor(String name) {
            if(neighbors.get(name) == null) return false;
            return true;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public HashMap<String, Item> getItems(){
            return items;
        }

        public String displayItems(){
            String inventory = "";
            for(String key : items.keySet()){
                inventory = inventory + key + " ";
            }
            return inventory;
        }

        public void addItem(String name){
            Item item = new Item(name);
            items.put(name, item);
        }

        public void addItem(String name, String desc){
            Item item = new Item(name, desc);
            items.put(name, item);
        }

        public void addItem(Item item){
            items.put(item.getName(), item);
        }

        public Item removeItem(String name){
            return items.remove(name);
        }

        public boolean destroyItem(String name){
            if(items.get(name) == null) return false;
            items.remove(name);
            return true;
        }

        public void addCreature(Creature creature){
            creatures.add(creature);
        }

        public void removeCreature(Creature creature){
            for(int i = 0; i < creatures.size(); i++){
                Creature c = creatures.get(i);
                if(c.equals(creature))
                    creatures.remove(i);
            }
        }

        public Creature removeCreature(String name){
            for(int i = 0; i < creatures.size(); i++){
                Creature c = creatures.get(i);
                if(c.getName().equals(name))
                    return creatures.remove(i);
            }
            return null;
        }

        public String getCreatureNames(){
            String result = "";
            for(Creature c : creatures){
                result = result + c.getName() + " ";
            }
            return result;
        }
    }
}

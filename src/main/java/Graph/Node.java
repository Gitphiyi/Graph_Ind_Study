package Graph;

import java.util.ArrayList;

public class Node {
    private int id;
    private int value;
    private ArrayList<Node> edges;

    public Node(int id, int value) {
        this.id = id;
        this.value = value;
        this.edges = new ArrayList<Node>();
    }
    public Node(int id, int value, ArrayList<Node> edges) {
        this.id = id;
        this.value = value;
        this.edges = edges;
    }

    public int getID() { return id; }
    public int getValue() { return value; }
    public ArrayList<Node> getEdges() { return edges; }
    public void setValue(int newVal) { value = newVal; }
    public void addEdge(Node newNode) { edges.add(newNode); }
    public int numEdges() { return edges.size(); }
    public int digitSums() {
        int number = value;
        int digit = 0;
        int sum = 0;
        while(number > 0)  
        {  
            digit = number % 10;  
            sum = sum + digit;  
            number = number / 10;  
        }  
        return sum;
    }

    @Override
    public int hashCode() {
        //return Integer.hashCode(id);
        return id;
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if (!(o instanceof Node)) {
            return false;
        }
        Node other = (Node) o;
        if(this.id == other.id && this.value == other.value) {
            return true;
        }
        else {
            return false;
        }
    }
}
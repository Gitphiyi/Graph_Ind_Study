package Graph;

//import java.util.ArrayList;

public class Graph {
    private Node[] nodes;
    private boolean[][] directedGraph;

    public Graph(Node[] nodes, boolean[][] directedGraph) {
        this.nodes = nodes;
        this.directedGraph = directedGraph;
        connectNodes(); 
    }

    public Graph(Node[] nodes, int[][] pairs) {
        this.nodes = nodes;
        this.directedGraph = createConnectedMap(nodes, pairs);
        // for(int i = 0 ; i < directedGraph.length; i++) {
        //     System.out.println();
        //     for(int j = 0; j < directedGraph[0].length; j++) {
        //         System.out.print(directedGraph[i][j] + ", ");
        //     }
        // }
        // System.out.println();

        connectNodes();
    }

    /**
     * connects all the nodes given the directed graph
     */
    public void connectNodes() {
        int n = directedGraph.length;
        for(int i = 0; i < n; i++) {
            Node centralNode = nodes[i];
            for(int j = 0; j < n; j++) {
                if( directedGraph[i][j] ) {
                    centralNode.addEdge(nodes[j]);   
                }
            }
        }
    }
    /**
     *  
     * @param listNodes
     * @param pairs nx2 dimensional array that has pairs of ids for which nodes are connected
     * @return
     */
    public boolean[][] createConnectedMap(Node[] listNodes, int[][] pairs) {
        int n = listNodes.length;
        boolean[][] dgraph = new boolean[n][n];
        for(int i = 0; i < pairs.length; i++) {
            dgraph[pairs[i][0]][pairs[i][1]] = true;
            dgraph[pairs[i][1]][pairs[i][0]] = true;

        }
        return dgraph;
    }

    public boolean verifyGraph() {
        for(int i = 0; i < nodes.length; i++) {
            boolean[] connections = directedGraph[i];
            int totalConnectionVal = 0;
            Node centralNode = nodes[i];
            for(int j = 0; j < connections.length; j++) {
                if( connections[j] ) {
                    Node connectedNode = nodes[j];
                    totalConnectionVal += connectedNode.digitSums();
                }
            }
            if(totalConnectionVal != centralNode.getValue()) {
                return false;
            }
        }
        return true;
    }

    public void printNodes() {
        for(Node n : nodes) {
            System.out.println("Node " + n.getID() + " Value: " + n.getValue());
        }
    }
    public void printGraph() {
        for(int i = 0; i < nodes.length; i++) {
            System.out.println("Node: " + nodes[i].getID() + " Value: " + nodes[i].getValue());
            System.out.println("Connected: ");
            for(int j = 0; j < nodes.length; j++) {
                if( directedGraph[i][j] ) {
                    System.out.print(nodes[j].getID()+", ");
                }
            }   
            System.out.println();
        }
    }
}
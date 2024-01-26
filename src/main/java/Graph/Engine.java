package Graph;

import java.util.Random;

public class Engine {
    public void makeGraph(int n, int[] values) {
        Node[] nodes = new Node[n];
        for ( int i = 0; i < n; i++) {
            int value = values[i];
            Node node = new Node(i, value);
            nodes[i] = node;
        }//makes all the nodes
        int[][] pairs = new int[][]{{0,1}, {1,2}, {2,0}, {0,3}, {3,1}, {2,3}};
        //create pairing
        Graph graph = new Graph(nodes, pairs);
        //graph.printGraph();
        if( graph.verifyGraph() ) {
            System.out.println("Here is the value list: ");
            for(int i : values) {
                System.out.print(i + ", ");
            }
            System.out.println();
            //System.out.println("Your graph works");
            //graph.printGraph();
        }
        else {
            //System.out.println("Your graph does not work");
        }
    }
    public void checkGraphs(int n, int idx, int[] values, int limit) {
        if(idx == n) {
            makeGraph(n, values);
            // if(values[idx-1] == limit-1 && values[idx-2] == limit-1) {
            //     System.out.println("Checkpoint: ");
            //     for(int i : values) {
            //         System.out.print(i + ", ");
            //     }
            //     System.out.println();            
            // }
            return;
        }
        for(int i = 0; i < limit; i++) {
            int prev = values[idx];
            values[idx] = i;
            checkGraphs(n, idx+1, values, limit);
            values[idx] = prev;
        }
        return;
    }
    public static void main(String[] args) {
        Engine e = new Engine();
        int[] values = new int[4];
        int limit = 40;
        e.checkGraphs(values.length, 0, values, limit);
        //for 3 node graphs all possible solutions have numbers under 20
        //Claim: valid graphs sum{9*m*n_i} < 9*n_{i+1} given m can go to infinity  
    }
}

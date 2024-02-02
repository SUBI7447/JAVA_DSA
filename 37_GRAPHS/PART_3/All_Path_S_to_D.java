package PART_3;

import java.util.ArrayList;

public class All_Path_S_to_D {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));
        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
    }

    public static void Path_Source_TO_Dest(ArrayList<Edge>[] graph, int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }

        for (Edge e : graph[src]) {
            Path_Source_TO_Dest(graph, e.dest, dest, path + e.dest); // Concatenate destination vertex
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        int source = 5; // Change source vertex here
        int destination = 1; // Change destination vertex here
        Path_Source_TO_Dest(graph, source, destination, String.valueOf(source));
    }
}

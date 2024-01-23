package PART_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFS_Util {

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

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    public static void DFS(ArrayList<Edge> graph[]) {

        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {

            DFS_UTIL(graph, visited, i);
        }

    }

    public static void DFS_UTIL(ArrayList<Edge> graph[], boolean visited[], int curr) {//

        if (visited[curr] == false) {

            System.out.println(curr);
            visited[curr] = true;
        }

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!visited[e.dest]) {

                System.out.println("GOES TO " + e.dest);

                DFS_UTIL(graph, visited, e.dest);

            }

        }

    }

    public static void main(String[] args) {

        int V = 7;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        DFS(graph);

    }
}

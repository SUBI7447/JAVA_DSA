package PART_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cycle_Dection_UnderictedG {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;

        }

    }

    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {

            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));


        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[2].add(new Edge(3, 4));

        graph[2].add(new Edge(4, 2));



    }

    public static boolean IS_CYC(ArrayList<Edge> graph[]) {

        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {

            if (!visited[i]) {

                if (IS_CYC_UTIL(graph, i, stack, visited)) {
                    return true;
                }
            }

        }

        return false;

    }

    public static boolean IS_CYC_UTIL(ArrayList<Edge> graph[], int curr, boolean stack[], boolean visited[]) {

        visited[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);
            if (stack[e.dest]) {
                return true;
            }
            if (!visited[e.dest] && IS_CYC_UTIL(graph, e.dest, stack, visited)) {

                return true;
            }

        }

        stack[curr] = false;

        return false;
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        System.out.println(IS_CYC(graph));

    }
}

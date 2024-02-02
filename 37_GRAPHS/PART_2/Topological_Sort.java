package PART_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Topological_Sort {

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

        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));

    }

    public static void T_Sort(ArrayList<Edge> graph[]) {

        boolean visited[] = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < graph.length; i++) {

            if (!visited[i]) {
                T_Sort_Util(graph, i, visited, st);

            }
        }
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    public static void T_Sort_Util(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> st) {

        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {

            if (!visited[graph[curr].get(i).dest]) {

                T_Sort_Util(graph, graph[curr].get(i).dest, visited, st);
            }

        }
        st.add(curr);
    }

    public static void main(String[] args) {

        int V = 6;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        T_Sort(graph);
    }
}

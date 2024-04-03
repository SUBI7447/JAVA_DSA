package GRAPH_SUPPLEMENTAL;

import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju_Algo {

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

        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 0, 1));

        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 4, 1));

    }

    public static void Kosaraju_A(ArrayList<Edge> graph[]) {

        Stack<Integer> s = new Stack<>();

        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < vis.length; i++) {

            if (!vis[i]) {
                T_SORT(graph, s, i, vis);
            }

        }

        ArrayList<Edge> transpose[] = new ArrayList[graph.length];

        for (int i = 0; i < graph.length; i++) {

            transpose[i] = new ArrayList<>();
            vis[i] = false;
        }

        for (int i = 0; i < graph.length; i++) {

            for (int j = 0; j < graph[i].size(); j++) {

                transpose[graph[i].get(j).dest].add(new Edge(graph[i].get(j).dest, graph[i].get(j).src, 0));

            }

        }

        while (!s.isEmpty()) {
            int curr = s.pop();
            System.out.print("SCC -> ");

            if (!vis[curr]) {
                DFS(transpose, curr, vis);
            }
            System.out.println();

        }

    }

    public static void DFS(ArrayList<Edge> graph[], int curr, boolean vis[]) {

        vis[curr] = true;

        System.out.println(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {

            if (!vis[graph[curr].get(i).dest]) {
                DFS(graph, graph[curr].get(i).dest, vis);
            }
        }

    }

    public static void T_SORT(ArrayList<Edge> graph[], Stack<Integer> s, int curr, boolean vis[]) {

        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {

            if (!vis[graph[curr].get(i).dest]) {
                T_SORT(graph, s, graph[curr].get(i).dest, vis);
            }
        }
        s.push(curr);

    }

    public static void main(String[] args) {

        int v = 5;

        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);
        Kosaraju_A(graph);

    }

}

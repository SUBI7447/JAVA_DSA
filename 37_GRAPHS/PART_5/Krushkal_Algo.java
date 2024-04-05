package PART_5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Krushkal_Algo {

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;

        }

        @Override
        public int compareTo(Edge e) {
            return this.wt - e.wt;
        }

    }

    static void createGraph(ArrayList<Edge> graph) {

        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 2, 15));
        graph.add(new Edge(0, 3, 30));

        graph.add(new Edge(1, 3, 40));

        graph.add(new Edge(2, 3, 50));

    }

    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {

        for (int i = 0; i < n; i++) {
            par[i] = i;

        }

    }

    public static int find(int x) {
        if (par[x] == x) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {

        int par_a = find(a);
        int par_b = find(b);

        if (rank[a] == rank[b]) {

            par[par_b] = par_a;

            rank[par_a]++;

        } else if (rank[a] < rank[b]) {
            par[par_a] = par_b;

        } else {
            par[par_b] = par_a;

        }

    }

    public static int Krushkal_A(ArrayList<Edge> graph, int V) {

        init();

        Collections.sort(graph);

        int count = 0;

        int total = 0;

        for (int i = 0; count < V - 1; i++) {

            Edge e = graph.get(i);

            if (find(e.dest) == find(e.src)) {
                continue;

            }

            union(e.dest, e.src);

            total += e.wt;

            count++;
        }
        return total;

    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<Edge> graph = new ArrayList<>();

        createGraph(graph);

        System.out.println(Krushkal_A(graph, V));
    }

}

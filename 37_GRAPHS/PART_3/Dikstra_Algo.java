package PART_3;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dikstra_Algo {

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

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    static class pair implements Comparable<pair> {
        int n;
        int path;

        public pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(pair p2) {
            return this.path - p2.path;
        }
    }

    public static void D_Algo(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;

            }
        }

        boolean visited[] = new boolean[graph.length];
        PriorityQueue<pair> que = new PriorityQueue<>();
        que.add(new pair(src, 0));

        while (!que.isEmpty()) {

            pair curr = que.remove();

            if (!visited[curr.n]) {
                visited[curr.n] = true;

                for (int i = 0; i < graph[curr.n].size(); i++) {

                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }

                    que.add(new pair(v, dist[v]));
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i] + " ");
        }

    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        D_Algo(graph, 0);
        
    }
}

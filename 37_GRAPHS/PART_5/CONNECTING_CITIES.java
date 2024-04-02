
// Find the minimum cost for connecting all cities on the map.

import java.util.ArrayList;
import java.util.PriorityQueue;

public class CONNECTING_CITIES {

    static class Edge {
        int src;
        int des;
        int wt;

        Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }

    }

    public static void Create_graph(ArrayList<Edge> graph[], int[][] cities) {

        for (int i = 0; i < cities.length; i++) {
            graph[i] = new ArrayList<>();

            for (int j = 0; j < cities[i].length; j++) {

                if (i == j || cities[i][j] == 0) {
                    continue;
                } else {
                    graph[i].add(new Edge(i, j, cities[i][j]));
                }

            }

        }
    }

    static class Info implements Comparable<Info> {

        int v;
        int wt;

        public Info(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }

        @Override
        public int compareTo(Info a) {
            return this.wt - a.wt;
        }

    }

    public static int CONNECTING_C(ArrayList<Edge> graph[]) {

        boolean visited[] = new boolean[graph.length];

        PriorityQueue<Info> que = new PriorityQueue<>();

        que.add(new Info(0, 0));

        int total = 0;

        while (!que.isEmpty()) {

            Info curr = que.remove();

            if (!visited[curr.v]) {

                visited[curr.v] = true;

                total += curr.wt;

                for (int i = 0; i < graph[curr.v].size(); i++) {

                    que.add(new Info(graph[curr.v].get(i).des, graph[curr.v].get(i).wt));

                }

            }

        }
        return total;
    }

    public static void main(String[] args) {

        int cities[][] = {
                { 0, 10, 15, 30 },
                { 10, 0, 0, 40 },
                { 15, 0, 0, 50 },
                { 30, 40, 50, 0 } };

        ArrayList<Edge> graph[] = new ArrayList[cities.length];

        Create_graph(graph, cities);

        System.out.println(CONNECTING_C(graph));

    }

}

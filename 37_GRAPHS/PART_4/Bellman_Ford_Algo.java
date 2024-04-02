

import java.util.ArrayList;
import java.util.Arrays;

public class Bellman_Ford_Algo {

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

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    public static void B_Algo(ArrayList<Edge> graph[], int src) {

        int dis[] = new int[graph.length];

        for (int i = 0; i < dis.length; i++) {

            if (i != src) {

                dis[i] = Integer.MAX_VALUE;
            }
        }

        for (int j2 = 0; j2 < graph.length-1; j2++) {

            for (int i = 0; i < graph.length; i++) {

                for (int j = 0; j < graph[i].size(); j++) {

                    if (dis[graph[i].get(j).src] != Integer.MAX_VALUE && dis[i] + graph[i].get(j).wt < dis[graph[i].get(j).dest]) {

                        dis[graph[i].get(j).dest] = dis[i] + graph[i].get(j).wt;

                    }

                }

            }
        }

        for (int i = 0; i < dis.length; i++) {

            System.out.println(dis[i]);

        }
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        B_Algo(graph, 0);

    }

}

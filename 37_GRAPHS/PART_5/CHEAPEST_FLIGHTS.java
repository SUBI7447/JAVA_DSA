// There are n cities connected by some number of flights. You are given an array flights where
// flights[il : [from, to, pricel indicates that there is a flight.
// You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
// If there is no such route, return -I.

import java.util.*;

public class CHEAPEST_FLIGHTS {

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

    static void createGraph(ArrayList<Edge>[] graph, int flights[][]) {

        for (int i = 0; i < graph.length; i++) {

            graph[i] = new ArrayList<>();

        }
        for (int i = 0; i < flights.length; i++) {

            graph[flights[i][0]].add(new Edge(flights[i][0], flights[i][1], flights[i][2]));

        }

    }

    static class Info {

        int v;
        int cost;
        int stops;

        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;
        }

    }

    public static int CHEAPEST_F(ArrayList<Edge>[] graph, int src, int des, int k) {

        int dis[] = new int[graph.length];

        for (int i = 0; i < dis.length; i++) {
            if (i != src) {
                dis[i] = Integer.MAX_VALUE;

            }
        }


        Queue<Info> que = new LinkedList<>();

        que.add(new Info(src, 0, 0));

        while (!que.isEmpty()) {

            Info curr = que.remove();

            if (curr.stops > k) {
                break;
            }

            for (int i = 0; i < graph[curr.v].size(); i++) {

                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (dis[u] != Integer.MAX_VALUE && curr.cost + wt < dis[v] && curr.stops <= k) {
                    dis[v] = curr.cost + wt;
                    que.add(new Info(v, dis[v], curr.stops + 1));
                }

            }

        }

        if (dis[des] ==Integer.MAX_VALUE) {
            return -1;
        }else{
            return dis[des];
        }

    }

    public static void main(String[] args) {

        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };

        int V = 4, src = 0, dst = 3, k = 1;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph, flights);
        System.out.println(CHEAPEST_F(graph, src, dst, k));

    }

}

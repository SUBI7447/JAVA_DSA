package PART_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Kahns_Algo {

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

    public static void K_Algo(ArrayList<Edge> graph[]) {

        Queue<Integer> que = new LinkedList<>();

        int[] indegree = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {

            for (int j = 0; j < graph[i].size(); j++) {

                indegree[graph[i].get(j).dest]++;

            }

        }

        for (int i = 0; i < indegree.length; i++) {

            if (indegree[i] == 0) {
                que.add(i);

            }

        }

        while (!que.isEmpty()) {

            int curr = que.remove();
            System.out.println(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                indegree[graph[curr].get(i).dest]--;
                
                if (indegree[graph[curr].get(i).dest] == 0) {
                    que.add(graph[curr].get(i).dest);

                }

            }

        }

    }

    public static void main(String[] args) {

        int V = 6;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        K_Algo(graph);

    }
}

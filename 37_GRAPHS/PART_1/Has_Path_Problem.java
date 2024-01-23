import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Has_Path_Problem {

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

        graph[6].add(new Edge(6, 5, 2));
    }

    public static boolean HasPath(ArrayList<Edge> graph[], boolean visited[], int src, int dest) {//

        if (src == dest) {
            return true;
        }

        visited[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {

            if (!visited[graph[src].get(i).dest] && HasPath(graph, visited, graph[src].get(i).dest, dest)) {

                return true;

            }

        }

        return false;

    }

    public static void main(String[] args) {

        int V = 7;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        boolean visited[] = new boolean[graph.length];
        int src = 0;
        int dest = 5;
        System.out.println(HasPath(graph, visited, src, dest));

    }
}
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class MinDistSrcToDes {

    static boolean bfs(ArrayList<ArrayList<Integer>> adj, int v, int src, int dst, int pred[], int dist[],
            boolean isVisited[]) {

        Queue<Integer> queue = new ArrayDeque<Integer>();

        for (int index = 0; index < v; index++) {
            isVisited[index] = false; // currently all indexes are not visited
            dist[index] = Integer.MAX_VALUE; // distance from src to current node
            pred[index] = -1; // keep path from src to dest
        }

        // Algorithm:
        /*
         * start from the src node make isVisited true for current node
         * keep connecting nodes,store in queue, if connected nodes are not visited
         * before
         * (from isVisited array).
         * Continue traversing:
         */

        isVisited[0] = true;
        dist[0] = 0;
        queue.add(src);

        int u = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int size = adj.get(u).size();

            for (int i = 0; i < size; i++) {
                int neighbor = adj.get(u).get(i);
                if (!isVisited[neighbor]) {
                    isVisited[neighbor] = true;
                    dist[neighbor] = dist[curr] + 1;
                    pred[neighbor] = curr;
                    queue.add(neighbor);
                }
                if (neighbor == dst)
                    return true;
            }

            u++;
        }

        return false;

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int v = 7;
        int e = 10;

        int dist[] = new int[v + 1];
        int pred[] = new int[v + 1];
        boolean vis[] = new boolean[v + 1];

        int src = 1;
        int dst = 7;

        boolean isReachable = bfs(adj, v, src, dst, pred, dist, vis);

        System.out.println("Is reachable: " + isReachable);

        // 2nd Question: Find number of connected components.
        // Algorithm:
        /*
         * iterate isVisited Array:
         * if current value is false
         * ----then call bfs and increment counter (calling bfs for unvisited values so
         * that we can visit them)
         * ----else continue...
         * 
         */

        int counter = 0;

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                counter++;
                bfs(adj, v, src, dst, pred, dist, vis); // TODO : need to update this calling function.
            }
        }

        System.out.println("Total components: " + counter);
    }
}

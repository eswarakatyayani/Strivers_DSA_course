import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // Step 1: Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] t : times) {
            int u = t[0];
            int v = t[1];
            int w = t[2];
            adj.get(u).add(new int[]{v, w});
        }

        // Step 2: Min heap (distance, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Step 3: Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Start from source
        dist[k] = 0;
        pq.offer(new int[]{0, k});

        // Step 4: Dijkstra
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currDist = curr[0];
            int node = curr[1];

            // Skip outdated entries
            if (currDist > dist[node]) continue;

            for (int[] neighbor : adj.get(node)) {
                int next = neighbor[0];
                int weight = neighbor[1];

                if (dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    pq.offer(new int[]{dist[next], next});
                }
            }
        }

        // Step 5: Find max time
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}

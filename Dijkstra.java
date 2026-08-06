import java.util.*;

public class Dijkstra {

    public class Main {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int m = sc.nextInt();

            ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

            for(int i = 0; i <= n; i++){
                adj.add(new ArrayList<>());
            }

            for(int i = 0; i < m; i++){

                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();

                adj.get(u).add(new int[]{v, w});
                adj.get(v).add(new int[]{u, w});
            }

            // Dijkstra here
            PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
            long[] dist = new long[n+1];
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[1] = 0 ; // dist from source to source is 0
            pq.add(new long[]{0 , 1});

            int[] parent = new int[n + 1];

            for(int i = 1; i <= n; i++){
                parent[i] = i;
            }

            while(!pq.isEmpty()){
                long[] curr = pq.poll();
                long d = curr[0];
                int node = (int)curr[1] ;

                if(d > dist[node]) continue;
                for(int[] edge : adj.get(node)){
                    int adjNode = edge[0];
                    long weight = edge[1];
                    if(d + weight < dist[adjNode]){
                        dist[adjNode] = d + weight ;
                        parent[adjNode] = node;
                        pq.add(new long[]{ dist[adjNode] , adjNode});
                    }
                }
            }
            if(dist[n] == Long.MAX_VALUE){
                System.out.println(-1);
                return;
            }
            ArrayList<Integer> path = new ArrayList<>();

            int curr = n;

            while (curr != parent[curr]) {
                path.add(curr);
                curr = parent[curr];
            }

            path.add(1);
            Collections.reverse(path);
            for (int node : path) {
                System.out.print(node + " ");
            }
        }
    }
}


















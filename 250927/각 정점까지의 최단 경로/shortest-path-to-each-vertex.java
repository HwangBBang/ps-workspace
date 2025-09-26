import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int num;
        int dist;
        public Node(int num, int dist){
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node other){
            return Integer.compare(this.dist, other.dist);
        }
    }

    static class Edge{
        int to;
        int weight;
        
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    
    static int n;
    static int[] dist;
    static  List<Edge>[] graph;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        int m = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph[u].add(new Edge(v,w));
            graph[v].add(new Edge(u,w));
        }

        dist = new int[n+1];
        Arrays.fill(dist, INF);
        
        
        dist[k] = 0;        
        dijkstra(k);

        for (int i=1; i <= n; i++){
            int result = dist[i] == INF ? -1 : dist[i];
            System.out.println(result);
        }
        
    }

    static void dijkstra(int start){
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        
        minHeap.add(new Node(start,0));

        while (!minHeap.isEmpty()){
            Node curNode = minHeap.poll();

            if (curNode.dist != dist[curNode.num]) continue;

            for (Edge edge : graph[curNode.num]){
                
                int newDist = edge.weight + curNode.dist;

                if (dist[edge.to] > newDist){
                    dist[edge.to] = newDist;
                    
                    minHeap.add(new Node(edge.to, newDist));
                }
            }
        }

    }
}
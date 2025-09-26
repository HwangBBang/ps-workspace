import java.util.*;
public class Main {

    static class Node implements Comparable<Node> {
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

    static List<Edge>[] graph;
    static int[] dist;
    static int[] parent;
    static int n ;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList[n+1];

        dist = new int[n+1];
        parent = new int[n+1];

        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);

        for (int i = 1; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Edge(v,w));
        }

        int a = sc.nextInt();
        int b = sc.nextInt();

        dijkstra(a);

        System.out.println(dist[b]);
        for (int each :getPath(b)){
            System.out.print(each + " ") ;
        }
    }

    static void dijkstra(int start){
        dist[start] = 0;
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        minHeap.add(new Node(start, 0));

        while(!minHeap.isEmpty()){
            Node curNode = minHeap.poll();

            if (curNode.dist != dist[curNode.num]) continue;

            for (Edge edge :graph[curNode.num]){
                int newDist = edge.weight + curNode.dist;
                if (newDist < dist[edge.to]){
                    dist[edge.to] = newDist;
                    parent[edge.to] = curNode.num;
                    minHeap.add(new Node(edge.to, newDist));
                }
            }

        }
    }

    static List<Integer> getPath(int end){
        List<Integer> path = new ArrayList<>();

        int cur = end;
        while (cur != -1){
            path.add(cur);
            cur = parent[cur];
        }
        Collections.reverse(path);
        return path;
    }
}
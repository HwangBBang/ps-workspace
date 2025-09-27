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

    static List<Edge>[] graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList[n+1]; 
        for (int i = 1; i <= n; i++) 
            graph[i] = new ArrayList<>();
        
        dist = new int[n+1]; 
        Arrays.fill(dist, INF);


        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph[u].add(new Edge(v,w));
            graph[v].add(new Edge(u,w));
        }

        int a = sc.nextInt();
        int b = sc.nextInt();

        dijkstra(a);

        System.out.println(dist[b]);
    }

    static void dijkstra(int start){
        dist[start] = 0;
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        minHeap.add(new Node(start,0));

        while(!minHeap.isEmpty()){
            Node curNode = minHeap.poll();

            if(curNode.dist != dist[curNode.num]) continue;

            for (Edge edge : graph[curNode.num]){
                int newDist = edge.weight + dist[curNode.num];

                if (dist[edge.to] > newDist){
                    dist[edge.to] = newDist;
                    minHeap.add(new Node(edge.to, newDist));
                }
            }
        }

    }
}

/*

    1 ~ N 까지 노드 
    M개의 간선 + 가중치 + 양방향
    A -> B 까지의 최단거리 

*/
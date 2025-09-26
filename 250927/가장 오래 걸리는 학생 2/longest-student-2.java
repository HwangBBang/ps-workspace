import java.util.*;

public class Main {
    static int[] dist;
    static List<Edge>[] graph;

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();
            
            graph[a].add(new Edge(b,d));
            graph[b].add(new Edge(a,d));
        }


        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(n);
        
        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++){
            result = Math.max(result, dist[i]);
        }
        System.out.println(result);
        
    }

    static void dijkstra(int start){
        PriorityQueue <Node> minHeap = new PriorityQueue<>();
        minHeap.add(new Node(start,0));
        dist[start] = 0;
        while(!minHeap.isEmpty()){
            Node curNode = minHeap.poll();
            if(curNode.dist > dist[curNode.num]) continue;

            for (Edge edge : graph[curNode.num]){
                int newDist = curNode.dist + edge.weight;
                int nextNum = edge.to;
                
                if (dist[nextNum] > newDist){
                    dist[nextNum] = newDist;
                    minHeap.add(new Node(nextNum, newDist));
                }
            }
        }


    }
}
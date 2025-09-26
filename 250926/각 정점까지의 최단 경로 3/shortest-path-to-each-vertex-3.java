import java.util.*;

public class Main {
    static class Edge{
        int to, weight;
        
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node>{
        int num;
        int dist;
        public Node(int num, int dist){
            this.num = num;
            this.dist = dist;
        }
        
        @Override 
        public int compareTo(Node other){
            return Integer.compare(this.dist , other.dist);
        }

    }
    
    static final int INF = Integer.MAX_VALUE;
    static List<Edge>[] graph;
    static int [] dist;
    static int n;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        
        dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            
            graph[u].add(new Edge(v,w));
        }
        
        dist[1] = 0;
        dijkstra(1);

        for (int i = 2; i <= n; i++){
            dist[i] = dist[i] == INF ? -1 : dist[i];
            System.out.println(dist[i]);
        }

    }

    public static void dijkstra(int start){
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        
        minHeap.add(new Node(1, 0));
        for (int i = 2; i <= n; i ++){
            minHeap.add(new Node(i, INF));
        }

        while(!minHeap.isEmpty()){
            Node curNode = minHeap.poll();
        
            if (curNode.dist > dist[curNode.num]) continue;

            for (Edge edge : graph[curNode.num]){
                int newDist = curNode.dist + edge.weight;

                if (newDist < dist[edge.to]){
                    dist[edge.to] = newDist;
                    minHeap.add(new Node(edge.to, newDist));
                }
            }
            

        }


    }
}

/*

    다익스트라 알고리즘은 
    특정 점에서 모든 정점까지의 최단 거리를 알 수 있는 알고리즘 

    큰 컨셉은, A -> B까지의 최단 거리를 안다고 가정할 때

    A -> C 거리 = min ((A -> B 거리)+(B -> C 거리) (A -> C 거리))

    거리 배열 은 전부 INF로 초기화, 출발지만 0으로 초기화

    거리 배열 중 최솟값을 골라 (자주쓸꺼임 -> 자료 구조 활용 -> PQ) minHeap 쓰면 되겠다.

    그럼 출발지인 0이 선택 될 것이고 이것을 poll

    출발지에서 갈 수 있는 노드 확인 (연결된 edge 확인) 

    dist[현재노드] + 간선 가중치 => 출발지에서 이동할 노드의 최솟값

    dist[출발지에서 이동할 노드] = min(dist[현재노드] + 간선 가중치, dist[출발지에서 이동할 노드]) 


*/
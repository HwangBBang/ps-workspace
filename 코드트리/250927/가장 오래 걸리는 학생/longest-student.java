import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node>{
        int num;
        int dist;
        
        public Node(int num,int dist){
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
        
        public Edge (int to,int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    
    static List<Edge>[] graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        dist = new int[n+1];
        Arrays.fill(dist,INF);

        for (int e = 0; e < m ; e++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v,w));

            graph[v].add(new Edge(u,w));
            
        }

        dijkstra(n);
        
        int answer = -1;
        for (int d : dist){ 
            if (d == INF) continue;
            answer = Math.max(answer ,d);
        }
        System.out.println(answer);
    }

    static void dijkstra(int start){

        dist[start] = 0;
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        minHeap.add(new Node(start, 0));

        while(!minHeap.isEmpty()){
            Node curNode = minHeap.poll();
            
            // 구버전 스킵  
            if (curNode.dist > dist[curNode.num]) continue;

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

/*
    n 개의 다른 노드(장소)
    가중치 그래프 
    n 에서 출발해서 각각 도착하는 노드중 가장 큰거 
*/
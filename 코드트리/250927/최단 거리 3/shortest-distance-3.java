import java.util.*;
import java.io.*;


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

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1]; 
        for (int i = 1; i <= n; i++) 
            graph[i] = new ArrayList<>();
        
        dist = new int[n+1]; 
        Arrays.fill(dist, INF);


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v,w));
            graph[v].add(new Edge(u,w));
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

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
    dist[] 에는 최선의 기록만 담긴다. 
    dist[num]과 현재 노드에 기록된 dist 가 다르다면, 이웃 노드 갱신 작업이 의미가 없다. 

*/
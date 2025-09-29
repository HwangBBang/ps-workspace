import java.util.*;
import java.io.*;


public class Main {

    static class Node implements Comparable<Node>{
        int num;
        int dist;
            public Node( int num , int dist){
                this.num = num;
                this.dist= dist;
            }
        @Override
        public int compareTo(Node other){
            return Integer.compare(this.dist , other.dist);
        }
    }

    static class Edge{
        int to;
        int w;

        public Edge( int to , int w){
            this.to = to;
            this.w= w;
        }
    }

    static List<Edge>[] graph;
    static int n;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] targets = new int[]{a,b,c};

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to,weight));
            graph[to].add(new Edge(from,weight));
        }

        
        long answer = 0;
        
        long [] distA = dijkstra(a);
        long [] distB = dijkstra(b);
        long [] distC = dijkstra(c);

        for (int i = 1; i <= n; i++){
            long max = Math.min(distA[i], Math.min(distB[i], distC[i]));
            answer = Math.max(max,answer);
        }
        System.out.print(answer);
        
    }

    static long[] dijkstra(int start){
        long [] dist = new long[n+1];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if (dist[cur.num] != cur.dist) continue;

            for (Edge nxt : graph[cur.num]){
                int newDist = cur.dist + nxt.w;
                
                if (dist[nxt.to] > newDist){
                    dist[nxt.to] = newDist;
                    pq.add(new Node(nxt.to, newDist));
                }
            }
        }
        return dist;
    }
}

/*
    N개 의 정점, 양방향 그래프 가중치 (간선길이)
    -> 각 
    -> dijkstra ?

                          1  2  3  4  5  6
    dijkstra(1) : 출발 1  [0, 1, 4, 2, 4, 5]
    dijkstra(2) : 출발 2  [1, 0, 4, 3, 3, 5]
    dijkstra(5) : 출발 5  [4, 3, 7, 6, 0, 2]
    
    dijkstra(3) : 출발 3  [4, 4, 0, 2, 7, 9]
    dijkstra(4) : 출발 3  [2, 3, 2, 0, 6, 7]

    A,B,C

*/
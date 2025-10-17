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

    static long [] dist;
    static List<Edge>[] graph;
    static int n;
    static final long INF = Long.MAX_VALUE;
    static int a, b, c;

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
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

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
        dijkstra();
        

        for (int i = 1; i <= n; i++){
            answer = Math.max(answer,dist[i]);   
        }
        System.out.println(answer);
        
    }

    static void dijkstra(){
        dist = new long[n+1];
        Arrays.fill(dist, INF);

        dist[a] = 0;
        dist[b] = 0;
        dist[c] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(a,0));
        pq.add(new Node(b,0));
        pq.add(new Node(c,0));

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
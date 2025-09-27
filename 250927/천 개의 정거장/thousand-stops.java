import java.util.*;
import java.io.*;
public class Main {

    static class Node implements Comparable <Node>{
        int num;
        long cost;
        int time;

        public Node(int num,long cost, int time){
            this.num = num;
            this.cost = cost;
            this.time = time;
        }
        
        @Override 
        public int compareTo(Node other){
            if (this.cost != other.cost)
                return Long.compare(this.cost, other.cost);
            else
                return Integer.compare(this.time, other.time);
        }
    }

    static class Edge{
        int to;
        int fare;
        int time;

        public Edge(int to,int fare, int time){
            this.to = to;
            this.fare = fare;
            this.time = time;
        }
    }

    static List<Edge>[] graph;
    static Map<Integer, Edge>[] gmap; 

    static long[] minCost;
    static int[] minTime;

    static final long INF = Long.MAX_VALUE;
    static final int NODE_CNT = 1000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        
        gmap = new HashMap[NODE_CNT + 1];

        for (int i = 1; i <= NODE_CNT; i++){
            // graph[i] = new ArrayList<>();
            gmap[i] = new HashMap<>();
        }

        minCost = new long[NODE_CNT+1];
        minTime = new int[NODE_CNT+1];
        
        Arrays.fill(minCost, INF);
        Arrays.fill(minTime, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int stopCount = Integer.parseInt(st.nextToken());
            
            int [] path = new int[stopCount];

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < stopCount; j++) {
                int stop = Integer.parseInt(st.nextToken());
                path[j] = stop;
            }

            for (int u = 0; u < stopCount; u++){
                for (int v = u+1; v < stopCount; v++){
                    // graph[path[u]].add(new Edge(path[v],cost,v-u));
                    putMinEdge(path[u],path[v],cost, v-u);
                }
            }
        }
        graph = new ArrayList[NODE_CNT+1];
        for (int i = 1; i <= NODE_CNT; i++) {
            Map<Integer, Edge> m = gmap[i];
            graph[i] = new ArrayList<>(m.size());
            graph[i].addAll(m.values());
            gmap[i] = null; // GC 힌트
    }


        dijkstra(A);

        StringBuilder sb = new StringBuilder();
        if (minCost[B] == INF) sb = sb.append(-1).append(" ").append(-1);
        else sb = sb.append(minCost[B]).append(" ").append(minTime[B]);        
        System.out.println(sb);
        
    }

    static void dijkstra(int start){
        minCost[start] = 0;
        minTime[start] = 0;
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        minHeap.add(new Node(start,0, 0));

        while(!minHeap.isEmpty()){
            Node curNode = minHeap.poll();

            if (curNode.cost != minCost[curNode.num] || curNode.time != minTime[curNode.num]) continue;

            for (Edge edge : graph[curNode.num]){
                long newCost = edge.fare + curNode.cost; 
                int newTime = edge.time + curNode.time; 

                if (minCost[edge.to] > newCost){
                    minCost[edge.to] = newCost;
                    minTime[edge.to] = newTime;
                    minHeap.add(new Node(edge.to, newCost, newTime));

                } else if (minCost[edge.to] == newCost && minTime[edge.to] > newTime){
                    minTime[edge.to] = newTime;
                    minHeap.add(new Node(edge.to, newCost, newTime));

                }

            }
        }
    }
    // 사전식 기준으로 더 좋은 간선만 저장
    static void putMinEdge(int u, int v, int fare, int time) {
        Edge old = gmap[u].get(v);
        if (old == null || fare < old.fare || (fare == old.fare && time < old.time)) {
            gmap[u].put(v, new Edge(v, fare, time));
        }
    }
}

/*
    1000 개 노드 (정점)
    N개의 버스가 이동 각 노선 -> 다익스트라 여러번..?
    
    각 버스는 출발지 -> 도착지 ,다시 출발지 -> 도착지
    탑승료 (가중치)

    중간 하차시 - 탑승료 동일 
    노선 하나가 하나의 큰 Edge
    도착지 도달시 반드시 하차 
    
    최소 비용을 위한 최소 시간 구하기
    "최소 비용"이 관리 포인트 
    
    1_000_000_000
    
*/ 

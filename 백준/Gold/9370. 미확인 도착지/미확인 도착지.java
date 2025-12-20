// package baekjoon.gold;

import java.io.*;
import java.util.*;


public class Main {
    static class Node implements Comparable<Node>{
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
    static class Edge {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    static List<Edge>[] graph;
    static int[] candidate;
    static final int INF = Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 노드 갯수
            int m = Integer.parseInt(st.nextToken()); // 엣지 갯수
            int c = Integer.parseInt(st.nextToken()); // 목적지 후보 갯수

            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            candidate = new int[c];

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 출발점
            int target1 = Integer.parseInt(st.nextToken()); // 반드시 지난다.
            int target2 = Integer.parseInt(st.nextToken()); // 반드시 지난다.

            int targetCost = 0;
            for (int i = 0; i < m; i++) { // 엣지 입력
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                graph[from].add(new Edge(to, w));
                graph[to].add(new Edge(from, w));
                if ((target1 == from && target2 == to) || (target1 == to && target2 == from)) {
                    targetCost = w;
                }
            }

            for (int i = 0; i < c; i++) {
                candidate[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(candidate);

            int[] distByStart = dijkstra(start);
            int[] distByTarget1 = dijkstra(target1);
            int[] distByTarget2 = dijkstra(target2);

            for (int each : candidate) {
                if (distByStart[each] == INF) continue;


                int endCost1 = (distByStart[target1] == INF || distByTarget1[each] == INF) ? INF :
                        distByStart[target1] + targetCost + distByTarget2[each];


                int endCost2 = (distByStart[target2] == INF || distByTarget2[each] == INF) ? INF :
                        distByStart[target2] + targetCost + distByTarget1[each];

                if (distByStart[each] == endCost1 || distByStart[each] == endCost2) {
                    sb.append(each).append(' ');
                }
            }
            sb.append('\n');

        }
        System.out.println(sb);
    }
    // target1 을 지나게 한후 target2 에서 생각 
    // target2 을 지나게 한후 target1 에서 생각 
    
    static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.num] != cur.cost) continue;

            for (Edge next : graph[cur.num]) {
                if (dist[next.to] > next.cost + dist[cur.num]) {
                    dist[next.to] = next.cost + dist[cur.num];
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }
}


/*
    크루스칼,,?

    다익스트라 2회 
    s + t1 의 최단 거리
    t2 + e 의 최단 거리 

    s + t2 의 최단 거리
    t1 + e 의 최단 거리 


 */
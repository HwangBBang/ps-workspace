// package baekjoon.platinum;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static List<Edge>[] graph;
    static final long INF = Long.MAX_VALUE / 4;

    static class Node implements Comparable<Node>{
        int num;
        int pCnt;
        long cost;

        public Node(int num,int pCnt, long cost) {
            this.num = num;
            this.pCnt = pCnt;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.cost, other.cost);
        }
    }

    static class Edge {
        int to;
        long w;

        public Edge(int to,long w) {
            this.to = to;
            this.w = w;
        }
    }
    
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/platinum/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n ; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));
        }

        long answer = dijkstra(1);
        System.out.println(answer);
    }

    public static long dijkstra(int start) {
        long[][] dist = new long[n + 1][k + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i <= n ; i++) Arrays.fill(dist[i], INF);

        dist[start][0] = 0; // 포장이 0인 채로 시작
        pq.add(new Node(start, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost != dist[cur.num][cur.pCnt]) continue;

            for (Edge next : graph[cur.num]) {
                // 포장했을 때,
                if (cur.pCnt < k) {
                    long newDist = 0 + dist[cur.num][cur.pCnt]; // 포장
                    if (dist[next.to][cur.pCnt + 1] > newDist) {
                        dist[next.to][cur.pCnt + 1] = newDist;
                        pq.add(new Node(next.to, cur.pCnt + 1, newDist));
                    }
                }

                // 포장하지 않을 때,
                long newDist = next.w + dist[cur.num][cur.pCnt];
                if (dist[next.to][cur.pCnt] > newDist) {
                    dist[next.to][cur.pCnt] = newDist;
                    pq.add(new Node(next.to, cur.pCnt, newDist));
                }

            }
        }

        long result = INF;
        for (int i = 0; i <= k ; i++) {
            result = Math.min(dist[n][i], result);
        }
        return result;
    }
}

/*
    연결에 사용된(경로인) 간선 가중치 중 비싼거 k 개를 0으로.
    비싼 가중치는 중복이 있을 수 있고,
    경로가 아닌 비싼 간선을 포장(0으로 만들기) 는 의미가 없다.
    즉, 경로에 있는 비싼 간선을 포장해야한다.
    그럼 모든 경로를 알아야하고, (DFS)
    경로의 비용중 비싼거 k개를 제거했을 때, 최종 비용을 알아야한다.
    이렇게 모든 경로를 다뽑는다면, 시간초과 및 메모리에 문제가 발생..

    누적 거리에 상태 개념을 추가. => 2차원으로 만들어 포장 수에 대한 상태를 관리하자.
*/
// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int n, k, m;
    static List<int[]>[] graph;

    static class Station implements Comparable<Station> {
        int num;
        int cost;

        public Station(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Station other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int[] hyperTube = new int[k];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                hyperTube[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < k; j++) {
                int u = hyperTube[j];
                graph[u].add(hyperTube);
            }
        }

        int answer = bfs(1);
        answer = (answer == INF) ? -1 : answer; 
        
        System.out.println(answer);
    }
    static int bfs(int start) {
        int[] dist = new int[n + 1]; Arrays.fill(dist, INF);
        PriorityQueue<Station> que = new PriorityQueue<>();

        dist[start] = 1;
        que.add(new Station(start, 1));

        while (!que.isEmpty()) {
            Station cur = que.poll();
            if(cur.cost != dist[cur.num]) continue;

            for (int[] hyperTube : graph[cur.num]) {
                for (int nxt : hyperTube){
                    if (cur.num == nxt) continue;
                    if (dist[nxt] > cur.cost + 1) {
                        dist[nxt] = cur.cost + 1;
                        que.add(new Station(nxt, dist[nxt]));
                    }
                }

            }
        }

        int result = dist[n];

        return result;
    }
}

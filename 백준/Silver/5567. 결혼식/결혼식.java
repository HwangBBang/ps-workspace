// package baekjoon.silver;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] graph;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        int answer = bfs();

        System.out.println(answer);


    }

    static int bfs() {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> que = new ArrayDeque<>();

        dist[1] = 0;
        que.add(1);

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int next : graph[cur]) {
                if (dist[next] != -1) continue;

                dist[next] = dist[cur] + 1;
                que.add(next);
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == 1 || dist[i] == 2) result++;
        }
        return result;
    }

}

/*
    높이 이하는 물에 다 잠긴다.
*/
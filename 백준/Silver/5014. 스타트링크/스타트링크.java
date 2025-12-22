// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int F,U,D;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken()); // start
        int G = Integer.parseInt(st.nextToken()); // goal
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
//        1 ~ F 층까지

        int result = bfs(S, G);
        Object answer = result == INF ? "use the stairs" : result;
        System.out.println(answer);
    }

    static int bfs(int start, int end) {
        Queue<Integer> que = new ArrayDeque<>();
        int[] dist = new int[F + 1];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        que.add(start);

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int i = 0; i < 2; i++) {
                int next = getNext(cur, i);
                if (outOfRange(next)) continue;
                if (dist[next] != INF) continue;

                dist[next] = dist[cur] + 1;
                que.add(next);
            }
        }
        return dist[end];
    }

    static int getNext(int x, int idx) {
        if (idx == 0) {
            return x + U;
        } else {
            return x - D;
        }
    }

    static boolean outOfRange(int x) {
        return x < 1 || x > F;
    }
}

//1_000_000
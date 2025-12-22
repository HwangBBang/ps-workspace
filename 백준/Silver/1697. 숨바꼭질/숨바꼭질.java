// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int N = 100_000;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bfs(start, end);

    }

    static void bfs(int start, int end) {
        Queue<Integer> que = new ArrayDeque<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        que.add(start);

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int i = 0; i < 3; i++) {
                int next = getNext(i, cur);
                if (outOfRange(next)) continue;
                if (dist[next] != INF) continue;

                dist[next] = dist[cur] + 1;
                que.add(next);
            }

        }

        System.out.println(dist[end]);

    }
    static int getNext(int idx, int cur) {
        int next = -1;
        if (idx == 0) {
            next = cur + 1;

        } else if (idx == 1) {
            next = cur - 1;

        } else if (idx == 2) {
            next = cur * 2;
        }
        return next;
    }
    static boolean outOfRange(int x) {
        return x < 0 || x > N;
    }

}

/*
*/
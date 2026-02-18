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
    static final int INF = Integer.MAX_VALUE;

    static int n;
    static int[] A;
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int result = bfs();
        int answer = result == INF ? -1 : result;
        System.out.println(answer);
    }

    static int bfs() {
        Queue<Integer> que = new ArrayDeque<>();
        int[] dist = new int[n];
        Arrays.fill(dist, INF);

        dist[0] = 0;
        que.add(0);

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int d = A[cur]; d >= 0 ; d--) {
                int next = cur + d;
                if (next < 0 || next >= n) continue;
                if (dist[next] != INF) continue;

                dist[next] = dist[cur] + 1;
                que.add(next);

            }
        }
        return dist[n - 1];
    }
}

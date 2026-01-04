// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int SIZE = 10;
    static int[] shift;
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        shift = new int[100 + 1];
        Arrays.fill(shift, -1);

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            shift[from] = to;
        }
        bfs();
    }

    static void bfs() {
        int[] dist = new int[100 + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> que = new ArrayDeque<>();

        dist[1] = 0;
        que.add(1);

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int i = 1; i <= 6; i++) {
                int nx = cur + i;
                if (outOfRange(nx)) continue;

                nx = (shift[nx] != -1) ? shift[nx] : nx; // 사다리/뱀 적용

                if (dist[nx] != -1) continue;
                dist[nx] = dist[cur] + 1;
                que.add(nx);
            }
        }
        System.out.println(dist[100]);
    }

    private static boolean outOfRange(int x) {
        return x < 1 || x > SIZE * SIZE;
    }
}

// 도착한 칸이 사다리면, 사다리를 타고 위로 올라간다.
// 뱀이 있는 칸에 도착하면, 뱀을 따라서 내려가게 된다.
//
// 즉, 사다리를 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 크고, 뱀을 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 작아진다.
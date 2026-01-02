// package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int SIZE = 500_000;

    static int n, k;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/platinum/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] time = bfs(n);
        int answer = -1;
        for (int t = 0; t <= SIZE; t++) {
            long add = ((long) t * (t + 1)) / 2;
            if (k + add > SIZE) break;

            int otherDist = (int)(k + add);

            if (time[t % 2][otherDist] == -1) continue;
            if (time[t % 2][otherDist] <= t) {
                int diff = t - time[t % 2][otherDist];
                if (diff % 2 == 0) {  // 2 배수 만큼 차이난다면
                    answer = t;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    static class Node {
        int dist;
        int parity;

        public Node(int dist, int parity) {
            this.dist = dist;
            this.parity = parity;
        }
    }
    static int[][] bfs(int start) {
        int[][] time = new int[2][SIZE + 1];
        Arrays.fill(time[0], -1);
        Arrays.fill(time[1], -1);

        Queue<Node> que = new ArrayDeque<>();

        time[0 % 2][start] = 0;
        que.add(new Node(start, 0 % 2));

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int curTime = time[cur.parity][cur.dist];
            int nextParity = cur.parity == 1 ? 0 : 1;

            for (int i = 0; i < 3; i++) {
                int nx = getNext(cur.dist, i);
                if (outOfRange(nx)) continue;
                if (time[nextParity][nx] != -1) continue;
                time[nextParity][nx] = time[cur.parity][cur.dist] + 1;
                que.add(new Node(nx, nextParity));
            }
        }
        return time;
    }

    static int getNext(int num, int idx) {
        if (idx == 0) {
            return num + 1;
        } else if (idx == 1) {
            return num - 1;
        } else {
            return num * 2;
        }
    }

    static boolean outOfRange(int x) {
        return x < 0 || x > SIZE;
    }
}

/*
     만약, 수빈이
     - 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
     - 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

     동생은 항상 걷기만 한다.

     동생은 항상 매 초마다 이동을 하며, 이동은 가속이 붙는다. 동생이 이동하는 거리는 이전에 이동한 거리보다 1을 더한 만큼 이동한다. 즉, 동생의 처음 위치는 K, 1초가 지난 후 위치는 K+1, 2초가 지난 후 위치는 K+1+2, 3초가 지난 후의 위치는 K+1+2+3이다.


    10

    + 1
    - 1

    한번 바꾸 했다 2초 씩 딜레 가능
    짝홀 나눠서 생각해야함 ,,<- 나중에 다시 풀어보기 (어려움,)
*/
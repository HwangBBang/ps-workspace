// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {     
    static int n;
    static int[] ds = new int[]{-1, 0, 1};
    static final int INF = Integer.MAX_VALUE;

    static class Node {
        int num;
        int d;

        public Node(int num, int d) {
            this.num = num;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<Integer> impossible = new HashSet<>();

        for (int i = 0; i < m; i++) {
            impossible.add(Integer.parseInt(br.readLine()));
        }

        int result = bfs(impossible);
        int answer = result == INF ? -1 : result;
        System.out.println(answer);
    }

    static int bfs(Set<Integer> impossible) {
        int upbound = (int) Math.sqrt(2 * n);
        // 거리 / 직전 d
        int[][] dist = new int[n + 1][upbound + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
        }
        Queue<Node> que = new ArrayDeque<>();
        dist[1][0] = 0;
        que.add(new Node(1, 0));

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int cNum = cur.num;
            int cd = cur.d;

            for (int i = 0; i < ds.length; i++) {
                int nd = cd + ds[i];
                if (nd < 1) continue;

                int nNum = nd + cNum;

                if (outOfRange(nNum)) continue;
                if (impossible.contains(nNum)) continue;
                if (nd > upbound) continue;
                if (dist[nNum][nd] <= dist[cNum][cd]) continue;
                if (dist[nNum][nd] <= dist[cNum][cd] + 1) continue;

                dist[nNum][nd] = dist[cNum][cd] + 1;
                que.add(new Node(nNum, nd));
            }
        }
        int result = INF;
        for (int i = 0; i <= upbound; i++) {
            result = Math.min(result, dist[n][i]);
        }
        return result;

    }

    static boolean outOfRange(int x) {
        return x < 1 || x > n;
    }

}

/*
    12345678910
    55
    k = n(n + 1)/2
    2 * k = (n + 1)*( n + 1)
    루트 (2 * k) = (n + 1)
    루트 (2 * k) - 1  = n
    루트 (2 * k) = n

*/

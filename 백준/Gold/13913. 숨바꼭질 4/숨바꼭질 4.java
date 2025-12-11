// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int SIZE = 100_000;
    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new ArrayDeque<>();
        int[] dist = new int[SIZE + 1];
        int[] parent = new int[SIZE + 1];
        Arrays.fill(dist, -1);

        parent[n] = -1;
        dist[n] = 0;
        que.add(n);

        while (!que.isEmpty()) {
            Integer cur = que.poll();
            if (k == cur) break;
            for (int i = 0; i < 3; i++) {
                int next = getNext(cur, i);
                if (outOfRange(next, SIZE)) continue;
                if (dist[next] != -1) continue;

                dist[next] = dist[cur] + 1;
                parent[next] = cur;
                que.add(next);
            }
        }
        List<Integer> path = new ArrayList<>();
        int cur = k;
        path.add(cur);
        while (parent[cur] != -1) {
            path.add(parent[cur]);
            cur = parent[cur];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dist[k]);
        sb.append("\n");
        for (int i =  path.size()-1; i >= 0; i--) {
            sb.append(path.get(i)).append(" ");
        }
        System.out.println(sb);

    }

    static boolean outOfRange(int x, int n) {
        return x < 0 || x > n;
    }

    static int getNext(int cur, int idx) {
        if (idx == 0) {
            return cur + 1;
        } else if (idx == 1) {
            return cur - 1;
        } else {
            return cur * 2;
        }
    }

}

/*
    현재 점은 노드 N 에 있다.
    동생은 K 에 있다 .

    현재 X 일 때,
    걷기 : X-1 X+1 로 이동
    순간이동 : X * 2 로 이동


    수빈이가 K 에 접근하는데 걸리는 최소 시간은 얼마일까?
    이동로그는 어떻게 될까?

    -> DP? , BFS 로도 가능할 듯

    1. BFS



*/
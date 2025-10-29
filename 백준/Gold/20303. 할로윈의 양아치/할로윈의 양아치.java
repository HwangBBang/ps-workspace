// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, m, k;
    static final int INF = Integer.MIN_VALUE;

    static class UnionFind {
        int[] parent;
        int[] size;
        int[] cnt;

        public UnionFind(int n, int[]s) {
            parent = new int[n + 1];
            size = new int[n + 1];
            cnt = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = s[i];
                cnt[i] = 1;
            }
        }

        public boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return false;
            if (size[ra] < size[rb]){int tmp = ra; ra = rb; rb = tmp;}
            parent[rb] = ra;
            cnt[ra] += cnt[rb];
            size[ra] += size[rb];
            cnt [rb] = 0;
            size[rb] = 0;
            return true;
        }

        public int find(int a) {
            while (a != parent[a]) {
                parent[a] = parent[parent[a]];
                a = parent[a];
            }
            return a;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] child = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            child[i] = Integer.parseInt(st.nextToken());
        }
        UnionFind uf = new UnionFind(n, child);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            uf.union(f1, f2);
        }


        int[] dp = new int[k];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int c = uf.cnt[i], s = uf.size[i];
            if (s == 0 || c == 0) continue;

            for (int limit = k - 1; limit >= c; limit--) {
                if (dp[limit - c] == INF) continue;
                dp[limit] = Math.max(dp[limit], dp[limit - c] + s);
            }
        }

        int answer = INF;
        for (int i : dp) {
            answer = Math.max(answer, i);
        }
        System.out.println(answer);
    }
}


/*
    N은 거리에 있는 아이들의 수,
    M은 아이들의 친구 관계 수,
    K는 울음소리가 공명하기 위한 최소 아이의 수

    한 아이의 사탕을 뺏으면 그 아이 친구들의 사탕도 모조리 뺏어버린다.

    DSU(Union-Find) 로 병합 하면, 아이들 수 와 사탕수가 나온다.
    이제 01냅색 문제다 .
*/

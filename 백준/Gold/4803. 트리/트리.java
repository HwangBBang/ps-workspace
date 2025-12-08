// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class UnionFind {
        int[] parent;
        int[] size;
        boolean[] isCycle;

        public UnionFind(int n) {
            this.parent = new int[n + 1];
            this.size = new int[n + 1];
            this.isCycle = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) {
                isCycle[ra] = true;
                return;
            }
            if (size[ra] < size[rb]) {
                int tmp = ra; ra = rb;rb = tmp;
            }

            parent[rb] = ra;
            size[ra] += size[rb];
            size[rb] = 0;

        }

        public int find(int a) {
            while (a != parent[a]) {
                parent[a] = parent[parent[a]];
                a = parent[a];
            }
            return a;
        }

        public int getTreeCnt() {
            int cnt = 0;
            for (int i = 1; i < size.length; i++) {
                if (!isCycle[i] && size[i] > 0) cnt++;
            }
            return cnt;
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        UnionFind uf;
        int t = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0)  break;

            uf = new UnionFind(n);

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                uf.union(node1, node2);
            }

            int cnt = uf.getTreeCnt();

            if (cnt > 1) {
                sb.append(String.format("Case %d: A forest of %d trees.", t, cnt));
            } else if (cnt == 1) {
                sb.append(String.format("Case %d: There is one tree.",t));
            } else {
                sb.append(String.format("Case %d: No trees.",t));
            }
            sb.append("\n");

            t++;
        }


        System.out.println(sb);
    }

}

/*
*/
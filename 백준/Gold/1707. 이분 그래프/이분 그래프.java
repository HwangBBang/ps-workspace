// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            this.parent = new int[n + 1];
            this.size = new int[n + 1];
            for (int i = 1; i <= n ; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return ;
            if (ra > rb) {
                int tmp = ra; ra = rb; rb = tmp;
            }
        // ra < rb
            parent[rb] = ra;
            size[ra] += size[rb];
            size[rb] = 0;
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return parent[x];
        }

        public boolean same(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());
        for (int t = 0; t < k; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            UnionFind uf = new UnionFind(2*n);
            boolean flag = true;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                uf.union(a, b + n);
                uf.union(a + n, b);

                if (uf.same(a, a + n) || uf.same(b, b + n)) {
                    flag = false;
                }
            }

            if (flag) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }

        System.out.println(sb);
    }

}

/*
    각 집합에 속한 정점끼리 인접 X
*/

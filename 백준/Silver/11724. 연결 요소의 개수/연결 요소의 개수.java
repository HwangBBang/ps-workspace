// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n + 1];
            for (int i = 1; i <= n ; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int rx = find(x), ry = find(y);
            if (rx == ry) return;
            if (rx > ry) {
                int tmp = rx;
                rx = ry;
                ry = tmp;
            }
            parent[ry] = rx;
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return parent[x];

        }
    }
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            uf.union(u, v);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(uf.parent[uf.find(i)]);
        }
        System.out.println(set.size());

        // 싸이클의 갯수 세기 DSU


    }

}

/*


*/
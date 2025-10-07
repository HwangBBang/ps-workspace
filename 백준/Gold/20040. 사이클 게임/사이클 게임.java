import java.io.*;
import java.util.*;

public class Main {

    static class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];

            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        public boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return false; // 사이클

            if (size[ra] < size[rb]) { // size a > b 기준
                int tmp = ra;
                ra = rb;
                rb = tmp;
            }
            parent[rb] = ra;
            size[ra] += size[rb];
            size[rb] = 0;
            return true;
        }

        public int find(int a) {
            while (parent[a] != a) { // 루트라면.
                parent[a] = parent[parent[a]];
                a = parent[a];
            }
            return parent[a];
        }
    }
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 0 ~ n-1 번 까지 점(x,y)들 이있다.
        int m = Integer.parseInt(st.nextToken());

        int[][] edges = new int[m+1][2];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        UnionFind uf = new UnionFind(n);

        int answer = 0;
        for (int i = 1; i <= m; i++) {
            int pick1 = edges[i][0];
            int pick2 = edges[i][1];
            if (!uf.union(pick1,pick2)) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);

    }
}
/*


* */
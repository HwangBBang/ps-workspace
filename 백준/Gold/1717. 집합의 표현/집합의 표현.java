import java.io.*;
import java.util.*;

public class Main {

    static class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            this.parent = new int[n + 1];
            this.size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int a, int b) {
            int ra = find(a) , rb = find(b);
            if (ra == rb) return;

            // 작은 놈을 큰놈에게 ra 가 큰놈
            if (size[ra] < size[rb]) {
                int tmp = ra;
                ra = rb;
                rb = tmp;
            }

            parent[rb] = ra;
            size[ra] += size[rb];
            size[rb] = 0;
        }

        public int find(int a) { // 대표자를 반환
            if (parent[a] != a) { // 루트(대표자) 아니라면
                int root = find(parent[a]);
                parent[a] = root;
                return root;
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

        int n = Integer.parseInt(st.nextToken());
        UnionFind uf = new UnionFind(n);

        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cmd == 0) {
                uf.union(a, b);
            } else if (cmd == 1) {
                String result = (uf.find(a) == uf.find(b)) ? "YES" : "NO";
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
    }
}

/*

cmd = 0 a,b를 합집합시킴
cmd = 1 a,b가 같은 집합이니?

초기 각 집합의 대가리
0 1 2 3 4 5 6 7 8
0 1 2 3 4 5 6 7 8

*/

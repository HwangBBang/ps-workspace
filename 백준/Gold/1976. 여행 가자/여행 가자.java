import java.io.*;
import java.util.*;

public class Main {
    static class UnionFind{
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            this.parent = new int[n + 1];
            this.size = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int u, int v) {
            int ru = find(u), rv = find(v);
            if (ru == rv) return;
            if (size[u] < size[v]) {
                int tmp = ru;
                ru = rv;
                rv = tmp;
            }
            parent[rv] = ru;
            size[ru] += size[rv];
            size[rv] = 0;
        }

        public int find(int e) {
            while (parent[e] != e) {
                parent[e] = parent[parent[e]];
                e = parent[e];
            }
            return parent[e];
        }

        public boolean sameGroup(int e1, int e2) {
            return find(e1) == find(e2);
        }
    }
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        UnionFind uf = new UnionFind(n);

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int existEdge = Integer.parseInt(st.nextToken());
                if (existEdge == 1) {
                    uf.union(i,j); // i, j 간선이 존재한다.
                }
            }
        }

        int[] targetPath = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            targetPath[i] = Integer.parseInt(st.nextToken());
        }

        String answer = "YES";
        for (int i = 1; i < m; i++) {
            if (!uf.sameGroup(targetPath[i], targetPath[i-1])){
                answer = "NO";
                break;
            }
        }
        System.out.println(answer);

    }
}

/*

 한국에는 도시가 N개 있고 임의의 두 도시 사이에 길 존재 or 존재X
 여행 일정이 주어졌을 때, 이 여행 경로가 가능한 것인지 알아보자.

 경유 가능로 도착 해도 가능

 예를 들어 도시가 5개 있고, A,B,C,D,E
 A-B, B-C, A-D, B-D, E-A의 길이 있고,
 동혁이의 여행 계획이 E C B C D 라면 E-A-B-C-B-C-B-D라는
 여행경로를 통해 목적을 달성할 수 있다.

 도시들의 개수와 도시들 간의 연결 여부가 주어져 있고,
 동혁이의 여행 계획에 속한 도시들이 순서대로 주어졌을 때 가능한지 여부를 판별하는 프로그램을 작성하시오.
 같은 도시를 여러 번 방문하는 것도 가능하다.

 첫 줄에 도시의 수 N이 주어진다.
 N은 200이하이다.

 둘째 줄에 여행 계획에 속한 도시들의 수 M이 주어진다.
 M은 1000이하이다.

 다음 N개의 줄에는 N개의 정수가 주어진다.
 i번째 줄의 j번째 수는 i번 도시와 j번 도시의 연결 정보를 의미한다.
 1이면 연결된 것이고 0이면 연결이 되지 않은 것이다.
 A와 B가 연결되었으면 B와 A도 연결되어 있다.

 마지막 줄에는 여행 계획이 주어진다.
 도시의 번호는 1부터 N까지 차례대로 매겨져 있다.

* */
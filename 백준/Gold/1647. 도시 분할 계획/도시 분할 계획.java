// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n + 1];
            this.rank = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        public boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return false;
            if (rank[ra] > rank[rb]) {
                int tmp = ra; ra = rb; rb = tmp;
            }
            parent[rb] = ra;
            rank[rb] = rank[ra] + 1;
            return true;
        }

        public int find(int a) {
            while (parent[a] != a) {
                parent[a] = parent[parent[a]];
                a = parent[a];
            }
            return a;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int w;

        public Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.w, other.w);
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(from, to, w);
        }

        int answer = kruskal(edges);
        System.out.println(answer);

    }

    static int kruskal(Edge[] edges) {
        Arrays.sort(edges);
        UnionFind uf = new UnionFind(n);
        int result = 0;
        int maxW = Integer.MIN_VALUE;

        for (Edge edge : edges) {
            if (uf.union(edge.from, edge.to)){
                result += edge.w;
                maxW = Math.max(edge.w, maxW);
            }
        }

        int answer = result - maxW;
        return answer;
    }
}


/*

    양방향, 가중치
    최소 신장트리를 구하고 간선이 가장 긴것을 짜르기?

*/
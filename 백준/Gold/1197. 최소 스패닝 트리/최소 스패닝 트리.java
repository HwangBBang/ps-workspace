// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    static int v, e;
    static final int INF = Integer.MAX_VALUE;

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

    static class UnionFind {
        int[] parent;
        int[] size;
        int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n + 1];
            this.size = new int[n + 1];
            this.rank = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public boolean unionByRank(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return false;
            if (rank[ra] > rank[rb]){
                int tmp = ra;
                ra = rb;
                rb = tmp;
            }

            parent[rb] = ra;
            rank[rb] = rank[ra] + 1;
            return true;
        }

        public void unionBySize(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return; // 이미 같은 그룹
            if (size[ra] < size[rb]) {
                int tmp = ra; ra = rb; rb = tmp;
            }
            parent[rb] = ra;
            size[ra] += size[rb];
        }

        public int find(int a) {
            while (parent[a] != a) {
                parent[a] = parent[parent[a]];
                a = parent[a];
            }
            return a;
        }
    }
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[e];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from, to, cost);
        }

        int answer = kruskal(edges);

        System.out.println(answer);
    }

    static int kruskal(Edge[] edges) {
        Arrays.sort(edges);

        UnionFind uf = new UnionFind(v);
        int result = 0;

        for (Edge edge : edges) {
            if (uf.unionByRank(edge.from, edge.to)){
                result += edge.w;
            }

        }
        return result;
    }

    /*static int prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[v + 1];
        for(Edge adj : graph[DEFAULT_START]) pq.add(adj);
        visited[DEFAULT_START] = true;
        int result = 0;

        while (!pq.isEmpty()){
            Edge cur = pq.poll();
            if (visited[cur.to]) continue;

            result += cur.w;
            visited[cur.to] = true;
            for (Edge nxt : graph[cur.to]) {
                pq.add(nxt);
            }
        }

        return result;
    }*/
}


/*
    1. 플로이드 워셜 : 정점이 10_000 이라 메모리 초과.
    2. edge의 가중치만 최소인것을 선택
    3. 크루스칼 : 간선의 가중치 기준으로 정렬, UF 로 그룹핑
* */
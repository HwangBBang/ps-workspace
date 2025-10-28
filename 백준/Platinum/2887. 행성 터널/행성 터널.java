// package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final long INF = Long.MAX_VALUE / 4;
    private static int n;

    public static class Point {
        int idx;
        int x,y,z;

        public Point(int idx, int x, int y, int z) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static class Edge implements Comparable<Edge>{
        int from;
        int to;
        long w;

        public Edge(int from, int to, long w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Edge other) {
            return Long.compare(this.w, other.w);
        }
    }

    public static class UnionFind {
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

        public boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return false;
            if (size[ra] < size[rb]) {
                int tmp = ra; ra = rb; rb = tmp;
            }
            parent[rb] = ra;
            size[ra] += size[rb];

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
        // System.setIn(new FileInputStream("src/baekjoon/platinum/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            points[i] = new Point(i, x, y, z);
        }

        Point[] forX = new Point[n];
        Point[] forY = new Point[n];
        Point[] forZ = new Point[n];

        List<Edge> edges = new ArrayList<>();

        System.arraycopy(points, 0, forX, 0, n);
        System.arraycopy(points, 0, forY, 0, n);
        System.arraycopy(points, 0, forZ, 0, n);
        long answer = INF;

        Arrays.sort(forX, (p1, p2) -> Long.compare(p1.x, p2.x));
        Arrays.sort(forY, (p1, p2) -> Long.compare(p1.y, p2.y));
        Arrays.sort(forZ, (p1, p2) -> Long.compare(p1.z, p2.z));

        for (int i = 1; i < points.length; i++) {
            Point a = forX[i], b = forX[i - 1];
            int w = calculate(a, b);
            edges.add(new Edge(a.idx, b.idx, w));

            a = forY[i]; b = forY[i - 1];
            w = calculate(a, b);
            edges.add(new Edge(a.idx, b.idx, w));

            a = forZ[i]; b = forZ[i - 1];
            w = calculate(a, b);
            edges.add(new Edge(a.idx, b.idx, w));
        }
        answer = Math.min(answer ,kruskal(edges));

        System.out.println(answer);
    }
    static int calculate(Point a, Point b) {
        return Math.min(Math.abs(a.z - b.z), Math.min(Math.abs(a.x - b.x), Math.abs(a.y - b.y)));
    }
    private static long kruskal(List<Edge> edges) {
        long answer = 0;
        Collections.sort(edges);

        UnionFind uf = new UnionFind(n);
        for (Edge edge : edges) {
            if (uf.union(edge.from, edge.to)) {
                answer += edge.w;
            }
        }
        return answer;
    }

}

/*
    점들이 주어지고 간선길이는 직접 계산해야한다.
    특정점으로부터 여러간선중 하나를 골라가며 완성해야한다.
    직접 순회를한다면, O(n!)

    간선길이는 선택하는 정점에 따라 달라진다.
    출발지가 정해져있지 않다.
    간선이 0 or 양수이다.

    다익스트라로 풀기 위해서는 각 간선의 길이가 주어져있어야한다.
    플로이드워셜로 풀기에는 n의 값이 너무 크다.
    위상정렬로 풀기에는 전제 조건이 없다.
    크루스칼?
       1000 000 000
* */
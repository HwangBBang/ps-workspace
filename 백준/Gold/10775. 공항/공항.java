// package baekjoon.gold;

import java.io.*;
import java.util.*;


public class Main {
    static int G, P;

    static class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        public void union(int a, int b) {
            int ra = find(a), rb = find(b);
            parent[ra] = rb;
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
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        UnionFind uf = new UnionFind(G);
        int answer = 0;
        for (int i = 1; i <= P; i++) {
            int p = Integer.parseInt(br.readLine());
            int rp = uf.find(p);
            if (rp == 0) break;
            uf.union(p, rp - 1);
            answer ++;
        }

        System.out.println(answer);
    }
}


/*
    현재 방식 시간초과

    G의 대표를 선정한다. -> ? Union Find!
*/

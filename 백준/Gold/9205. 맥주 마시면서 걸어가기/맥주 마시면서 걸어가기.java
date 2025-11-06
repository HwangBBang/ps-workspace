// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int n;
    static Node[] graph;
    static String answer;

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            graph = new Node[n + 2];

            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            graph[0] =  new Node(sx, sy);


            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                graph[i] = new Node(cx, cy);
            }

            st = new StringTokenizer(br.readLine());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            graph[n + 1] = new Node(ex, ey);

            answer = "sad";

            boolean[] visited = new boolean[n + 2];
            visited[0] = true;
            simulation(0, visited);
            System.out.println(answer);
        }


    }

    static void simulation(int start, boolean[] visited) {
        if (start == n + 1) {
            answer = "happy";
            return;
        }
        for (int i = 0; i < n + 2; i++) {
            if (visited[i]) continue;
            if (getDist(graph[start], graph[i]) <= 1000) {
                visited[i] = true;
                simulation(i, visited);
            }
        }
    }

    static int getDist(Node n1, Node n2) {
        return Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);
    }
}


/*
    BFS 보단 DFS
 */
// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] grid;
    static int n;
    static Fish start;
    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};
    static final int INF = Integer.MAX_VALUE;

    static class Fish {
        int size;
        int x, y;

        public Fish(int size, int x, int y) {
            this.size = size;
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object other) {
            Fish fish = (Fish) other;
            return Objects.equals(this, fish);
        }
    }
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        grid = new int[n + 1][n + 1];

        start = null;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int size = Integer.parseInt(st.nextToken());
                if (size == 9) start = new Fish(2, i, j);
                else if (1 <= size && size <= 6){
                    grid[i][j] = size;
//                    treeSet.add(new Fish(size, i, j));
                    treeMap.put(size, treeMap.getOrDefault(size, 0) + 1);
                }

            }
        }
        int answer = 0;
        int cnt = 0;
        while (!treeMap.isEmpty()) {
            Integer find = treeMap.lowerKey(start.size);
            if (find == null) {
                break;
            }

            int result = bfs(start);
            if (result == 0) break;
            answer += result;
            cnt ++;
            if (cnt == start.size) {
                start.size += 1;
                cnt = 0;
            }
        }

        System.out.println(answer);

    }

    static int bfs(Fish start) {
        int[][] dist = new int [n + 1][n + 1];
        for (int i = 1; i <=n ; i++) Arrays.fill(dist[i],INF);
        int minDist = INF;
        Queue<Fish> que = new ArrayDeque<>();
        PriorityQueue<Fish> pq= new PriorityQueue<>((f1,f2) -> {
            if (f1.x != f2.x)
                return Integer.compare(f1.x, f2.x);
            else
                return Integer.compare(f1.y, f2.y);
        });
        dist[start.x][start.y] = 0;
        que.add(start);

        while (!que.isEmpty()) {
            Fish cur = que.poll();
            if (grid[cur.x][cur.y] != 0 && grid[cur.x][cur.y] < start.size){
                if (minDist == INF) minDist = dist[cur.x][cur.y];
                if (minDist != dist[cur.x][cur.y]) break;
                pq.add(cur);
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (outOfRange(nx,ny)) continue;
                if (dist[nx][ny] != INF) continue;
                if (grid[nx][ny] <= start.size){
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    que.add(new Fish(grid[nx][ny], nx, ny));
                }
            }
        }
        if (!pq.isEmpty()) {
            Fish cur = pq.poll();

            treeMap.put(cur.size, treeMap.get(cur.size) - 1);
            if (treeMap.get(cur.size) == 0) {
                treeMap.remove(cur.size);
            }
            grid[cur.x][cur.y] = 0;
            start.x = cur.x;
            start.y = cur.y;
        }
        return dist[start.x][start.y];
    }

    static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }
}

/*
    먹으러가야하고, 작은 것 기준으로 정렬해야하니,
    PQ 가 필요함, PQ의 요소는 좌표를 갖고 있어야함 (크기, 좌표) 크기기준 minHeap
    더이상 먹을 물고기가 없다면 끝~
    제일 가까운게 우선순위가 높다. BFS 돌아야해
*/

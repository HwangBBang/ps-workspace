// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {      //  동  북  서  남
    static int[] dx = new int[]{0, -1, 0, 1};
    static int[] dy = new int[]{1, 0, -1, 0};

    static final int INF = Integer.MAX_VALUE;

    static int w, h, answer;
    static char[][] grid;

    static class PathNode {
        int x, y;
        int d;

        public PathNode(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        grid = new char[h][w];
        List<int[]> source = new ArrayList<>();

        for (int i = 0; i < h; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                grid[i][j] = line[j];
                if (grid[i][j] == 'C') source.add(new int[]{i, j});
            }
        }
        int answer = simulation(source);

        System.out.println(answer);
    }

    static int simulation(List<int[]> source) {
        int[] start = source.get(0);
        int[] end = source.get(1);

        Deque<PathNode> que = new ArrayDeque<>();

        int[][][] dist = new int[h][w][4];
        for (int i = 0; i < h; i++){
            for (int j = 0; j < w; j++) {
                Arrays.fill(dist[i][j], INF);
            }
        }

        for (int d = 0; d < dx.length; d++) {
            dist[start[0]][start[1]][d] = 0;
            que.add(new PathNode(start[0], start[1], d));
        }

        while (!que.isEmpty()) {
            PathNode cur = que.pollFirst();
            int cx = cur.x;
            int cy = cur.y;
            int cd = cur.d;
            int cCost = dist[cx][cy][cd];

            for (int nd = 0; nd < dx.length; nd++) {
                int nx = cx + dx[nd];
                int ny = cy + dy[nd];

                if (outOfRange(nx,ny)) continue;
                if (grid[nx][ny] == '*') continue;

                boolean isChanged = nd != cd;
                int nCost = cCost + (isChanged ? 1 : 0);

                if (dist[nx][ny][nd] <= nCost) continue;
                dist[nx][ny][nd] = nCost;

                PathNode next = new PathNode(nx, ny, nd);
                if (isChanged) {
                    que.addLast(next);
                } else {
                    que.addFirst(next);
                }
            }
        }
        int result = INF;
        for (int i = 0; i < dx.length; i++) {
            result = Math.min(result, dist[end[0]][end[1]][i]);
        }
        return result;

    }




    private static boolean outOfRange(int x, int y) {
        return 0 > x || h <= x || 0 > y || w <= y;
    }
}

/*


    .: 빈 칸
    *: 벽
    C: 레이저로 연결해야 하는 칸
    'C'는 항상 두 개이고, 레이저로 연결할 수 있는 입력만 주어진다.

    방향이 바뀔 때 == 거울 설치

    1. 최단 거리 경로를 얻어 낸 후 방향이 바뀌는 지점만 카운트.
    -> 최단 거리 경로는 여러개일 수 있음 이 중에서 방향이 최소 바뀌도록해야함

    애초에 최단 거리가 아닐 수 있지 않은가?

    방향이 바뀌는것에 중점.


    . C X . * x .
    . X x x x x .



*/

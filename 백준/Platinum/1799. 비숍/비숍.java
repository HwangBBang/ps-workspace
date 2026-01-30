// package baekjoon.platinum;

import java.io.*;
import java.util.*;

public class Main {

    static final int CAN = 1;
    static final int[] dx = new int[]{1, 1, -1, -1};
    static final int[] dy = new int[]{1, -1, 1, -1};

    static int n , result;
    static int[][] grid;
    static boolean[][] placed;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/platinum/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        placed = new boolean[n][n];

        List<int[]> blacks = new ArrayList<>();
        List<int[]> whites = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == CAN) {
                    if ((i + j) % 2 == 0) {
                        whites.add(new int[]{i, j});
                    } else {
                        blacks.add(new int[]{i, j});
                    }
                }
            }
        }

        int blackCnt = getCnt(blacks);
        int whiteCnt = getCnt(whites);
        int answer = blackCnt + whiteCnt;

        System.out.println(answer);

    }
    static int getCnt(List<int[]> candidates) {
        result = 0;
        backtracking(candidates, 0, 0);
        return result ;
    }

    static void backtracking(List<int[]> candidates, int step, int cnt) {
        result = Math.max(cnt, result);
        if (candidates.size() == step) {
            return ;
        }

        backtracking(candidates, step + 1, cnt);

        int[] cur = candidates.get(step);
        int x = cur[0], y = cur[1];
        if (canPlace(x, y)) {
            placed[x][y] = true;
            backtracking(candidates, step + 1, cnt + 1);
            placed[x][y] = false;
        }
    }

    static boolean canPlace(int x, int y) {
        for (int d = 0; d < dx.length; d++) {
            int nx = x;
            int ny = y;
            while (true) {
                nx += dx[d];
                ny += dy[d];
                if (outOfRange(nx,ny)) break;
                if (placed[nx][ny]) return false;
            }
        }
        return true;
    }

    static boolean outOfRange(int x, int y) {
        return 0 > x || x >= n || 0 > y || y >= n;
    }



}

/*
    색칠된 부분은 비숍이 놓일 수 없다.
    n 은 10 이하이다.
    1은 놓을 수 있는 곳
    0은 놓을 수 없는 곳

    서로가 서로를 잡을 수 없는 위치에 놓을 수 있는 비숍의 최대 개수

    백 칸 , 흑 칸 나눠서 생각하기

    백칸 기준 , 백트래킹 

1 1 0 1 1
0 1 0 0 0
1 0 1 0 1
1 0 0 0 0
1 0 1 1 1

 (0,0) (0,1) (0,2) (0,3)
 (1,0) (1,1) (1,2) (1,3)
 (2,0) (2,1) (2,2) (2,3)
 (3,0) (3,1) (3,2) (3,3)

 대각선 상단 방향은 합이 모두 같다.
 1 + 1 == 0 + 2 == 2 + 0
 3 + 0 == 2 + 1 == 1 + 2 == 0 + 3

 대각선 하단 방향은 차가 모두 같다.
 1 - 0 == 2 - 1 == 3 - 2
 0 - 0 == 1 - 1 == 2 - 2 == 3 - 3
 2 - 0 == 3 - 1



*/
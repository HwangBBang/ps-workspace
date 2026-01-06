// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {            //
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};

    static int[][] grid;
    static boolean[][] visited;
    static int size;

    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        size = getSize(n);
        grid = new int[size + 1][size + 1];
        int[] levels = new int[q + 1];

        for (int i = 1; i <= size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= size; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= q; i++) {
            levels[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= q; i++)
            simulation(levels[i]);

        int totalIce = getTotalIce();
        int maxArea = getMaxArea();

        sb.append(totalIce).append("\n");
        sb.append(maxArea);

        System.out.println(sb);


    }

    static void simulation(int level) {
        int subSize = getSize(level);
        // 돌리기
        for (int i = 1; i <= size; i += subSize) {
            for (int j = 1; j <= size; j += subSize) {
                turn(i, j, subSize);
            }
        }
        int[][] next = new int[size + 1][size + 1];

        for (int i = 0; i <= size; i++) {
            System.arraycopy(grid[i], 0, next[i], 0, size+1);
        }

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (grid[i][j] <= 0) continue;

                int cnt = 0;
                for (int d = 0; d < dx.length; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (outOfRange(nx, ny)) continue;
                    if (grid[nx][ny] == 0) continue;
                    cnt++;
                }
                if (cnt < 3) {
                    next[i][j]--;
                }
            }
        }
        grid = next;
    }

    static void turn(int sx, int sy, int subSize) {
        int[][] temp = new int[subSize][subSize];
        for (int i = 0; i < subSize; i++) {
            for (int j = 0; j < subSize; j++) {
                temp[i][j] = grid[sx + i][sy + j];
            }
        }

        for (int i = 0; i < subSize; i++) {
            for (int j = 0; j < subSize; j++) {
                grid[sx + i][sy + j] = temp[subSize - (j + 1)][i];
            }

        }
    }

    static int getTotalIce() {
        int result = 0;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                result += grid[i][j];
            }
        }
        return result;
    }

    static int getMaxArea() {
        int answer = 0;
        visited = new boolean[size + 1][size + 1];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (visited[i][j]) continue;
                if (grid[i][j] <= 0) continue;

                int area = bfs(i, j);
                answer = Math.max(area, answer);
            }
        }
        return answer;
    }

    static int bfs(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        visited[x][y] = true;
        que.add(new int[]{x, y});
        int result = 1;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (outOfRange(nx,ny)) continue;
                if (visited[nx][ny]) continue;
                if (grid[nx][ny] <= 0) continue;

                result++;
                visited[nx][ny] = true;
                que.add(new int[]{nx, ny});
            }
        }
        return result;
    }

    static boolean outOfRange(int x, int y) {
        return x < 1 || x > size || y < 1 || y > size;
    }

    static int getSize(int k) {
        return (int) Math.pow(2, k);
    }

}

/*

    2^N

    파이어스톰은 먼저 격자를 2^L × 2^L 크기의 부분 격자로 나눈다.

    그 후, 모든 부분 격자를 시계 방향으로 90도 회전시킨다.
    이후 얼음이 있는 칸 3개 이상과 인접해있지 않은 칸은 얼음의 양이 1 줄어든다.
    (r, c)와 인접한 칸은 (r-1, c), (r+1, c), (r, c-1), (r, c+1)이다.

    아래 그림의 칸에 적힌 정수는 칸을 구분하기 위해 적은 정수이다.


    남아있는 얼음 A[r][c]의 합
    -> 걍돌기

    남아있는 얼음 중 가장 큰 덩어리가 차지하는 칸의 개수
    얼음이 있는 칸이 얼음이 있는 칸과 인접해 있으면, 두 칸을 연결되어 있다고 한다. 덩어리는 연결된 칸의 집합이다.
    -> bfs


*/

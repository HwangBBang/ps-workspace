
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C, M;
    static int[][] grid, nextGrid;
    static Shark[] sharks;
    //                      위 아래 오른 왼
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static class Shark {
        int x,y;
        int v;
        int d;
        int size;
        boolean isAlive;

        public Shark(int x, int y, int v, int d, int size, boolean isAlive) {
            this.x = x;
            this.y = y;
            this.v = v; // 속력
            this.d = d;
            this.size = size;
            this.isAlive = isAlive;
        }
    }
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sharks = new Shark[M+1];
        grid = new int[R + 1][C + 1];
        nextGrid = new int[R + 1][C + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            sharks[i] = new Shark(r, c, s, d, z, true);
            grid[r][c] = i;
        }
        int answer = simulation();
        System.out.println(answer);
    }

    private static int simulation() {
        int answer = 0;
        for (int fIdx = 1; fIdx <= C; fIdx++) {
            answer += catchShark(fIdx);
            moveShark();
        }

        return answer;
    }

    private static int catchShark(int fIdx) {
        for (int i = 1; i <= R; i++) {
            if (grid[i][fIdx] != 0 && sharks[grid[i][fIdx]].isAlive) {
                Shark shark = sharks[grid[i][fIdx]];
                shark.isAlive = false;
                grid[i][fIdx] = 0;
                return shark.size;
            }

        }
        return 0;
    }

    private static void moveShark() {
        for (int i = 0; i < nextGrid.length; i++) Arrays.fill(nextGrid[i], 0);


        for (int id = 1; id < sharks.length; id++) {
            Shark cur = sharks[id];
            if (!cur.isAlive) continue;

            int nx = cur.x, ny = cur.y, nd = cur.d;
            if (nd == 0 || nd == 1) {              // 세로 이동: x만 갱신
                nx = getR(cur.x, cur.v, nd);
                nd = nextDirRow(cur.x, cur.v, nd);
            } else {                                // 가로 이동: y만 갱신
                ny = getC(cur.y, cur.v, nd);
                nd = nextDirCol(cur.y, cur.v, nd);
            }

            if (nextGrid[nx][ny] == 0) {
                nextGrid[nx][ny] = id;
                sharks[id] = new Shark(nx, ny, cur.v, nd, cur.size, cur.isAlive);
            }
            else{
                if (sharks[nextGrid[nx][ny]].size < cur.size) { // 이미 상어가 존재할 때
                    sharks[nextGrid[nx][ny]].isAlive = false;
                    nextGrid[nx][ny] = id;
                    sharks[id] = new Shark(nx, ny, cur.v, nd, cur.size, cur.isAlive);
                } else {
                    cur.isAlive = false;
                }
            }
        }
        grid = nextGrid;
    }
    private static int getR(int x, int v, int d) {
        if (R == 1) return x;
        //      주기 : (R-1)*2
        int t = (R-1)*2;
        int base0 = x - 1;

        int tmp = Math.floorMod((base0 + dx[d] * v) , t);
        int nx = (tmp <= R-1) ? tmp : t - tmp;
        return nx + 1;
    }

    private static int getC(int y, int v, int d) {
        if (C == 1) return y;
        int t = (C-1)*2;
        int base0 = y - 1;

        int tmp = Math.floorMod((base0 + dy[d] * v), t);
        int ny = (tmp <= C-1) ? tmp : t - tmp;
        return ny + 1;

    }


    private static int nextDirRow(int x, int v, int d) { // d: 0=위, 1=아래
        if (R == 1) return d;
        int period = 2 * (R - 1);
        int step   = v % period;
        if (step == 0) return d;

        int pos0 = x - 1;
        int move = (d == 0 ? -step : step);
        int m    = Math.floorMod(pos0 + move, period);

        if (d == 1) {
            return (m < R - 1) ? 1 : 0;
        } else {
            return (m < R - 1) ? 0 : 1;
        }
    }

    private static int nextDirCol(int y, int v, int d) { // d: 2=오른쪽, 3=왼쪽
        if (C == 1) return d;
        int period = 2 * (C - 1);
        int step   = v % period;
        if (step == 0) return d;

        int pos0 = y - 1;
        int move = (d == 3 ? -step : step);
        int m    = Math.floorMod(pos0 + move, period);

        if (d == 2) {
            return (m < C - 1) ? 2 : 3;
        } else {                  
            return (m < C - 1) ? 3 : 2;
        }
    }



}

/*
r,c 위치, s는 속력, d는 이동 방향, z는 크기

0. 낚시왕 위치 (x, y)
1. 오른쪽 한칸 이동 (x, y+1)
2. (k, y+1)의 있는 상어 삭제/ k 최소
3. 상어 이동, 상어 이동후
    격자를 벗어나면 방향 반대로 이동
    한칸에 여러마리 존재한다면 => 크기가 큰놈만 생존

낚시 왕의 위치 y > c 라면 종료

*/

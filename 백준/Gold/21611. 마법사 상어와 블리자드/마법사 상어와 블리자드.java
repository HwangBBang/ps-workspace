// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {            // 위 아래 왼쪽 오른쪽
    static final int[] dx = new int[]{-1, 1, 0, 0};
    static final int[] dy = new int[]{0, 0, -1, 1};
    static final int[] order = new int[]{2, 1, 3, 0};
//    2,1,3,3,0,0,2,2,2,1,1,1,3,3,3,3

    static int n, mid, answer;
    static int[][] grid;
    static Magic[] magics;

    static class Magic {
        int d, s;

        public Magic(int d, int s) {
            this.d = d;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        mid = (n + 1) / 2;

        grid = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        magics = new Magic[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            magics[i] = new Magic(d - 1, s);
        }
        answer = 0;
        simulation();
        System.out.println(answer);
    }

    static void simulation() {
        for (Magic magic : magics) {
            // 마법
            blizzard(magic);
            while (!isFinish()) {
                sort();
            }

            // 폭발
            while (true) {
                List<int[]> result = bomb();
                if (result.isEmpty()) {
                    break;
                }
                for(int[] each : result)
                    answer += each[0] * each[1];
                while (!isFinish()) {
                    sort();
                }
            }

            // 변화
            // 연속하는 그룹의 갯수 , 구슬 번호
            /*
            2 1 1 2 1 3
            */
            List<Integer> group = getGroup();
            setGrid(group);

        }
    }

    static void setGrid(List<Integer> group) {
        grid = new int[n + 1][n + 1];
        int cnt = 0, idx = 0;
        int k = 1;

        int cx = mid, cy = mid;

        while (cnt < n*n - 1) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < k; j++) {
                    int d = order[idx % order.length];


                    int nx = cx + dx[d];
                    int ny = cy + dy[d];

                    if (outOfRange(nx,ny)) return;
                    if (cx == 1 && cy == 1) return;
                    if (group.size() <= cnt) return;

                    grid[nx][ny] = group.get(cnt);

                    cx = nx; cy = ny;
                    cnt++;
                }
                idx ++;
            }
            k ++;
        }
    }

    static List<Integer> getGroup() {
        List<Integer> result = new ArrayList<>();

        int cnt = 0, idx = 0;
        int k = 1;

        int cx = mid, cy = mid;

        boolean started = false;
        int pivot = -1;
        int run = 0;

        while (cnt < n * n - 1) {
            for (int t = 0; t < 2; t++) {
                for (int step = 0; step < k; step++) {
                    int d = order[idx % 4];
                    cnt++;

                    int nx = cx + dx[d];
                    int ny = cy + dy[d];

                    if (outOfRange(nx, ny) || (cx == 1 && cy == 1)) {
                        if (started && pivot != 0) {
                            result.add(run);
                            result.add(pivot);
                        }
                        return result;
                    }

                    int cur = grid[nx][ny];

                    if (cur == 0) {
                        if (started && pivot != 0) {
                            result.add(run);
                            result.add(pivot);
                        }
                        return result;
                    }

                    if (!started) {
                        started = true;
                        pivot = cur;
                        run = 1;
                    } else if (cur == pivot) {
                        run++;
                    } else {
                        // 이전 그룹 flush
                        result.add(run);
                        result.add(pivot);

                        // 새 그룹 시작
                        pivot = cur;
                        run = 1;
                    }

                    cx = nx; cy = ny;

                    // 변환 결과는 최대 n*n-1 칸까지만 유효 (초과하면 잘라야 함)
                    if (result.size() >= n * n - 1) return result;
                }
                idx++;
            }
            k++;
        }

        // 마지막 flush
        if (started && pivot != 0) {
            result.add(run);
            result.add(pivot);
        }
        return result;
    }

    static boolean isFinish() {
        int cnt = 0, idx = 0;
        int k = 1;

        int cx = mid, cy = mid;

        while (cnt < n*n - 1) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < k; j++) {
                    int d = order[idx % order.length];
                    cnt++;

                    int nx = cx + dx[d];
                    int ny = cy + dy[d];
                    if (outOfRange(nx,ny))break;
                    if (cx == 1 && cy == 1)break;
                    if (!(cx == mid && cy == mid)) {
                        if (grid[cx][cy] == 0 && grid[nx][ny] != 0){
                            return false;
                        }
                    }

                    cx = nx; cy = ny;
                }
                idx ++;
            }
            k ++;
        }

        return true;
    }

    static void sort() {
        int cnt = 0, idx = 0;
        int k = 1;

        int cx = mid, cy = mid;

        while (cnt < n*n - 1) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < k; j++) {
                    int d = order[idx % order.length];
                    cnt++;

                    int nx = cx + dx[d];
                    int ny = cy + dy[d];

                    if (outOfRange(nx,ny))break;
                    if (cx == 1 && cy == 1)break;

                    if (!(cx == mid && cy == mid)) {
                        if (grid[cx][cy] == 0 && grid[nx][ny] != 0){
                            grid[cx][cy] = grid[nx][ny];
                            grid[nx][ny] = 0;
                        }
                    }

                    cx = nx; cy = ny;
                }
                idx ++;
            }
            k ++;
        }
    }

    static List<int[]> bomb() {
        int cnt = 0, idx = 0;
        int k = 1;

        int pivot = -1; // default
        List<int[]> result = new ArrayList<>();

        int cx = mid, cy = mid;
        Queue<int[]> que = new ArrayDeque<>();

        boolean started = false;

        while (cnt < n*n - 1) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < k; j++) {
                    int d = order[idx % order.length];
                    cnt++;

                    int nx = cx + dx[d];
                    int ny = cy + dy[d];

                    if (outOfRange(nx, ny) || (cx == 1 && cy == 1)) {
                        if (started && pivot != 0 && que.size() >= 4) {
                            for (int[] p : que) grid[p[0]][p[1]] = 0;
                            result.add(new int[]{que.size(), pivot});
                        }
                        return result;
                    }

                    if (!started){
                        started = true;
                        pivot = grid[nx][ny];
                        if (pivot == 0) {
                            return result;
                        }
                        que.clear();
                        que.add(new int[]{nx, ny});
                    }else{
                        if (grid[nx][ny] == 0){
                            if (started && pivot != 0 && que.size() >= 4) {
                                for (int[] p : que) grid[p[0]][p[1]] = 0;
                                result.add(new int[]{que.size(), pivot});
                            }
                            return result;
                        }

                        if (grid[nx][ny] == pivot) {
                            que.add(new int[]{nx, ny});
                        }
                        else {
                            // 이전 그룹 폭발 처리
                            if (que.size() >= 4) {
                                for (int[] p : que) grid[p[0]][p[1]] = 0;
                                result.add(new int[]{que.size(), pivot});
                            }
                            // 새 그룹 시작
                            pivot = grid[nx][ny];
                            que.clear();
                            que.add(new int[]{nx, ny});
                        }
                    }
                    cx = nx; cy = ny;
                }
                idx++;
            }
            k++;
        }

        return result;
    }

    static void blizzard(Magic magic) {
        int cx = mid, cy = mid;
        for (int i = 1; i <= magic.s; i++) {
            int nx = cx + dx[magic.d];
            int ny = cy + dy[magic.d];
            if (outOfRange(nx, ny)) break;

            grid[nx][ny] = 0;
            cx = nx; cy = ny;
        }
    }

    static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }
}


/*
    n 은 홀수
    마법사는 (n+1)/2 , (n+1)/2 에있음 정중앙
    마법사는 움직이지 않고 마법을 갈김

    칸의 번호 != 구슬 번호

    블리자드 -> 구슬을 없애는 것
    폭발후 당기기 (바로 직전 칸이 빈칸이라면 => 직전칸으로 구슬을 이동)

    더 폭발 안할때까지 반복{
        구슬 폭발 -> 4개 이상의 같은 구슬이 존재한다면 파괴
        폭발후 당기기 (바로 직전 칸이 빈칸이라면 => 직전칸으로 구슬을 이동)
    }



 */
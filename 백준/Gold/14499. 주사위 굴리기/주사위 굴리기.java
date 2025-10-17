import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[][] grid;
    static int n, m;
    static StringBuilder answer;
    static int[] dice;
                                   //널 동 서 북
    static final int[] dx = new int[]{0, 0, 0, -1, 1};
    static final int[] dy = new int[]{0, 1, -1, 0, 0};
    static final int BUTTOM = 1, TOP = 6;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] cmds = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            cmds[i] = Integer.parseInt(st.nextToken());
        }

        answer = new StringBuilder();
        dice = new int[7];
        simulation(x, y, cmds);
        System.out.println(answer);
    }

    static void simulation(int x, int y, int[] cmds) {
        for (int cmd : cmds) {
            int nx = x + dx[cmd];
            int ny = y + dy[cmd];
            if (outOfRange(nx,ny)) continue;

            if (cmd == 1) rollE(); // E
            else if (cmd == 2) rollW(); // W
            else if (cmd == 3) rollN(); // N
            else if (cmd == 4) rollS(); // S

            if (grid[nx][ny] == 0) {
                grid[nx][ny] = dice[BUTTOM];
            } else {
                dice[BUTTOM] = grid[nx][ny];
                grid[nx][ny] = 0;
            }
            answer.append(dice[TOP]).append("\n");
            x = nx; y = ny;
        }
    }

    static void rollE() {
        int t = dice[1];
        dice[1] = dice[3];
        dice[3] = dice[6];
        dice[6] = dice[4];
        dice[4] = t;
    }

    // 서쪽
    static void rollW() {
        int t = dice[1];
        dice[1] = dice[4];
        dice[4] = dice[6];
        dice[6] = dice[3];
        dice[3] = t;
    }

    // 북쪽
    static void rollN() {
        int t = dice[1];
        dice[1] = dice[2];
        dice[2] = dice[6];
        dice[6] = dice[5];
        dice[5] = t;
    }

    // 남쪽
    static void rollS() {
        int t = dice[1];
        dice[1] = dice[5];
        dice[5] = dice[6];
        dice[6] = dice[2];
        dice[2] = t;
    }

    static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

}


/*
    init : 주사위 모든 칸 0
    바닥 idx 1
    동쪽 idx 3
    서쪽 idx 4
    북쪽 idx 2
    남쪽 idx 5
    천장 idx 6
    돌리는 주사위 사이클 2개
      바 동 천 서     바 남 천 북
      [1,3,6,4]    [1,5,6,2]

 cmd 동|서
     [1,3,6,4] 동
     [4,1,3,6]
     [1,3,6,4] 서
 cmd 남|북
     [1,5,6,2] 남
     [1,5,6,2] 북

    주사위의 값은 사이클 단위로 회전하기에 Map (변하지않는 2놈 때매, deque 안씀)
    칸에는 숫자가 기입되어있고
    if 주사위가 굴렀을 때 칸의 숫자 == 0
        해당 칸 = 주사위[idx=1] 의 값
    else
        주사위[idx=1] = 해당 칸의 값

    iter cmds
        if (outOfRange()) continue;

        print(주사위[idx=6])

*/

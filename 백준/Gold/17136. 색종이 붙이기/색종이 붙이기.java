// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
    static final int SIZE = 10;
    static final int INF = Integer.MAX_VALUE;

    static int answer = INF;
    static int[][] grid = new int[SIZE][SIZE];;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static {
        for (int i = 1; i <= 5; i++) map.put(i, 5);
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0);
        answer = answer == INF ? -1 : answer;
        System.out.println(answer);
    }

    static void backtracking(int used) { // used : 선택
        // 성공했다면?(1을 못찾는 다면) 갱신
        // 성공했다

        int[] start = findPos(); // null 이라면 성공
        if (start == null) {
            answer = Math.min(used, answer);
            return;
        }
        // 끝나지 않았다.
        int x = start[0], y = start[1];

        for (int size = 5; size >= 1; size--) {
            if (isValid(x, y, size)) {
                replace(x, y, size, 0);
                map.put(size, map.get(size) - 1);

                backtracking(used + 1);

                replace(x, y, size, 1);
                map.put(size, map.get(size) + 1);
            }
        }

    }


    static void replace(int x, int y, int size, int value) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[x + i][y + j] = value;
            }
        }
    }

    static boolean isValid(int x, int y, int size) {
        if (map.get(size) <= 0) return false;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (outOfRange(x + i,y + j)) return false;
                if (grid[x + i][y + j] == 0) return false;
            }
        }
        return true;
    }

    static boolean outOfRange(int x, int y) {
        return x < 0 || x >= SIZE || y < 0 || y >= SIZE;
    }

    static int[] findPos() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == 1) return new int[]{i, j};
            }
        }
        return null;
    }

}


/*


0 0 0 0 0 0 0 0 0 0
0 [1 1] 0 0 0 0 0 0 0
0 [1 1] [1] 0 0 0 0 0 0
0 0 [1] [1 1] [1 1] 0 0 0
0 0 0 [1 1] [1 1] 0 0 0
0 0 0 0 [1] [1] [1] 0 0 0
0 0 [1] 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0

격자 순으로 사이즈를 덮는 것은 정답을 보장하지 못해.

0 0 0 0 0 0 0 0 0 0
0 # # 0 0 0 0 0 0 0
0 # # 1 0 0 0 0 0 0
0 0 1 1 # # # 0 0 0
0 0 0 1 # # # 0 0 0
0 0 0 0 # # # 0 0 0
0 0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0

1짜리는 마지막에 처리하고,
큰 종이를 담을 수 있는 영역을 먼저 찾아

* 반례
0 0 0 0 0 0 0 0 0 0
1 0 0 0 0 0 0 0 1 0
0 0 0 0 0 0 0 0 0 0
0 0 0 # # # # # 1 0
0 0 0 # # # # # 1 0
0 0 0 # # # # # 1 0
0 0 0 # # # # # 1 0
0 0 0 # # # # # 1 0
0 0 0 1 1 1 1 1 1 0
0 0 0 0 0 0 0 0 0 0
-> 불가

0 0 0 0 0 0 0 0 0 0
1 0 0 0 0 0 0 0 1 0
0 0 0 0 0 0 0 0 0 0
0 0 0 # # # @ @ @ 0
0 0 0 # # # @ @ @ 0
0 0 0 # # # @ @ @ 0
0 0 0 @ @ @ # # # 0
0 0 0 @ @ @ # # # 0
0 0 0 @ @ @ # # # 0
0 0 0 0 0 0 0 0 0 0
-> 가능

그럼 백트랙킹이 들어가야하나?
뭐에 대해서, 백트랙킹해야하지?
붙인다 | 안붙인다.



 */
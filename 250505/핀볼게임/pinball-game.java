import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n , answer;
    static int[][] grid;
    static int[] dx = {0, 1, 0, -1}; // 동 남 서 북
    static int[] dy = {1, 0, -1, 0};
    static List<Integer> queue;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        answer = 0;
        n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int ii = 0; ii < n; ii++) {
                grid[i][ii] = Integer.parseInt(st.nextToken());
            }
        }
//      1. 각 측면 출발 기준으로 (단, 4방향 다 필요 없음 -> 대칭)
//  대칭 아니였음 . 무조건 해봐야해..

        for (int i = 0; i < n; i++) {
//          TODO : 동쪽으로 | default d index : 0
            answer = Math.max(answer, start(i, 0, 0));
            answer = Math.max(answer, start(0, i, 1));
            answer = Math.max(answer, start(i, n - 1, 2));
            answer = Math.max(answer, start(n - 1, i, 3));
        }

        for (int i = 0; i < n; i++) {
//          TODO : 남쪽으로 | default d index : 1
            
        }


        System.out.println(answer);

    }

/*
 동0 남1 서2 북3

  / 인 경우
 동0 -> 북3
 서2 -> 남1
 남1 -> 서2
 북3 -> 동0

  \ 인 경우
 동 -> 북3 -> 남1
 서 -> 남1 -> 북3
 남 -> 서2 -> 동2
 북 -> 동0 -> 서0
*/
    static int start(int row, int col, int directIdx) {
        int time = 0;
        int nr = row, nc = col;
        while (true) {
            time++;
            if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                break;
            }
            if (grid[nr][nc] == 1) { // 1 은 /
                directIdx = (3 - directIdx) % 4;
            }

            if (grid[nr][nc] == 2) { // 2 은 \
                directIdx = (2 + ((3 - directIdx) % 4)) % 4 ;
            }
            nr = nr + dx[directIdx];
            nc = nc + dy[directIdx];
        }
        return time;
    }

//    static void printOneline(List<Integer> line){
//        for (Integer elem : line) {
//            System.out.print(elem + " ");
//        }
//        System.out.println();
//    }
}

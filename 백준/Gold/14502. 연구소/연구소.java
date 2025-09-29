import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static Queue<Pair> start, originalStart;
    static List<Pair> candidate;
    static List<Pair> temp = new ArrayList<>();
    static int[][] grid, original;

    static final int HOLE = 0;
    static final int WALL = 1;
    static final int VIRUS = 2;
    static int n, m, answer;
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        start = new ArrayDeque<>();
        candidate = new ArrayList<>();
        answer = 0;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == VIRUS) start.add(new Pair(i, j));
                else if (grid[i][j] == HOLE) candidate.add(new Pair(i, j));

            }
        }

        original = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(grid[i], 0, original[i], 0, m);
        }
        originalStart = new ArrayDeque<>(start);

        // 백트랙킹으로 격자위에 벽 3개 고르기 (중복 허용 X)
        backtracking(0,0);


        System.out.println(answer);
    }

    public static void backtracking(int step, int startIdx){
        if (step == 3) {

            for (Pair pair : temp) grid[pair.x][pair.y] = WALL;

            answer = Math.max(answer,simulation());

            for (int i = 0; i < n; i++) System.arraycopy(original[i], 0, grid[i], 0, m);
            start = new ArrayDeque<>(originalStart);
            return;
        }


        for (int i = startIdx; i < candidate.size(); i++) {
            temp.add(candidate.get(i));
            backtracking(step + 1, i + 1);
            temp.remove(temp.size()-1);
        }

    }

    public static int simulation(){
        while (!start.isEmpty()){
            Pair poll = start.poll();

            for (int i = 0; i < dx.length; i ++){
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (grid[nx][ny] == WALL || grid[nx][ny] == VIRUS) continue;

                grid[nx][ny] = VIRUS;
                start.add(new Pair(nx, ny));
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == HOLE) cnt ++;
            }
        }
        return cnt;
    }

}
/*
* 그리드 사이즈는 8x8 이하로 작음
* 빈칸 : 0     / 빈칸은 3 ~ 개
* 벽 : 1
* 바이러스 : 2  / 바이러스는 2 ~ 10 개
*
* 바이러스는 인접 4개의 방향으로 확산
* 추가로 벽 3개 세워야함

 바이러스 시뮬은 queue 에 넣고 bfs 돌리면 됨
 벽을 세우는게 문제인데, 격자위에 3개의 점을 어떻게 선정할까?
 백트랙킹 말고는 답이 없어보임.

 그럼 격자들을 선택했을 때 마다 바이러스 시뮬레이션을 돌리고, WHOLE 의 갯수를 센다?

 시간과 메모리가 문제없을까?
 격자 사이즈가 워낙 작으니 문제가 없을 것 같음
 => 내가 정량적인 시간 복잡도와 공간 복잡도를 산정 못하네 (공부하기)


2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0

* 막음 *
2 1 0 0 1 1 2
1 0 1 0 1 2 2
0 1 1 0 1 2 2
0 1 0 0 0 1 2
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0




0 0 0 0 0 0
1 0 0 0 0 2
1 1 1 0 0 2
0 0 0 0 0 2

* 막음 *
0 0 0 0 1 0
1 0 0 1 0 2
1 1 1 0 0 2
0 0 0 1 0 2


2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0

* 막음 *
2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 1
2 2 2 2 2 2 1 0
2 2 2 2 2 1 0 0

*/
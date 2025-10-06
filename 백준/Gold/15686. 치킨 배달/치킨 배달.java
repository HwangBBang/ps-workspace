import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static int n, m, answer;

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x; this.y = y;
        }
    }
    static int[][] grid, dist;
    static final int HOUSE = 1;
    static final int STORE = 2;
    static List<Pos> result;
    static List<Pos> houses;
    static List<Pos> stores;

    public static void main(String[] args) throws IOException{
        //System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n + 1][n + 1];
        houses = new ArrayList<>();
        stores = new ArrayList<>();
        result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == HOUSE) houses.add(new Pos(i, j));
                else if (grid[i][j] == STORE) stores.add(new Pos(i, j));
            }
        }

        int h = houses.size();
        int s = stores.size();
        dist = new int[h][s];
        for (int i = 0; i < h; i++) {
            Pos eachH = houses.get(i);
            for (int j = 0; j < s; j++) {
                Pos eachS = stores.get(j);
                dist[i][j] = getDist(eachH, eachS);
            }
        }

        answer = Integer.MAX_VALUE;
        choice(0, 0);
        System.out.println(answer);
    }

    public static void choice(int depth, int start) {
        if (m <= depth) {
            int sum = 0;
            for (Pos h : houses) {
                int best = Integer.MAX_VALUE;
                for (Pos s : result) {
                    best = Math.min(best, getDist(h, s));
                }
                sum += best;
                if (sum >= answer) return; // 가지치기
            }
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = start; i < stores.size(); i++) {
            result.add(stores.get(i));
            choice(depth + 1, i + 1);
            result.remove(result.size() - 1);
        }
    }


    private static int getDist(Pos A, Pos B) {
        return Math.abs(A.x - B.x) + Math.abs(A.y - B.y);
    }
}

/*
    0은 빈 칸, 1은 집, 2는 치킨집
    "치킨 거리" 는 "집"과 가장 가까운 "치킨집" 사이의 거리

1. 격자의 외부, 내부 판단
2. 외부 인칸이 2칸 이상이라면, 삭제
3. 외부인칸 판단 방법은 0,0에서 BFS 돌리자. ( 가장자리에는 치즈가 놓이지 않는 것으로 가정하기에 )
*/

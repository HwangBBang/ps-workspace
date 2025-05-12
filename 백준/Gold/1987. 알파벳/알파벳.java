import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int r,c,maxDepth;
    static char[][] grid;
    static boolean[][] v;
    static Set<Character> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        grid = new char[r][c];
        v = new boolean[r][c];

        for (int i = 0; i < r; i ++){
            grid[i] = br.readLine().toCharArray();
        }

        answer = new HashSet<>();

        answer.add(grid[0][0]);
        v[0][0] = true;
        start(0,0,1);

        System.out.println(maxDepth);
    }

    static void start(int x, int y,int depth){
        maxDepth = Math.max(maxDepth, depth);

        for (int i = 0; i < 4; i ++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isNotRange(nx,ny)) continue;
            if(v[nx][ny]) continue;
            if(answer.contains(grid[nx][ny])) continue;

            answer.add(grid[nx][ny]);
            v[nx][ny] = true;
            start(nx,ny, depth + 1);
            v[nx][ny] = false;
            answer.remove(grid[nx][ny]);
        }
    }

    static boolean isNotRange(int x, int y){
        return x < 0 || x >= r || y < 0 || y >= c ;
    }
}


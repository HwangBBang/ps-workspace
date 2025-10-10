import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/beakjun/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[][] canvas = new boolean[100 + 1][100 + 1];

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int t = 0; t < n; t++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            for (int i = sx; i < sx + 10; i++) {
                for (int j = sy; j < sy + 10 ; j++) {
                    if (canvas[i][j]) continue;
                    canvas[i][j] = true;
                    answer ++;
                }
            }
        }
        System.out.println(answer);
    }
}

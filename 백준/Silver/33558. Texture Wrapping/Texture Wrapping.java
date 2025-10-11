
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/beakjun/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] grid = new char[n][m];

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());


        char[][] texture = new char[u][v];
        for (int i = 0; i < u; i++) {
            texture[i] = br.readLine().toCharArray();
        }
        String cmd = br.readLine();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = 0, y = 0;
                if (cmd.equals("clamp-to-edge")) {
                    x = clamp(i, u);
                    y = clamp(j, v);
                } else if (cmd.equals("repeat")) {
                    x = reapt(i, u);
                    y = reapt(j, v);
                } else if (cmd.equals("mirrored-repeat")) {
                    x = mirroredRepeat(i, u);
                    y = mirroredRepeat(j, v);
                }
                grid[i][j] = texture[x][y];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }

    }

    private static int clamp(int x, int size) {
        return x < size ? x : size - 1;
    }
    private static int reapt(int x, int size) {
        return x % size;
    }
    private static int mirroredRepeat(int x, int size) {
        int p = x % (2 * size);
        if (p < size) return p;
        else return (2*size - 1 - p);

    }

}

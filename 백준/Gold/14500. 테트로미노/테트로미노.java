
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] grid;

    static final int[] type1_1Dx = {0, 0, 0, 0}, type1_1Dy = {0, 1, 2, 3};
    static final int[] type1_2Dx = {0, 1, 2, 3}, type1_2Dy = {0, 0, 0, 0};

    static final int[] type2Dx = {0, 0, 1, 1}, type2Dy = {0, 1, 0, 1};

    static final int[] type3_1Dx = {0, 1, 2, 2}, type3_1Dy = {0, 0, 0, 1};
    static final int[] type3_2Dx = {0, 0, 0, 1}, type3_2Dy = {0, 1, 2, 0};
    static final int[] type3_3Dx = {0, 0, 1, 2}, type3_3Dy = {0, 1, 1, 1};
    static final int[] type3_4Dx = {0, 1, 1, 1}, type3_4Dy = {2, 0, 1, 2};
    static final int[] type3_5Dx = {0, 1, 2, 2}, type3_5Dy = {1, 1, 1, 0};
    static final int[] type3_6Dx = {0, 0, 0, 1}, type3_6Dy = {0, 1, 2, 2};
    static final int[] type3_7Dx = {0, 1, 2, 0}, type3_7Dy = {0, 0, 0, 1};
    static final int[] type3_8Dx = {0, 1, 1, 1}, type3_8Dy = {0, 0, 1, 2};


    static final int[] type4_1Dx = {0, 0, 1, 1}, type4_1Dy = {1, 2, 0, 1};
    static final int[] type4_2Dx = {0, 1, 1, 2}, type4_2Dy = {0, 0, 1, 1};
    static final int[] type4_3Dx = {0, 0, 1, 1}, type4_3Dy = {0, 1, 1, 2};
    static final int[] type4_4Dx = {0, 1, 1, 2}, type4_4Dy = {1, 0, 1, 0};


    static final int[] type5_1Dx = {0, 0, 0, 1}, type5_1Dy = {0, 1, 2, 1};
    static final int[] type5_2Dx = {0, 1, 1, 1}, type5_2Dy = {1, 0, 1, 2};
    static final int[] type5_3Dx = {0, 1, 2, 1}, type5_3Dy = {1, 1, 1, 0};
    static final int[] type5_4Dx = {0, 1, 2, 1}, type5_4Dy = {0, 0, 0, 1};

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(simulation());
    }

    static int simulation() {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                result = Math.max(result, getSum(i, j, type1_1Dx, type1_1Dy));
                result = Math.max(result, getSum(i, j, type1_2Dx, type1_2Dy));
                result = Math.max(result, getSum(i, j, type2Dx, type2Dy));

                result = Math.max(result, getSum(i, j, type3_1Dx, type3_1Dy));
                result = Math.max(result, getSum(i, j, type3_2Dx, type3_2Dy));
                result = Math.max(result, getSum(i, j, type3_3Dx, type3_3Dy));
                result = Math.max(result, getSum(i, j, type3_4Dx, type3_4Dy));
                result = Math.max(result, getSum(i, j, type3_5Dx, type3_5Dy));
                result = Math.max(result, getSum(i, j, type3_6Dx, type3_6Dy));
                result = Math.max(result, getSum(i, j, type3_7Dx, type3_7Dy));
                result = Math.max(result, getSum(i, j, type3_8Dx, type3_8Dy));

                result = Math.max(result, getSum(i, j, type4_1Dx, type4_1Dy));
                result = Math.max(result, getSum(i, j, type4_2Dx, type4_2Dy));
                result = Math.max(result, getSum(i, j, type4_3Dx, type4_3Dy));
                result = Math.max(result, getSum(i, j, type4_4Dx, type4_4Dy));

                result = Math.max(result, getSum(i, j, type5_1Dx, type5_1Dy));
                result = Math.max(result, getSum(i, j, type5_2Dx, type5_2Dy));
                result = Math.max(result, getSum(i, j, type5_3Dx, type5_3Dy));
                result = Math.max(result, getSum(i, j, type5_4Dx, type5_4Dy));

            }
        }
        return result;
    }

    static int getSum(int sx, int sy, int[] dx, int[] dy) {

        int tmp = 0;
        for (int k = 0; k < 4; k++) {
            int nx = sx + dx[k];
            int ny = sy + dy[k];

            if (outOfRange(nx, ny)) return 0;
            tmp += grid[nx][ny];
        }
        return tmp;
    }
    static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > m;
    }
}

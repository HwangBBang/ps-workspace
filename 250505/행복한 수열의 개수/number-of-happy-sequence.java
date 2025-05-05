import java.io.*;
  
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            String [] line = br.readLine().split(" ");
            for (int ii = 0; ii < n; ii++) {
                grid[i][ii] = Integer.parseInt(line[ii]);
            }
        }

        int result = 0;


        // 가로 검사
        for (int i = 0; i < n; i++) {
            if (isHappySeq(grid[i],m)){
                result++;
            }
        }

        // 세로 검사

        for (int i = 0; i < n; i++) {
            int[] temp = new int[n];
            for (int ii = 0; ii < n; ii++) {
                temp[ii] = grid[ii][i];
            }
            if (isHappySeq(temp, m)) {
                result++;
            }
        }

        System.out.printf("" + result);

    }

   public static boolean isHappySeq(int[] seq, int m) {
        int cnt = 1;
        int maxCnt = 1;
        for (int i = 1; i < seq.length; i++) {
            if (seq[i] == seq[i - 1]) {
                cnt ++ ;
                maxCnt = Math.max(maxCnt, cnt);
                continue;
            }
            cnt = 1;
        }

        if (maxCnt >= m) {
            return true;
        }
        return false;
    }
}




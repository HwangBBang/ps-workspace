import java.io.*;
import java.util.*;

public class Main {
        static int n, answer = 0;
    static int [][]grid;
    static int[][] temp;
    static final int[] dx = {0, 1, 0, -1}; // 동 남 서 북
    static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int ii = 0; ii < n; ii++) {
                grid[i][ii] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int ii = 0; ii < n; ii++) {
                deepCopyForTemp();
                crash(i,ii);
                restruct();
                answer = Math.max(answer, getPairCount());
            }
        }

        System.out.println(answer);
    }
    static void deepCopyForTemp(){
        temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            temp[i] = grid[i].clone();
        }
    }
    static void crash(int i, int ii){
        int size = temp[i][ii]-1;

        int nxStartIdx = i;
        int nxEndIdx = i;

        int nyStartIdx = ii;
        int nyEndIdx = ii;

        for (int k = 0; k < dx.length; k++) {
            int nx = i + dx[k] * size;
            int ny = ii + dy[k] * size;

            nxStartIdx = Math.max(0, Math.min(nxStartIdx, nx));
            nxEndIdx = Math.min(n - 1, Math.max(nxEndIdx, nx));

            nyStartIdx = Math.max(0, Math.min(nyStartIdx, ny));;
            nyEndIdx = Math.min(n - 1, Math.max(nyEndIdx, ny));
        }

        for (int j = nxStartIdx; j <= nxEndIdx; j++) {
            temp[j][ii] = 0;
        }
        for (int j = nyStartIdx; j <=  nyEndIdx; j++) {
            temp[i][j] = 0;
        }
    }

    static void restruct() {
        for (int col = 0; col < n; col++) {
            int writeRow = n - 1;              // “채워넣기” 포인터: 맨 아래부터
            // 1) 아래 행부터 위로 올라가며 0이 아닌 숫자를 writeRow 위치로 복사
            for (int row = n - 1; row >= 0; row--) {
                if (temp[row][col] != 0) {
                    temp[writeRow--][col] = temp[row][col];
                }
            }
            // 2) 남은 윗칸(writeRow 이하)은 전부 0으로 채우기
            for (int row = writeRow; row >= 0; row--) {
                temp[row][col] = 0;
            }
        }
    }

    static int getPairCount(){
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int ii = 0; ii < n; ii++) {
                if (ii + 1 >= n || temp[i][ii] == 0 || temp[i][ii + 1] == 0) continue;
                if (temp[i][ii] == temp[i][ii + 1]) count++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int ii = 0; ii < n; ii++) {
                if (i + 1 >= n || temp[i][ii] == 0 || temp[i + 1][ii] == 0) continue;
                if (temp[i][ii] == temp[i + 1][ii]) count++;
            }
        }
        return count;
    }
}
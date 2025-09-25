import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine().trim());
        int[][] grid = new int[n+1][n+1];

        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }
            

        int result = Integer.MIN_VALUE;

        int[] zipGrid = new int[n+1];
        for (int t = 1; t <= n; t++){
            Arrays.fill(zipGrid,0);
            for (int b = t; b <= n; b++){
                for (int c = 1; c <= n; c++){
                    zipGrid[c] += grid[b][c];
                }
                int maxPrefixSum = zipGrid[1];
                int candidate = zipGrid[1];
                 for (int c = 2; c <= n; c++) {
                    maxPrefixSum = (maxPrefixSum > 0) ? (maxPrefixSum + zipGrid[c]) : zipGrid[c];
                    if (candidate < maxPrefixSum) candidate = maxPrefixSum;
                }
                result = Math.max(result, candidate);
            }
        }

        System.out.println(result);
    }
}

/*
300*300 => 90_000 
90_000 * 1000 => 90_000_000 -> int 

300*300*300 => 27_000_000
정답을 찾으려면 4차원 순회.. 밖에.. 생각이 안나,, 이게 맞을까? 

변인이 4개.. 가로, 세로, 종료 인덱스 x, 종료 인덱스 y 

2차원 누적합으로 만들면 4뎁스 순회 -> 폐기

2차원 -> 1차원으로 압축 -> 누적합 
어떻게 압축하냐 행 or 열 중 하나를 고정해서 압축하자. 

행을 고정한다고 했을때 2뎁스 순회 * 1차원 누적합 1댑스 순회 

*/
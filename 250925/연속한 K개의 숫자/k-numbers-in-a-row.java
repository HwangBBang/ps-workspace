import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] missingNumbers = new int[b];
        for (int i = 0; i < b; i++) {
            missingNumbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(missingNumbers);
        boolean[] nums = new boolean[n+1];
        Arrays.fill(nums, true);

        for (int i = 0; i < b; i++){
            nums[missingNumbers[i]] = false;
        }

        int[] prefixCnt = new int [n+1];
        for (int i = 1; i <= n ; i++){
            int next = nums[i] ? 1 : 0;
            prefixCnt[i] = prefixCnt[i-1] + next;

        }

        int result = Integer.MAX_VALUE;

        for (int i = k; i <= n ; i++){
            int candidate = k - (prefixCnt[i] - prefixCnt[i-k]);
            // System.out.println( prefixCnt[i] +"("+i+")"+ "-" + prefixCnt[i-k]+"("+(i-k)+")"+"="+ candidate);

            result = Math.min(result, candidate);
        }
        System.out.println(result);
    }
}

/*
n <= 100_000 -> max 는 nlog(n)

n = 10 ,B = 5
1 2 3 4 5 6 7 8 9 10
    3 4   6 7 8    

5 개 빠져있음 

1~N 구간에서 k개의 연속구간을 잡았을 때 빠진놈이 가장 적은 녀석을 찾자.

연속인 수를 기록해야할까..? 
*/
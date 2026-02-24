import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());

        long max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            if (arr[i] > max) max = arr[i];
        }

        long lo = 1, hi = max;
        long answer = 0;

        while (lo <= hi) {
            long mid = (lo + hi) / 2 ;
            long cnt = 0;

            for (int i = 0; i < n; i++) {
                cnt += (arr[i] / mid);
                if (cnt >= m) break;
            }

            if (cnt >= m) { // 가능
                answer = mid;
                lo = mid + 1;

            } else { // 불가능
                hi = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long total = arr[n-1];
        double maxAvg = -1;
        
        pq.add(arr[n-1]);
        for(int i = 2; i < n-1; i++){ 
            pq.add(arr[n-i]);
            total += arr[n-i];

            double candidate = (double)(total-pq.peek()) / (pq.size() -1);

            maxAvg = Math.max(maxAvg, candidate);
        }

        System.out.printf("%.2f", maxAvg);
            
        /*
        n 번 돌면서 제거 -> nlog(n)
        */
    }
}


// 작은 거 k + 1 개 삭제 t 개 
// t 2 ~ n -1

// k 1 ~ n -2
import java.util.*;

public class Main {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        long total = 0;

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
            pq.add(arr[i]);
        }

        double maxAvg = -1;
        
        

        for(int t = 2; t <= n-1; t++){ 
            total -= pq.poll();
            double candidate = (double)(total) / (n - t);
            
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
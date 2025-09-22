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
        
        total -= pq.poll();
        int pqSize = n-1;


        for(int i = 1; i < n-2; i++){ 
            total -= pq.poll();
            double candidate = (double)(total) / (pqSize -i);
            
            maxAvg = Math.max(maxAvg, candidate);
        }

        System.out.printf("%.2f", maxAvg);
            
        /*
        n 번 돌면서 제거 -> nlog(n)
        */
    }
}
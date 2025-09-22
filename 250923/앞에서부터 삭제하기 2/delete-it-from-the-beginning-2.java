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

        double maxAvg = (double)total/n;
        

        int pqSize = n;
        for(int i = 1; i < n-1; i++){
            int polled = pq.poll();
            total -= polled;
            double candidate = (double)(total) / (pqSize -i);
            
            maxAvg = Math.max(maxAvg, candidate);
        }

        System.out.printf("%.2f", maxAvg);
            
        /*
        n 번 돌면서 제거 -> nlog(n)
        */
    }
}
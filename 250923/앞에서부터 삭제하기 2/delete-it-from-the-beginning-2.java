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
        
        // 첫 번째 제거 (k=1인 경우)
        int remaining = n ;

        // k=1부터 k=n-2까지 모든 경우 고려
        for(int k = 1; k <= n-2; k++){ 
            if (k > 1) {
                total -= pq.poll();
                remaining--;
            }
            
            // 현재 남은 원소들에서 최솟값 제거한 평균 계산
            double candidate = (double)(total - pq.peek()) / (remaining - 1);
            maxAvg = Math.max(maxAvg, candidate);
        }

        System.out.printf("%.2f", maxAvg);
    }
}
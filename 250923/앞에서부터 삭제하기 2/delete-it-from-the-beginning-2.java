import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        double maxAvg = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // k=1부터 k=n-2까지 모든 경우 확인
        for(int k = 1; k <= n-2; k++) {
            pq.clear();
            long sum = 0;
            
            // 뒤의 n-k개 원소를 pq에 추가
            for(int i = k; i < n; i++) {
                pq.add(arr[i]);
                sum += arr[i];
            }
            
            // 최솟값 제거한 평균 계산
            double avg = (double)(sum - pq.peek()) / (n - k - 1);
            maxAvg = Math.max(maxAvg, avg);
        }
        
        System.out.printf("%.2f", maxAvg);
    }
}
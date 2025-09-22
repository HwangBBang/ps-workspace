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
            pq.add(arr[i]);
            total += arr[i];
        }

        double maxAvg = -1;
        
        for(int k = 1; k < n-1; k++){ 
            pq.remove(arr[k-1]);
            total -= arr[k-1];
            Integer minValue = pq.peek();
            double candidate = (double)(total - minValue) / (n - k - 1);
            
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
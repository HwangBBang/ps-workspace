import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] nums = new int[N];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
            pq.add(nums[i]);
        }   
        for (int i = 0; i < M; i++) {
            int polled = pq.poll(); 
            pq.add(polled-1);
        }

        System.out.println(pq.peek());
    }
}
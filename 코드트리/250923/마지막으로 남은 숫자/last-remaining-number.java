import java.util.*;


public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }
        
        while (pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();

            int result = Math.abs(first-second);
            if (result != 0) pq.add(result);
        }

        int answer = pq.isEmpty() ? -1 : pq.poll();
        
        System.out.println(answer);
    }
}
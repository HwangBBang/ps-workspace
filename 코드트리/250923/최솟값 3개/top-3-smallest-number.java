import java.util.*;
public class Main {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(3,
        (a,b) -> Integer.compare(b,a));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        long answer ;
        for (int i = 0; i < N; i++) {
            answer = 1;
            arr[i] = sc.nextInt();
            
            if (pq.size() < 3) pq.add(arr[i]);
            else {
                if (arr[i] < pq.peek()){
                    pq.poll(); 
                    pq.add(arr[i]);
                }
            }
            if (pq.size() < 3){
                System.out.println(answer * -1);
            }else{
                for (Integer elem : pq) answer *= elem;
                System.out.println(answer);
            }
            
        }
    }
}
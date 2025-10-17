import java.util.*;

public class Main {
    public static void main(String[] args) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        Scanner sc = new Scanner(System.in);
        StringBuilder sb; 
        int t = sc.nextInt();
        while(t-- > 0) {
            int m = sc.nextInt();
            sb = new StringBuilder();
            for(int i = 1; i <= m; i++){
                int num = sc.nextInt();
                
                int maxSize = maxHeap.size();
                int minSize = minHeap.size();
/*
maxheap | minheap
    (7) |
    ---------
    (7) | (6)
    ---------
    (5, 7) | (6) 
    ---------
7 6 5 4 3 2 1

    (1) | 
    (1) | (2)
    (1,3) | (2)

*/
                // 추가 
                if (maxSize - minSize == 1){
                    minHeap.add(num);
                } else if (maxSize - minSize == 0){
                    maxHeap.add(num);
                } else if (maxSize - minSize == -1){
                    maxHeap.add(num);
                }

                while(!maxHeap.isEmpty() && !minHeap.isEmpty()){
                    if (maxHeap.peek() <= minHeap.peek()) break;
                    int maxPolled = maxHeap.poll(); 
                    int minPolled = minHeap.poll();
                    maxHeap.add(minPolled);
                    minHeap.add(maxPolled);
                }

                // 중앙값
                if (i % 2 == 1){
                    sb = sb.append(maxHeap.peek()).append(" ");
                }
            }
                
            System.out.println(sb);
            
            minHeap.clear();
            maxHeap.clear();
        }
    }
}



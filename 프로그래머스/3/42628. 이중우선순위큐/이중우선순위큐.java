import java.util.*;

class Solution {
    static Queue<Integer> maxHeap = new PriorityQueue<>(5);
    static Queue<Integer> minHeap = new PriorityQueue<>(5);

    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        StringTokenizer st;

        for(String operation : operations){
            if(operation.equals("D 1")){
                // maxHeap root 빼기
                if (!maxHeap.isEmpty()) {
                    int temp = maxHeap.poll();
                    minHeap.remove(-1 * temp);

                }
            }else if(operation.equals("D -1")){
                // minHeap root 빼기
                if (!minHeap.isEmpty()) {
                    int temp = minHeap.poll();
                    maxHeap.remove(-1 * temp);
                }

            }else{
                st = new StringTokenizer(operation);
                st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                // 힙에 넣기 (max, min 두 곳에)
                maxHeap.offer(-1*num);
                minHeap.offer(num);
            }
        }
        
        if (!maxHeap.isEmpty()) answer[0] = -1*maxHeap.peek();
        if (!minHeap.isEmpty()) answer[1] = minHeap.peek();
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        for (int s : scoville) pq.add(s);

        while (pq.size() >= 2){
            if (pq.peek() >= K) return answer;

            int polled1 = pq.poll();
            int polled2 = pq.poll();

            int mixed = polled1 + polled2 * 2;
            pq.add(mixed);
            answer ++;
        }
        
        if (pq.size() == 1 & pq.peek() >= K) return answer;
        return -1;
    }
}
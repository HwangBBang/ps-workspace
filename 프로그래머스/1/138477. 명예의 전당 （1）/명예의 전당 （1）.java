import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        Queue<Integer> minHeap = new PriorityQueue<>(k);
        
        for(int i = 0; i < score.length; i ++){
            int each = score[i];
            
            if (minHeap.size() < k) minHeap.add(each);
            else {
                if (minHeap.peek() < each){
                    minHeap.poll();
                    minHeap.add(each);
                }
            }
            
            answer[i] = minHeap.peek();
        }
        
        return answer;
    }
}
/*
"명예의 전당" 매일 1명의 가수가 노래, 

시청자들의 문자 투표수로 가수에게 점수를 부여.

매일 출연한 가수의 점수가 지금까지 출연 가수들의 점수 중 상위 k번째 이내이면 -> 명예의 전당이라는 목록에 올려 기념

즉 프로그램 시작 이후 초기에 k일까지는 모든 출연 가수의 점수가 명예의 전당

k일 다음부터는 출연 가수의 점수가 기존의 명예의 전당 목록의 k번째 순위의 가수 점수보다 더 높으면, 

출연 가수의 점수가 명예의 전당에 오르게 되고 기존의 k번째 순위의 점수는 명예의 전당에서 내려오게 됩니다.
*/
import java.util.*;

class Solution {
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int p: priorities){
            pq.add(p);
        }
        
        while(!pq.isEmpty()){
            for (int i = 0; i < priorities.length; i++){

                //              현재 작업 찾기 
                if (pq.peek() == priorities[i]){
                    pq.poll();
                    answer ++;
                    
                    if (location == i) return answer;
                }
            }
            
        }
        
        
        return answer;
    }
}

/*
예를 들어 프로세스 4개 [A, B, C, D]가 순서대로 실행 대기 큐에 들어있고, 

우선순위가 [2, 1, 3, 2]라면 [C, D, A, B] 순으로 실행하게 됩니다.

현재 실행 대기 큐(Queue)에 있는 프로세스의 중요도가 순서대로 담긴 배열 priorities

몇 번째로 실행되는지 알고싶은 프로세스의 위치를 알려주는 location

이 매개변수로 주어질 때, 해당 프로세스가 몇 번째로 실행되는지 return 하도록 solution 함수를 작성해주세요.
*/ 

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int p1 = 0;
        int p2 = people.length - 1;
        
        while(p1 <= p2){
            if (people[p1] + people[p2] <= limit){
                p1 ++;
            }
            p2 --;
            answer ++;
        }
        
        return answer;
    }
}

/*
    한 번에 최대 2명씩
    [보트한번에 최대한으로 실는다. -> 보트를 최소한 으로 사용한다. -> 그리디]
    
    <1차 시도 풀이>
    .. 정렬을 사용해 해결? /  정렬 O(n log n ) + 순회 O(n) -> O(n log n )
    
        Arrays.sort(people);
        int temp = 0;
        int tempCnt = 0;
        
        answer ++; // 최초 보트 
        
        for (int i = 0; i < people.length; i++){
            if (temp + people[i] > limit || tempCnt >= 2){
                temp = 0; // 새 보트 
                tempCnt = 0;
                answer ++;
            }
            temp += people[i];
            tempCnt++;
        }
    
    => 잘 못된 풀이 : 보트 한번에 최대로 실는다가 반영 X 
   
    그럼 보트에 최대로 실는다를 어떻게 반영하지? 
    냅색 문제 처럼..? 근데 기억이 안나 .. 
    ---
    페어문제 처럼 스택을 활용해서 limit 까지 채우는 것들만 먼저 만들기
    스택에 남아 있는 잔여된 녀석들은 리미트를 낮추면서..? O(n^2)
    200 * 50_000 => 10_000_000 ... 시간 초과 나려나? -> 잘 모르겠음 검증필요
    .. 아닌 것 같음 
    
    ---
    
    정렬한 다음 투 포인터 스캔 으로 리미트까지 채우기..?
    정렬 O(n log n )
    투포인터 스캔 O(n)
    

*/
import java.util.*;

class Solution {
    static int[] days;
    static int n;
    public int[] solution(int[] progresses, int[] speeds) {

        n = progresses.length;
        days = new int[n];
        for (int i = 0; i < n; i++){
            days[i] = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
        }
        
        int step = 1;
        
        List<Integer> l= new ArrayList<>();
        
        for (int i = 0; i < n; i += step){
            step = getRange(i);
            l.add(step);
        }
        
        int[] answer = new int[l.size()];
        for (int i = 0; i < l.size(); i++){
            answer[i] = l.get(i);
        }
        
        return answer;
    }
    static int getRange(int idx){
        int p = days[idx];
        
        int c = 0;
        for (int i = idx; i < n; i++){
            if (days[idx] < days[i]) break;
            c++;
        }
        return c;
        
    }
}

// 7, 3, 9 -> 2, 1
// 5 10 1 1 20 1 -> 1, 3, 2

/*
프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 

각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.

 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
 
 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.

 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

*/ 
// System.out.println("Hello Java");
import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int []{0,0};
        int cycle = 0;
        
        // 이미 사용했는지 체크용 (조회성능 상수 인걸로)
        Map<String, Boolean> exists = new HashMap<>();
        
        // 첫 번째 잘 들어갔다고 쳐 
        exists.put(words[0], true);
        
        for (int i = 1; i < words.length; i++){
            int num = i % n + 1;
            String preLast = words[i-1].substring(words[i-1].length()-1);
            String curFirst = words[i].substring(0,1);
    
            if (!preLast.equals(curFirst)){
                return new int []{num,i / n + 1};
            }
            
            if (exists.getOrDefault(words[i], false)){
                return new int []{num,i / n + 1};
            }
            exists.put(words[i], true);
        }

        return answer;
    }
}

/*
    n명의 사람 ,words 순회 (원형)
    [가장 먼저 탈락하는 사람의 번호, 그 사람이 자신의 몇 번째 차례에 탈락하는지]
    1. tank →
    2. kick →
    3. know →
    1. wheel →
    2. land →
    3. dream →
    1. mother →
    2. robot →
    3. tank
*/
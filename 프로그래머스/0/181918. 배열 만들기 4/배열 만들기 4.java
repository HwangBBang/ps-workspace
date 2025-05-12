import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();
        int i = 0;
        
        while (i < arr.length){
            if (stk.isEmpty()) {
                stk.add(arr[i++]);
                continue;
            }
            if (stk.get(stk.size()-1) < arr[i]) {
                stk.add(arr[i++]);
                continue;
            }
            stk.remove(stk.size()-1);
        }
        
        int[] answer = new int[stk.size()];
        for (int l = 0; l < stk.size(); l++){
            answer[l] = stk.get(l);
        }
        return answer;
    }
}
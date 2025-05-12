import java.util.*;

class Solution {
    static Queue<Integer> queue = new LinkedList<>();
    static List<Integer> stk = new ArrayList<>();
    public int[] solution(int l, int r) {

        queue.add(5);        
        while(!queue.isEmpty()){
            int pivot = queue.poll();
            if (pivot > r) break;
            
            if (pivot >= l){
               stk.add(pivot);
            }    
            queue.add(pivot*10);
            queue.add(pivot*10 + 5);
        }
        
        int n = stk.size();
        int[] answer = new int[n];
        for (int i = 0; i < n; i ++){
            answer[i] = stk.get(i);
        }
        
        if (stk.isEmpty()) return new int[]{-1};
        return answer;
        
    }    
        

}
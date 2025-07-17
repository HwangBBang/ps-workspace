
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] exists = new boolean[10];
        for (int num : numbers){
            exists[num] = true;
        }
        
        for (int i = 0; i < 10; i ++){
            if (!exists[i]) answer += i;    
        }
        
        
        return answer;
    }
}
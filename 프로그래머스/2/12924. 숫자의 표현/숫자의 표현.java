class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int k = 1; k * (k-1) < 2*n; k ++){
            int target = 2 * n - k * (k-1);
            if (target % (2*k) == 0) answer ++;
        
        }
        
        return answer;
    }
}
/*
    범위 별로 다보는건 O(n!)
    
    연속된 수이니까 중간값과 갯수를 이용 O(n)
    
*/




    
    
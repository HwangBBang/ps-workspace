class Solution {
    public int solution(int n) {
        int answer = 0;
        int div = 0;
        int x = 0;
        
        while (div != 1){
            x ++;
            div = n % x;
        }
        answer = x;
        return answer;
    }
}
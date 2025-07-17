class Solution {
    public String solution(String s) {
        int n = s.length();
        int half = n/2;
        String answer = "";
        
        if (n % 2 == 0){
            answer = s.substring(half-1,half+1);
        }else{
            answer = s.substring(half,half+1);
        }
        
        return answer;
    }
}
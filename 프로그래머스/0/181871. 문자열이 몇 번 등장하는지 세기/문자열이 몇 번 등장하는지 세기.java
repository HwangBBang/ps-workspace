class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int pLen = pat.length();
        int sLen = myString.length();
        
        for (int i = 0; i <= sLen-pLen; i ++){
            if (pat.equals(myString.substring(i,i+pLen))) answer ++;
            
        }
        return answer;
    }
}
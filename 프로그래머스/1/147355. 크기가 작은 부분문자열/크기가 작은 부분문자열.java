class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int tLen = t.length();
        int pLen = p.length();
        
        for (int i = 0; i <= tLen-pLen; i ++){
            if (Long.parseLong(t.substring(i, i + pLen)) <= Long.parseLong(p)) 
                answer ++;
        }
        return answer;
    }
}
class Solution {
    public int solution(String message) {
        int answer = 0;
        answer = cntMessageLen(message);
        return answer;
    }
    
    private int cntMessageLen(String text){
        return text.length() * 2;
    }
}
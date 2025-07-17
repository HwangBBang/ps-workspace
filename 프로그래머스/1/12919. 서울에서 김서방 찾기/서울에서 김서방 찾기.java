class Solution {
    public String solution(String[] seoul) {
        
        int index = 0;
        
        for (int i = 0; i < seoul.length; i ++){
            if ("Kim".equals(seoul[i])) index = i;
        }
        
        String answer = "김서방은 "+ index +"에 있다";
        return answer;
    }
}
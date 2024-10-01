class Solution {
    public String solution(String code) {
        int mode = 0;
        String answer = "";
        StringBuilder ret = new StringBuilder();
        
        // curChar는 char 타입을 반환.-> equals 메서드를 사용할 수 없음
        
        for (int i=0;i<code.length();i++){
            char curChar = code.charAt(i);
            if(curChar=='1'){mode = 1 - mode;}
            else{
                if (mode == 1 && i % 2 == 1){
                    ret.append(curChar);
                }else if(mode == 0 && i % 2 == 0){
                    ret.append(curChar);
                }       
            }
        }
        answer = ret.toString();
        
        if (answer.isEmpty()) answer = "EMPTY";
        return answer;
    }
}
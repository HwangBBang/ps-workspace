// import java.lang.Character;

class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        char[] splited = s.toCharArray();
        
        for (char each : splited){
            if ((int)each == (int)' ') {
                answer.append(String.valueOf((char)each));
                continue;
            }
            else if (Character.isUpperCase(each)){
                int temp = (int)each + n; 
                temp = temp - (int)'A';
                temp = (temp % 26) + (int)'A';
                answer.append(String.valueOf((char)temp));
            }
            else{
                int temp = (int)each + n; 
                temp = temp - (int)'a'; 
                temp = (temp % 26) + (int)'a';
                answer.append(String.valueOf((char)temp));
            }

        }
        
        return answer.toString();
    }
}
class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        int sLen = myString.length();
        int pLen = pat.length();
        
        for (int i = sLen - pLen; i >=0 ;i--){
            
            if (pat.equals(myString.substring(i,i+pLen))) 
                return myString.substring(0,i+pLen);
        }
        return answer;
    }
}

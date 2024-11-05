class Solution {
    public String solution(String cipher, int code) {
        
        StringBuilder sb = new StringBuilder();
        String[] str =("0"+cipher).split("");
        
        for (int i = code; i <= cipher.length(); i += code)
            sb.append(str[i]);
        
        return sb.toString();
    }
}
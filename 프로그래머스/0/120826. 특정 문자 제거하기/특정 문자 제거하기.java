class Solution {
    public String solution(String my_string, String letter) {
        String[] str = my_string.split("");
        
        StringBuilder sb = new StringBuilder();
        
        for (String s : str){
            if(!s.equals(letter)) sb.append(s);
        }
        
        return sb.toString();
    }
}
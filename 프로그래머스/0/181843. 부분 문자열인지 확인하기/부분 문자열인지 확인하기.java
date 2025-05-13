class Solution {
    public int solution(String my_string, String target) {
        int sLen = my_string.length();
        int tLen = target.length();
        
        for (int i = 0; i <= sLen-tLen; i ++){
            if(target.equals(my_string.substring(i,i+tLen))) return 1;
        }
        
        return 0;
    }
}
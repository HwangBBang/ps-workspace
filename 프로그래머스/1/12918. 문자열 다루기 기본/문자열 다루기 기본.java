class Solution {
    public boolean solution(String s) {
        
        if (s.length() != 4 && s.length() != 6) return false;
            
        for (Character each : s.toCharArray()){
            if (Character.isAlphabetic(each)) return false;
        }
        return true;
    }
}


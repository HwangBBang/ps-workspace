class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] elems = s.split(" ");
        
        int minPivot = Integer.MAX_VALUE;
        int maxPivot = Integer.MIN_VALUE;
        
        for (String elem : elems){            
            maxPivot = Math.max(maxPivot, Integer.parseInt(elem));
            minPivot = Math.min(minPivot, Integer.parseInt(elem));
        }
        
        answer = minPivot + " " + maxPivot;
        return answer;
    }
}
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        String[] splited = s.split(" ",-1);
        
        for(int eachIdx = 0; eachIdx < splited.length; eachIdx ++){
            String[] eachs = splited[eachIdx].split("");
            
            for (int idx = 0; idx < eachs.length; idx ++){
                
                if (idx % 2 == 0) answer.append(eachs[idx].toUpperCase());
                else answer.append(eachs[idx].toLowerCase());
            }
            
            if (eachIdx < splited.length - 1) answer.append(" ");
        }
        
        return answer.toString();
    }
}
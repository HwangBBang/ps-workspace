class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sList = s.split(" ",-1);
        
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < sList.length; i ++){
            String word = sList[i];
            if (word.length() == 0){
                sb.append("");
            } else{
                sb.append(sList[i].substring(0,1).toUpperCase())
                  .append(sList[i].substring(1).toLowerCase());
            }
            
            if (i != sList.length-1) sb.append(" ");
        }
        
        answer = sb.toString();
        return answer;
    }
}

/*
    공백이 여러개인 경우 어떻게 해야하지..?
*/
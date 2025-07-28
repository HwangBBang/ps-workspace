import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i ++){
            String line1 = convertBinary(arr1[i], n);
            String line2 = convertBinary(arr2[i], n);
            
            String resultLine = or(line1, line2);
            answer[i] = resultLine;
        }
        
        return answer;
    }
    
    static String convertBinary(int decimal, int n){
        StringBuilder sb = new StringBuilder();
        String original = Integer.toBinaryString(decimal);

        for (int i = 0; i < n - original.length(); i++){
            sb.append("0");    
        }
        sb.append(original);
        
        return sb.toString();
    }
    
    static String or(String b1, String b2){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= b1.length(); i ++ ){
            String each1 = b1.substring(i-1,i);
            String each2 = b2.substring(i-1,i);
            
            if (each1.equals("1")|| each2.equals("1")) sb.append("#");
            else sb.append(" ");
        }
        
        return sb.toString();
    }   
}
class Solution {
    public int solution(int n) {
        int answer = 0;
        String three = decimalToThree(n);
        answer = threeTodecimal(three);
        
        return answer;
    }
    
    static String decimalToThree(int decimal){
        StringBuilder sb = new StringBuilder();
        
        while (true){
            sb.append(decimal % 3);
            if (decimal <= 2) break;
            
            decimal = decimal / 3;
        }
                
        return sb.toString();
    }
    
    static int threeTodecimal(String three){
        String[] threes = three.split("");
        int answer = 0;
        
        // 3 2 1 0
        // 0 0 2 1
        
        for (int i = threes.length-1; i >= 0; i --){
            answer += Integer.parseInt(threes[threes.length-1-i]) * Math.pow(3.0,(double)i);
        }
                
        return answer;
    }
}

// 45 % 3 = 15, 0
// 15 % 3 = 5, 0
// 5 % 3 = 1, 2
// 1 % 3 = 0, 1
    
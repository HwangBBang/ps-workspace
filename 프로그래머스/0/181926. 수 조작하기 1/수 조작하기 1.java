class Solution {
    int callW(int n){return n + 1;}
    int callS(int n){return n - 1;}
    int callD(int n){return n + 10;}
    int callA(int n){return n - 10;}
    public int solution(int n, String control) {
        int answer = 0;
        
        char[] cons = control.toCharArray();
        
        for (char con : cons){
            switch(con){
            case 'w' : n=callW(n); break;
            case 's' : n=callS(n); break;
            case 'd' : n=callD(n); break;
            case 'a' : n=callA(n); break;
                }    
            }
        answer = n;
        return answer;
    
        }
        
}



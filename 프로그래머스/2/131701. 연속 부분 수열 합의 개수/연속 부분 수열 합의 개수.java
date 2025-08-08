import java.util.*;

class Solution {
    static Set<Integer> answer;
    static int n;
    static int [] circle;
    public int solution(int[] elements) {
        answer = new HashSet<>();
        n = elements.length;
        circle = elements;
        
        for (int len = 1; len <= n; len++){
            for (int sIdx = 0; sIdx < n; sIdx++){
            calcumByLen(sIdx,len);
            }    
        }
        
        
        return answer.size();
    }
    
    static void calcumByLen(int sIdx, int len){
        int sum = 0;
        for (int i = 0; i < len; i++){ // i 는 길이 
            sum += circle[(sIdx + i) % n];
        }
        answer.add(sum);
        
    }
}

/*
어떤 자연수로 이루어진 원형 수열의 연속하는 부분 수열의 합

수가 모두 몇 가지인지

원형 수열이란 일반적인 수열에서 처음과 끝이 연결된 형태

선형의 길이는 1000 이하 
다보는거 ->O(N^3) ??
*/

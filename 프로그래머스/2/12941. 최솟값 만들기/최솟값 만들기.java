import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int len = A.length;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i = 0; i < len; i ++){
            answer += A[i] * B[len-i -1];
        }
        
        

        return answer;
    }
}

/*
    모든 케이스를 하는 경우 1000 * 1000 => 시간 초과? 
    그럼 뭘 해야하지? 
    각 배열을 오름차순 , 내림차순 정렬 을 한 뒤 곱하는 것이 베스트 일까? 
    => 해보자 
    
*/
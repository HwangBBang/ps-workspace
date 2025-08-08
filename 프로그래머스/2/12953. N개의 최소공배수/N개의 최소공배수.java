import java.util.*;
import java.math.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        
        int answer = arr[0];
        
        for (int i = 1; i < arr.length; i ++){
            answer = getLCM(answer, arr[i]);
        }
        
        return answer;
    }   
    
    static int getGCD(int a, int b){
        BigInteger bigA = new BigInteger(String.valueOf(a));
        BigInteger bigB = new BigInteger(String.valueOf(b));
        
        return Integer.parseInt(bigA.gcd(bigB).toString()); 
    }
    static int getLCM(int a, int b){
        return a * b / getGCD(a,b);
    }
}

/*
두 수의 최소공배수
입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자


예를 들어 2와 7의 최소공배수는 14가 됩니다. 

정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.


    정렬 후 앞에서 부터 
    버블 처럼 최소공배수 구하면서 끝까지가기 
    len <= 100 이고 
    순회 O(N)
    최소 공배수 구하기  O(?)
*/
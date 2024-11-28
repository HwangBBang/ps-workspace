import java.util.*; 
class Solution {
    public int solution(String number) {
        int answer = Arrays.stream(number.split("")).mapToInt(Integer::parseInt).sum();
        return answer % 9;
    }
}

// 음이 아닌 정수를 9로 나눈 나머지
// 는 그 정수의 각 자리 숫자의 합을 9로 나눈 나머지와 같은 것이 알려져 있습니다.

// 이 사실을 이용하여 음이 아닌 정수가 문자열 number로 주어질 때,
// 이 정수를 9로 나눈 나머지를 return 하는 solution 함수를 작성해주세요.
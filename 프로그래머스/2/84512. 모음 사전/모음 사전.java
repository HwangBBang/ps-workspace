class Solution {
    static int answer, idx;
    static String word;
    static final String [] dics = new String []{"A", "E", "I", "O", "U"}; 
    public int solution(String word) {
         answer = 0;
        this.word = word;
        dfs(new StringBuilder(""));
        return answer;
    }
    
    
    static void dfs(StringBuilder sb){
        
        if (sb.toString().equals(word)){
            answer = idx;
            return;
        }
        if (sb.length() == 5) return;
        
        for (String each : dics){
            idx ++;
            dfs(sb.append(each));
            sb = sb.delete(sb.length()-1, sb.length());
       }
    }
}

/*

사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용

길이 5 이하의 모든 단어가 수록

사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.

단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.

제한사항
word의 길이는 1 이상 5 이하입니다.
word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.
*/
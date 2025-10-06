import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] original = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();
        int oLen = original.length;
        int tLen = target.length;
        char lastChar = target[tLen-1];

        List<Character> stack = new ArrayList<>();

        for (int i = 0; i < oLen; i++) {
            char cur = original[i];
            stack.add(cur);
            if (cur == lastChar && stack.size() >= tLen) {
                boolean isTarget = true;
                for (int j = 0; j < tLen; j++) {
                    if (target[j] != stack.get(stack.size()-tLen + j)) {
                        isTarget = false;
                        break;
                    }
                }
                if (isTarget) {
                    for (int j = 0; j < tLen; j++) {
                        stack.remove(stack.size()-1);
                    }
                }
            }
        }
        String answer = "FRULA";
        StringBuilder sb = new StringBuilder();

        if (!stack.isEmpty()) {
            for (Character c : stack) sb.append(c);
            answer = sb.toString();
        }
        System.out.println(answer);
        
    }
}
/*

 1 <= 문자열의 길이 <= 1,000,000

 StringBuilder sb = new StringBuilder(br.readLine());
        String target = br.readLine();

        int idx = sb.indexOf(target);
        while(idx != -1){
            sb.delete(idx, idx + target.length());
            idx = sb.indexOf(target);
        }

        String answer = (sb.length() == 0) ? "FRULA" : sb.toString();
        System.out.println(answer);

 선형적으로 작업하면 시간 초과
 why ? 삭제 연산이 O(n) 이기에 -> O(n^2)

 그럼 삭제연산의 복잡도를 O(n) 미만으로 만들어야해 + 순서 유지

 순서유지가 되며 삭제연산이 빠르게 하려면 stack


 */
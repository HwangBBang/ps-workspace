
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

//        st = new StringTokenizer();
        Deque<Character> opStack = new ArrayDeque<>();

        String inOrder = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inOrder.length(); i++) {
            char each = inOrder.charAt(i);
            if (isUpperAlpha(each)) sb.append(each);
            else if (each == '(') {
                opStack.push(each);
            }
            else if (each == ')') {
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    sb.append(opStack.pop());
                }
                opStack.pop(); // '(' 제거
            }
            else { // 연산자들 * / + -
                while (!opStack.isEmpty()){
                    char top = opStack.peek();

                    if (top == '(') break; // 괄호 시작 부 : 괄호가 아직 안끝난 경우
                    if (priority(top) < priority(each)) break; // 현재 넣을 놈이 우선순위가 더 높은 경우
                    sb.append(opStack.pop());
                }

                opStack.push(each);
            }
        }
        while (!opStack.isEmpty()) {
            sb.append(opStack.pop());
        }


        System.out.print(sb);

    }

    private static boolean isUpperAlpha(char c){
        return Character.getType(c) == Character.UPPERCASE_LETTER;
    }
    private static int priority(Character c){
        if (c == '*' || c == '/') return 2;
        if (c == '+' || c == '-') return 1;
        return 0; // 비교 대상이 아닌 경우
    }
}

/*

 중위 표기식 -> 후위 표기식
 우선 주어진 중위 표기식을 연산자의 우선순위에 따라 괄호로 묶어준다.
 그런 다음에 괄호 안의 연산자를 괄호의 오른쪽으로 옮겨주면 된다.

    a+b*c => (a+(b*c))
    A+B*C-D/E => ((A+(B*C))-(D/E)) ABC*+DE/-
    A*B 이 있을 때 괄호 맥이는 법


  중위 표기식 -> 후위 표기식


  연산자를 만났을 때,

  스택 꼭대기에 자신보다 우선순위가 높거나 같은(좌결합) 연산자가 있으면 먼저 빼서 출력하고,
  그 다음 자신을 push합니다.
*/
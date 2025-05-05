import java.util.*;
import java.io.*;

public class Main {
    static int length = 0;
    static int answer = 99;
    static char pivot;
    static StringBuilder answerList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] chars = st.nextToken().toCharArray();
        length = chars.length;
        for (int i = 0; i < length; i++) {
            char[] temp = convertLine(chars);
            answer = Math.min(answer,temp.length);
            shiftRight(chars);
        }

        System.out.println(answer);
    }

    static void shiftRight(char[] line){
        char temp = line[length - 1];
        for (int i = length-1; i > 0; i--) {
            line[i] = line[i-1];
        }
        line[0] = temp;
    }

    static char[] convertLine(char[] line) {
        answerList = new StringBuilder();

        pivot = line[0];
        for (int i = 0; i < length; i++) {
            if (i != 0 && pivot == line[i]) continue;
            int count = getCount(line, i);
            answerList.append(count);
        }

        return answerList.toString().toCharArray();
    }

    static int getCount(char[] line, int startIndex){
        int count = 1;
        pivot = line[startIndex];
        answerList.append(pivot);

        for (int i = startIndex + 1; i < length; i++) {
            if (pivot != line[i]) break;
            count++;
        }
        return count;
    }
    
}
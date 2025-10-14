
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> preOrder;
    static StringBuilder postOrder;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        postOrder = new StringBuilder();

        preOrder = new ArrayList<>();
        preOrder.add(0);


        while ((line = br.readLine()) != null) {
            int num = Integer.parseInt(line);
            preOrder.add(num);
        }
        solution(1, preOrder.size() - 1);
        
        System.out.println(postOrder);

    }

    static void solution(int start, int end) {

        int rootValue = preOrder.get(start);

        int i = start + 1;
        while (i <= end) {
            if (preOrder.get(i) > rootValue) break;
            i++;
        }

        int leftSubStartIdx = start + 1;
        int leftSubEndIdx = i - 1;
        if (leftSubStartIdx <= leftSubEndIdx){
            solution(leftSubStartIdx,leftSubEndIdx);

        }

        int rightSubStartIdx = i;
        int rightSubEndIdx = end;
        if (rightSubStartIdx <= rightSubEndIdx) {
            solution(rightSubStartIdx, rightSubEndIdx);
        }

        postOrder.append(rootValue).append("\n");
    }

}

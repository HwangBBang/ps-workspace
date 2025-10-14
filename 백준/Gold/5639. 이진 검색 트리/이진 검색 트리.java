
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> preOrder;
    static ArrayList<Integer> postOrder;
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        preOrder = new ArrayList<>();
        preOrder.add(0);
        postOrder = new ArrayList<>();


        while ((line = br.readLine()) != null) {
            int num = Integer.parseInt(line);
            preOrder.add(num);
        }
        solution(1, preOrder.size() - 1);

        for (Integer each : postOrder) {
            System.out.println(each);
        }

    }

    static int solution(int start, int end) {

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
        postOrder.add(rootValue);
        return rootValue;
    }

}

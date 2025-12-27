// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b, a)
        );
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (maxHeap.size() == minHeap.size()) {
                maxHeap.add(num);
            }else{
                minHeap.add(num);
            }
            if (!minHeap.isEmpty() &&
                !maxHeap.isEmpty() &&
                maxHeap.peek() > minHeap.peek()) {
                int node1 = maxHeap.poll();
                int node2 = minHeap.poll();
                maxHeap.add(node2);
                minHeap.add(node1);
            }
            int midian = maxHeap.peek();
            sb.append(midian).append("\n");
        }
        System.out.println(sb);
    }

}

/*

    어떤 자료구조를 써야할까? 힙 두개
    minheap 이 사이즈 +1


*/

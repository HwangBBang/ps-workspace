// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {

        int start, end;
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node other) {
            if (this.start != other.start) return Integer.compare(this.start, other.start);
            else return Integer.compare(this.end, other.end);
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(s, t);
        }

        Arrays.sort(nodes);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(nodes[0].end);


        for (int i = 1; i < n; i++) {
            Node comp = nodes[i];
            int minEnd = minHeap.peek();
            if (minEnd <= comp.start) {
                minHeap.poll(); // 재사용
            }

            minHeap.add(comp.end);
        }

        System.out.println(minHeap.size());
    }
}

/*
    1_000_000_000
    기존 강의실을 최대 재활용
    없으면 하나 더 만듦
*/

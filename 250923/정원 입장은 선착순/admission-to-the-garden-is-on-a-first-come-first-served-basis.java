import java.util.*;
public class Main {
    static class Person implements Comparable<Person>{
        int num;
        int start,during,end;

        public Person(int num, int start, int during){
            this.num = num;
            this.start = start;
            this.during = during;
            this.end = start + during;
        }

        @Override
        public int compareTo(Person other){
            if (this.end != other.end){
                return Integer.compare(this.end, other.end);
            } else if (this.num != other.num){
                return Integer.compare(this.num, other.num);
            } else{
                return Integer.compare(other.start, this.start);
            }
        }
        @Override
        public String toString(){
            return "시작" + start + "| 종료" + end + "| 번호" + num ;
        }
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Person> pq = new PriorityQueue<>();
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            t[i] = sc.nextInt();
            pq.add(new Person(i+1,a[i],t[i]));
        }

        Person prev = pq.poll();
        int totalDelay = 0;
        int answer = Integer.MIN_VALUE;
        // System.out.println(prev.toString());
        for (int i = 1; i < n; i++) {
            Person cur = pq.poll();
            int curDelay = prev.end - cur.start;
            // System.out.println(cur.toString() + " | 대기: " + curDelay);
            totalDelay += curDelay;
            totalDelay = Math.max(totalDelay, 0);
            answer = Math.max(answer, totalDelay);
            prev = cur;
        }
        System.out.println(answer);
    }
}
/*
1~N 명의 사람들 

도착 시간 a1 
잔류 시간 t1
떠나는시간 a1 + t1

정원에는 한사람만 입장가능 , 대기(큐)

25 3
105 30
20 50
10 17
100 10

*/
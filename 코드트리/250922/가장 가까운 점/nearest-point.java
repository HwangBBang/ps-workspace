import java.util.*;

public class Main {
    public static class Pos implements Comparable<Pos>{
        private int x,y,dist;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
            this.dist = x + y;
        }

        public void addValue(int x, int y){
            this.x += x;
            this.y += y;
            this.dist = this.x + this.y;
        }
        

        @Override
        public int compareTo(Pos other){
            if(this.dist != other.dist){
                return Integer.compare(this.dist, other.dist);
            }else if (this.x != other.x){
                return Integer.compare(this.x, other.x);
            }else {
                return Integer.compare(this.y, other.y);
            }
        }

        @Override
        public String toString(){
            return this.x + " " + this.y;
        }

    }
    public static void main(String[] args) {
        PriorityQueue<Pos> pq = new PriorityQueue<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            pq.add(new Pos(sc.nextInt(), sc.nextInt()));
        }
        
        for (int i = 0; i < m; i++) {
            Pos pos = pq.poll();
            pos.addValue(2,2);
            pq.add(pos);
        }

        System.out.println(pq.peek().toString());
    }
}
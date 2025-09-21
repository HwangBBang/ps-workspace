import java.util.*;

public class Main {
    static public class Problem implements Comparable<Problem> {
        private int level;
        private int number;


        public Problem(int level, int number){
            this.level = level;
            this.number = number;
        }

        @Override
        public int compareTo(Problem problem){
            if (this.level != problem.level){
                return Integer.compare(this.level, problem.level);
            }else{
                return Integer.compare(this.number, problem.number);
            }
        }
        @Override
        public String toString(){
            return String.valueOf(this.number);
        }
    }
    public static void main(String[] args) {

        TreeSet<Problem> tree = new TreeSet<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int l = sc.nextInt();
            tree.add(new Problem(l,p));
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String command = sc.next();
            if (command.equals("rc")) {
                Problem result;
                int x = sc.nextInt();
                if (x == 1){
                    result = tree.last();
                }else{
                    result = tree.first();
                }
                System.out.println(result.toString());
            } else if (command.equals("ad") || command.equals("sv")) {
                int p = sc.nextInt();
                int l = sc.nextInt();
                if (command.equals("ad")) tree.add(new Problem(l,p));
                else if (command.equals("sv")) tree.remove(new Problem(l,p));
            }
        }
    }
}
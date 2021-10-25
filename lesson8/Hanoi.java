package lesson8;

public class Hanoi {
    
    public static void main(String[] args) {
        Hanoi h = new Hanoi();
        h.hanoi(5);
    }

    public void hanoi(int i) {
        f(i, "左", "右", "中");
    }
    public void f(int i, String from, String to, String other) {
        if (i == 1) {
            System.out.println("Move " + i + " from " + from + " to " + to);
        } else {
            f(i - 1, from, other, to);
            System.out.println("Move " + i + " from " + from + " to " + to);
            f(i - 1, other, to , from);
        }
    }

}
import java.awt.*;
import java.util.ArrayList;

public class Threading extends Thread {
    private int id;
    private ArrayList<Point> toWork = new ArrayList<>();
    private ArrayList<Point> works = new ArrayList<>();

    public Threading(int id)
    {
        this.id = id;
    }
    public void addToWork(Point p){
        toWork.add(p);
    }
    public void run() {
        for (Point p : toWork) {
            check(p.x, p.y);
        }
        System.out.println("thread " + this.id + " done!");
    }

    public void check(int n, int k)
    {
        if (checkPrime(reverse(n))&& checkPrime(reverse((int)Math.pow(n, k)))) {
            works.add(new Point(n,k));
        }
    }
    public static boolean checkPrime(final long value) {
        if (value <= 2) {
            return (value == 2);
        }
        for (long i = 2; i * i <= value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int reverse(int input) {
        long reversedNum = 0;
        long input_long = input;

        while (input_long != 0) {
            reversedNum = reversedNum * 10 + input_long % 10;
            input_long = input_long / 10;
        }

        if (reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE) {
            throw new IllegalArgumentException();
        }
        return (int) reversedNum;
    }

    public ArrayList<Point> getWorks() {
        return works;
    }
}

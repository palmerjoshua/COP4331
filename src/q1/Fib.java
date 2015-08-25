package q1;


public class Fib {

    public Fib() {

    }

    public int f(int n) {
        int tmp;
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            tmp = b;
            b += a;
            a = tmp;
        }
        return a;
    }

    public int fRec(int n) {
        if (n > 1) {
            return fRec(n-1) + fRec(n-2);
        } else {
            return n;
        }
    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        Fib fib = new Fib();

        int iterative = fib.f(n);
        int recursive = fib.fRec(n);

        System.out.println("Iterative: " + iterative);
        System.out.println("Recursive: " + recursive);

    }


}

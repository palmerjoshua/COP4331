package hw1.q1;


public class Fib {

    private int a0, a1;

    public Fib(int first, int second) {
        a0 = first;
        a1 = second;
    }

    public Fib() {
        a0 = 0;
        a1 = 1;
    }

    public int f(int j) {
        int tmp;
        int a = a0, b = a1;
        for (int i = 0; i < j; i++) {
            tmp = b;
            b += a;
            if (i+1<=j)
                a = tmp;

        }
        return a;
    }


    public int fRec(int x, int y, int j) {
        int a = x, b = y;
        int tmp;
        if (j >= 1) {
            tmp = b;
            b += a;
            a = tmp;
            return fRec(a, b, j-1);
        }
        return a;
    }


    public int fRec(int j) {
        return this.fRec(a0, a1, j);
    }


    public static void main(String[] args) {
    // todo support for different number of args
        int f0 = Integer.parseInt(args[0]),
            f1 = Integer.parseInt(args[1]),
            n = Integer.parseInt(args[2]);

        int iterative, recursive;
        String it_string = "", re_string = "";

        Fib fib = new Fib(f0, f1);

        System.out.print("Iterative: ");
        for(int i=0; i<=n; i++) {
            iterative = fib.f(i);
            it_string = String.format("%s %d", it_string, iterative);
        } System.out.println(it_string);

        System.out.print("\nRecursive: ");
        for(int i=0; i<=n; i++) {
            recursive = fib.fRec(i);
            re_string = String.format("%s %d", re_string, recursive);
        } System.out.println(re_string);
    }
}

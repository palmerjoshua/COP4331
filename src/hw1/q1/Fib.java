package hw1.q1;


public class Fib {

    private int n0, n1, j;

    public Fib(int first, int second, int num) {
        n0 = first;
        n1 = second;
        j = num;
    }

    public Fib(int num) {
        n0 = 0;
        n1 = 1;
        j = num;
    }

    public Fib() {
        n0 = 0;
        n1 = 1;
        j = 10;
    }

    public int f() {
        int tmp;
        int a = n0, b = n1;
        for (int i = 0; i < j; i++) {
            System.out.format("%d ", a);
            tmp = b;
            b += a;
            if (i+1<j)
                a = tmp;

        }
        System.out.println();
        return a;
    }


    public int fRec(int x, int y, int k) {
        int a = x, b = y;
        int tmp;
        if (k > 1) {
            System.out.format("%d ", a);
            tmp = b;
            b += a;
            a = tmp;
            return fRec(a, b, k-1);
        }
        System.out.format("%d ", a);
        return a;
    }


    public int fRec() {
        return this.fRec(n0, n1, j);
    }


    public static void main(String[] args) {
    // todo support for different number of args
        int f0 = Integer.parseInt(args[0]),
            f1 = Integer.parseInt(args[1]),
            n = Integer.parseInt(args[2]);


        Fib fib = new Fib(f0, f1, n);

        int iterative = fib.f();
        int recursive = fib.fRec();

        System.out.println("\nIterative: " + iterative);
        System.out.println("Recursive: " + recursive);

    }




}

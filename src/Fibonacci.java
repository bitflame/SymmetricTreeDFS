public class Fibonacci {

    public int fib(int n) {
            if (n == 0) return 0;
            if (n == 1) return 1;
            int[] fibs = new int[n];
            fibs[0] = 0;
            fibs[1] = 1;
            return calcdFibo(fibs, n, 2, 1);
    }

    private int calcdFibo(int[] fibs, int target, int index, int sum) {
        sum = fibs[index - 2] + fibs[index - 1];
        if (index == target) return sum;
        fibs[index] = sum;
        return calcdFibo(fibs, target, index + 1, fibs[index]);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("Test 1 Expecting: 0, Getting: " + fibonacci.fib(0));
        System.out.println("Test 2 Expecting: 1, Getting: " + fibonacci.fib(1));
        System.out.println("Test 3 Expecting: 1, Getting: " + fibonacci.fib(2));
        System.out.println("Test 4 Expecting: 2, Getting: " + fibonacci.fib(3));
        System.out.println("Test 5 Expecting: 3, Getting: " + fibonacci.fib(4));
    }
}
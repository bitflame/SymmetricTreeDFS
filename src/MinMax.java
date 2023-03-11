import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinMax {
    public static void miniMaxSum(List<Integer> arr) {
        // put the lesser value in the minSum and the larger value in the maxSum
        Collections.sort(arr);
        // use long
        int arrLen = arr.size();
        long minSum = arr.get(0);
        long maxSum = arr.get(arrLen - 1);
        int current;
        for (int i = 1; i < arrLen - 1; i++) {
            current = arr.get(i);
            minSum += current;
            maxSum += current;
        }
        // System.out.println("Minimum Sum: " + minSum + " Maximum Sum: " + maxSum);
        System.out.println(minSum + " " + maxSum);
    }

    public static void solution2(List<Integer> arr) {
        /* Keep track of minimum and maximum, and the total sum
        * at the end subtract min and max from Sum to get:
        * max and min! Note: outcome is in reverse! */
        long min = 1000000000;
        long max = 0;
        long sum = 0;
        long n = 0;
        for (int i = 0; i < arr.size(); i++) {
            n = arr.get(i);
            sum += n;
            if (max < n) {
                max = n;
            }
            if (min > n) {
                min = n;
            }
        }
        System.out.println((sum - max) + " " + (sum - min) );
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        miniMaxSum(arr);
        solution2(arr);
        // 1, 3, 5, 7, 9
        arr = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        miniMaxSum(arr);
        solution2(arr);
        // 7 69 2 221 8974
        arr = new ArrayList<>(Arrays.asList(7, 69, 2, 221, 8974));
        miniMaxSum(arr);
        byte[] temp = "shahin".getBytes();
        for (int i = 0; i < temp.length - 1; i++) {
            System.out.println(temp[i]);
        }
    }
}

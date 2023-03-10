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

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        miniMaxSum(arr);
        // 1, 3, 5, 7, 9
        arr = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        miniMaxSum(arr);
        // 7 69 2 221 8974
        arr = new ArrayList<>(Arrays.asList(7, 69, 2, 221, 8974));
        miniMaxSum(arr);
    }
}

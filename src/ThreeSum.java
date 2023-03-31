import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    // ThreeSum, Four Sum, and k-sum
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return thrSum(nums, new ArrayList<>(), 0, 1, nums.length - 1);
    }

    private static List<List<Integer>> thrSum(int[] nums, List<List<Integer>> res, int a, int b, int c) {
        if (b == nums.length) return res;
        int temp = c;
        while (temp > b) {
            if (nums[a] + nums[b] == -nums[temp]) {
                List<Integer> candidateList = new ArrayList<>();
                candidateList.add(nums[a]);
                candidateList.add(nums[b]);
                candidateList.add(nums[temp]);
                res.add(candidateList);
                --temp;
            }
            b++;
        }
        return thrSum(nums, res, ++a, ++a, temp);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        StdOut.println("Test 1 - Expecting [[-1, -1, 2], [-1, 0, 1]] Getting: ");
        StdOut.print("[");
        for (List<Integer> l : threeSum(nums)) {
            StdOut.print("[ ");
            StdOut.print(l.get(0));
            for (int i = 1; i <= l.size() - 1; i++) {
                StdOut.print(" ," + l.get(i));
            }
            //StdOut.print(l.get(l.size() - 1));
            StdOut.print(" ] ");
        }
        StdOut.println("]");
    }
}

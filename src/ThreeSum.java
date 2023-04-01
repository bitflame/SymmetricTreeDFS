
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    // ThreeSum, Four Sum, and k-sum
    public static List<List<Integer>> threeSum(int[] nums) {
        int m = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        return sum(3, nums, m, result);
    }

    private static List<List<Integer>> sum(int ksum, int[] nums, int targetIndex, List<List<Integer>> result) {
        if (ksum == 2) {
            for (int i = targetIndex; i > 1; i--) {
                for (List l : twoSum(nums, i)) {
                    l.add(nums[i]);
                    result.add(l);
                    if (nums[i] == nums[i - 1]) i--;
                }
            }
        } else {
            result = sum(--ksum, nums, --targetIndex, result);
            List<List<Integer>> newList = new ArrayList<>();
            for (List l : result) {
                int sum = 0;
                for (Object o : l) {
                    int current = (Integer) o;
                    sum += current;
                }
                if (sum == 0) {
                    newList.add(l);
                }
            }
            result = newList;
        }
        return result;
    }

    private static List<List<Integer>> twoSum(int[] nums, int targetIndex) {
        List<Integer> match = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int target = nums[targetIndex];
        // for (int i = 0; i < nums.length - 2; i++) {
        for (int i = 0; i < targetIndex - 1; i++) {
            //if (i == targetIndex) continue;
            //for (int j = i + 1; j < nums.length - 1; j++) {
            for (int j = i + 1; j < targetIndex; j++) {
                //if (j == targetIndex) continue;
                if (nums[i] + nums[j] == -target) {
                    if (match.isEmpty()) {
                        match.add(nums[i]);
                        match.add(nums[j]);
                        result.add(match);
                    } else if (match.get(0) != nums[i] && match.get(1) != nums[j]) {
                        match = new ArrayList<>();
                        match.add(nums[i]);
                        match.add(nums[j]);
                        result.add(match);
                    }
                }
            }
        }
        return result;
    }

    private static List<List<Integer>> test(int[] nums, List<List<Integer>> result, int targetIndex) {
        result.get(0).add(nums[targetIndex]);
        return test(nums, result, --targetIndex);
    }

    private static void printList(List<List<Integer>> list) {
        StdOut.print("[");
        for (List<Integer> l : list) {
            StdOut.print("[");
            StdOut.print(l.get(0));
            for (int i = 1; i <= l.size() - 1; i++) {
                StdOut.print(" ," + l.get(i));
            }
            StdOut.print("]");
        }
        StdOut.println("]");
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        StdOut.println("Test 1 - Expecting [[-1, -1, 2], [-1, 0, 1]] Getting: ");
        printList(threeSum(nums));
        nums = new int[]{0, 1, 1};
        StdOut.print("Test 2 - Expecting [] Getting: ");
        printList(threeSum(nums));
        nums = new int[]{0, 0, 0};
        StdOut.print("Test 3 - Expecting [0, 0, 0] Getting: ");
        printList(threeSum(nums));
        nums = new int[]{-2, 0, 0, 2, 2};
        StdOut.print("Test 4 - Expecting [-2,0,2] Getting: ");
        printList(threeSum(nums));
        nums = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        StdOut.print("Test 5 - Expecting [[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]] Getting: ");
        printList(threeSum(nums));
        // [0,2,2,3,0,1,2,3,-1,-4,2]
        nums = new int[]{0, 2, 2, 3, 0, 1, 2, 3, -1, -4, 2};
        StdOut.print("Test 6 - Expecting [[-4,1,3],[-4,2,2],[-1,0,1]] Getting: ");
        printList(threeSum(nums));
    }
}

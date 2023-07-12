import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// code from leetCode https://leetcode.com/problems/4sum/editorial/
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length) return res;
        long average_value = target / k;
        if (nums[start] > average_value || nums[nums.length - 1] < average_value) return res;
        if (k == 2) return twoSum(nums, target, start);
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));// add the latest number first,
                    res.get(res.size() - 1).addAll(subset);//  then take out what you just added, add all the other content of the subset to it
                    // and add all of them to the list
            }
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
                hi--;
            } else {
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
            }
        }
        return res;
    }
// k is the number of items in the list, so for 4-sum it starts at 4 and stops at 2
//
//    public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (start == nums.length) return res;
//        long average_value = target / k;
//        if (nums[start] > average_value || average_value > nums[nums.length - 1]) return res;
//        if (k == 2) return twoSum(nums, target, start);
//        for (int i = start; i < nums.length; ++i) {
//            if (i == start || nums[i - 1] != nums[i]) {
//                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
//                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
//                    res.get(res.size() - 1).addAll(subset);
//                }
//            }
//        }
//        return res;
//    }
//
//    public List<List<Integer>> twoSum(int[] nums, long target, int start) {
//        List<List<Integer>> res = new ArrayList<>();
//        int lo = start, hi = nums.length - 1;
//        while (lo < hi) {
//            int currSum = nums[lo] + nums[hi];
//            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
//                ++lo;
//            } else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
//                hi--;
//            } else {
//                res.add(Arrays.asList(nums[lo++], nums[hi--]));
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        FourSum f = new FourSum();
        for (List l : f.fourSum(nums, 0)) System.out.println(l);

    }
}

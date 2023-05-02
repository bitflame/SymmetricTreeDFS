public class FindMedianSortedArray {
    public double findMedianSortedArray(int[] nums1, int[] nums2) {
        double result = 0;
        // if the medians of each are the same value return it, else calculate the median of that value
        double med1 = 0, med2 = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 != 0) {
            if (nums1[len1 - 1] < nums2[0]) {
                return (double) (nums1[len1 - 1] + nums2[0]) / 2;
            } else if (nums2[len2 - 1] < nums1[0]) return (double) (nums2[len2 - 1] + nums1[0]) / 2;
            if (len1 % 2 == 0) {
                med1 = (double) (nums1[len1 / 2] + nums1[(len1 / 2) - 1]) / 2;
            } else {
                med1 = nums1[len1 / 2];
            }
        }
        if (len2 != 0) {
            if (nums1[len1 - 1] < nums2[0]) {
                return (double) (nums1[len1] + nums2[0]) / 2;
            } else if (nums2[len2 - 1] < nums1[0]) return (double) (nums2[len2 - 1] + nums1[0]) / 2;
            if (len2 % 2 == 0) {
                med2 = (double) (nums2[len2 / 2] + nums2[(len2 / 2) - 1]) / 2;
            } else {
                med2 = nums2[len2 / 2];
            }
        }
        if (len1 == 0) return med2;
        else if (len2 == 0) return med1;
        else if (med1 >= med2) {
            return med1;
        } else return med2;

    }

    public double findMedian(int[] nums1, int[] nums2) {
        int a = 0, b = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int totalLen = len1 + len2;
        int mid = 0, nextToMid = 0;
        if (len1 > 0) mid = nums1[a];
        if (len2 > 0) mid = nums2[b];
        while (a < len1 && a < len2) {
            if (nums1[a] < nums2[a]) {
                mid = nums1[a];
                nextToMid = nums2[a];

            } else {
                mid = nums2[a];
                nextToMid = nums1[a];
            }
            a++;
        }
        if (totalLen % 2 == 0) {
            return (double) (mid + nextToMid) / 2;
        } else {
            return mid;
        }
    }


    public static void main(String[] args) {
        FindMedianSortedArray findMedianSortedArray = new FindMedianSortedArray();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        // System.out.println("Expected Value: 2.0; Actual Value: " + findMedianSortedArray.findMedianSortedArray(nums1, nums2));
        System.out.println("Test 1 - Result of findMedian - Expected Value: 2.0; Actual Value: " + findMedianSortedArray.findMedian(nums1, nums2));
        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        // System.out.println("Expected Value: 2.5; Actual Value: " + findMedianSortedArray.findMedianSortedArray(nums1, nums2));
        System.out.println("Test 2 - Result of findMedian - Expected Value: 2.5; Actual Value: " + findMedianSortedArray.findMedian(nums1, nums2));
        nums1 = new int[]{0, 0};
        nums2 = new int[]{0, 0};
        // System.out.println("Expected Value: 0.0; Actual Value: " + findMedianSortedArray.findMedianSortedArray(nums1, nums2));
        System.out.println("Test 3 - Result of findMedian - Expected Value: 0.0; Actual Value: " + findMedianSortedArray.findMedian(nums1, nums2));
        nums1 = new int[]{};
        nums2 = new int[]{1};
        // System.out.println("Expected Value: 1.0; Actual Value: " + findMedianSortedArray.findMedianSortedArray(nums1, nums2));
        System.out.println("Test 4 - Result of findMedian - Expected Value: 1.0; Actual Value: " + findMedianSortedArray.findMedian(nums1, nums2));
        nums1 = new int[]{2, 7};
        nums2 = new int[]{1, 3};
        // System.out.println("Expected Value: 2.5; Actual Value: " + findMedianSortedArray.findMedianSortedArray(nums1, nums2));
        System.out.println("Test 5 - Result of findMedian - Expected Value: 2.5; Actual Value: " + findMedianSortedArray.findMedian(nums1, nums2));
        nums1 = new int[]{1};
        nums2 = new int[]{};
        System.out.println("Test 6 - Result of findMedian - Expected Value: 1.0; Actual Value: " + findMedianSortedArray.findMedian(nums1, nums2));
        nums1 = new int[]{1, 2, 3, 7};
        nums2 = new int[]{};
        System.out.println("Test 7 - Result of findMedian - Expected Value: 2.5; Actual Value: " + findMedianSortedArray.findMedian(nums1, nums2));
    }
}

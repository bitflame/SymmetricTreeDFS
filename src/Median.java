import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Median {
    public static int findMedian(List<Integer> arr) {
        Collections.sort(arr);
        int mid = arr.size() / 2;
        return arr.get(mid);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(5, 3, 1, 2, 4));
        System.out.println(findMedian(arr));
        arr = new ArrayList<>(Arrays.asList(1, 3, 3, 6, 7, 8, 9));
        System.out.println(findMedian(arr));
    }
}

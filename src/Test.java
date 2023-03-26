
import java.util.*;

public class Test {

    public static List<Integer> getMinimumValues(List<Integer> arr) {
        int index = 0;
        int current ;
        List<Integer> outcome = new ArrayList<>();
        while (index < arr.size()) {
            current = arr.get(index);
            if (current == 1) {
                outcome.add(current);
                index++;
                continue;
            }
            if (current - 4 > 0) {
                int result = (int) (Math.log(current) / Math.log(2));
                if (result > 1) outcome.add(result);
            } else outcome.add(-1);
            index++;
        }
        return outcome;
    }

    public static int reduceTeamSize(List<Integer> teamSize, int k) {
// find the median team sizes more than max and closest to the max
        int index = 0;
        int result = 0;
        int current;
        Collections.sort(teamSize);
        int median = teamSize.size() / 2;
        while (index < teamSize.size()) {
            current = teamSize.get(index);
            if (current > median) {
                result++;
            } else if (current == median) result++;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>(Arrays.asList(5, 1, 4, 6, 10));
        System.out.println(getMinimumValues(nums));
        System.out.println(Math.log(2));
        System.out.println(Math.log(4) / Math.log(2));
        System.out.println(Math.log(8) / Math.log(2));
        System.out.println(Math.log(16) / Math.log(2));
        /********************************************************************/
        List<Integer> teamSize = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4));
        System.out.println(reduceTeamSize(teamSize, 2));

    }
}

import java.util.*;

public class LonelyInteger {
    public static int findLonelyInteger(List<Integer> a) {
        Set<Integer> nums = new HashSet<>();
        int current;
        // int unique = 0;
        int index = 0;
        while (index < a.size()) {
            current = a.get(index);
            if (!nums.contains(current)) {
                nums.add(current);
                // unique=current;
            } else nums.remove(current);
            index++;
        }
        return (Integer) nums.toArray()[0];
        // return unique;
    }

    public static int solutionTwo(List<Integer> a) {
        Collections.sort(a);
        int result = 0;
        for (int i = 0; i < a.size(); i += 2) {
            if (i == a.size() - 1) {
                // it is the last item ...
                result = a.get(i);
                break;
            }
            if (!a.get(i).equals(a.get(i + 1)) ) {
                result = a.get(i);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 3, 2, 1));
        System.out.println("Expecting: 4, Getting: " + findLonelyInteger(arr));
        System.out.println("Expecting: 4, Getting: " + solutionTwo(arr));
        arr = new ArrayList<>(Arrays.asList(1, 1, 3, 2, 2, 3, 4));
        System.out.println("Expecting: 4, Getting: " + findLonelyInteger(arr));
        System.out.println("Expecting: 4, Getting: " + solutionTwo(arr));
        arr = new ArrayList<>(Arrays.asList(1, 1, 2));
        System.out.println("Expecting: 2, Getting: " + findLonelyInteger(arr));
        System.out.println("Expecting: 2, Getting: " + solutionTwo(arr));
        arr = new ArrayList<>(Arrays.asList(4, 9, 95, 93, 57, 4, 57, 93, 9));
        System.out.println("Expecting: 95, Getting: " + findLonelyInteger(arr));
        System.out.println("Expecting: 95, Getting: " + solutionTwo(arr));
    }
}

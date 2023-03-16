
import java.util.*;

public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        Map<Character, char[]> mapping = new HashMap<>();
        mapping.put('1', new char[]{});
        mapping.put('0', new char[]{});
        mapping.put('2', new char[]{'a', 'b', 'c'});
        mapping.put('3', new char[]{'d', 'e', 'f'});
        mapping.put('4', new char[]{'g', 'h', 'i'});
        mapping.put('5', new char[]{'j', 'k', 'l'});
        mapping.put('6', new char[]{'m', 'n', 'o'});
        mapping.put('7', new char[]{'p', 'q', 'r', 's'});
        mapping.put('8', new char[]{'t', 'u', 'v'});
        mapping.put('9', new char[]{'w', 'x', 'y', 'z'});
        return letterCombinations(mapping, digits, 0, null);
    }

    public static List<String> letterCombinations(Map<Character, char[]> mapping, String digits, int index, List<String> current) {
        if (current != null && current.get(0).length() == digits.length()) return current;
        List<String> tempList = new ArrayList<>();
        if (current == null) {
            for (char temp : mapping.get(digits.charAt(index))) {
                tempList.add("" + temp);
            }
        } else {
            for (String s : current) {
                for (char temp : mapping.get(digits.charAt(index))) {
                    tempList.add(s.concat("" + temp));
                }
            }
        }
        return letterCombinations(mapping, digits, ++index, tempList);
    }

    public static void main(String[] args) {
        //"ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println("Expecting: [A, B, C], Getting: " + letterCombinations("2"));
        System.out.println("Expecting: [AD, AE, AF, BD, BE, BF, CD, CE, CF] Getting: " + letterCombinations("23"));
        System.out.println(letterCombinations(""));
    }
}

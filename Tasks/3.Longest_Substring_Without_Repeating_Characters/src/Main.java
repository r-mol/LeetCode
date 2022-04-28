import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int max = 0;
        Map<Character, Boolean> map = new HashMap<>();
        ArrayList<String> list;

        for (int i = 0; i < s.length(); i++) {
            list = new ArrayList<>();
            for (int j = i; j < s.length(); j++) {
                if (!list.contains(String.valueOf(s.charAt(j)))) {
                    length++;
                    if (length > max) {
                        max = length;
                    }

                    list.add(String.valueOf(s.charAt(j)));
                } else {
                    length = 0;
                }
            }
            length = 0;
        }

        return max;
    }
}

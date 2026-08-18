import java.util.*;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {

            String word = words[i];
            int len = word.length();

            for (int j = 0; j <= len; j++) {

                String left = word.substring(0, j);
                String right = word.substring(j);

                if (isPalindrome(left)) {
                    String reversedRight = reverse(right);

                    if (map.containsKey(reversedRight)) {
                        int index = map.get(reversedRight);

                        if (index != i) {
                            result.add(Arrays.asList(index, i));
                        }
                    }
                }
                if (j < len && isPalindrome(right)) {
                    String reversedLeft = reverse(left);

                    if (map.containsKey(reversedLeft)) {
                        int index = map.get(reversedLeft);

                        if (index != i) {
                            result.add(Arrays.asList(i, index));
                        }
                    }
                }
            }
        }
        return result;
    }
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
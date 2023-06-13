import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<String, Boolean> memo;

    public boolean isScramble(String s1, String s2) {
        memo = new HashMap<>();
        return isScrambleHelper(s1, s2);
    }

    private boolean isScrambleHelper(String s1, String s2) {
        String key = s1 + "#" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (s1.equals(s2)) {
            memo.put(key, true);
            return true;
        }

        if (!isAnagram(s1, s2)) {
            memo.put(key, false);
            return false;
        }

        int length = s1.length();
        for (int i = 1; i < length; i++) {
            if (isScrambleHelper(s1.substring(0, i), s2.substring(0, i)) &&
                isScrambleHelper(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }

            if (isScrambleHelper(s1.substring(0, i), s2.substring(length - i)) &&
                isScrambleHelper(s1.substring(i), s2.substring(0, length - i))) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    private boolean isAnagram(String s1, String s2) {
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }
}

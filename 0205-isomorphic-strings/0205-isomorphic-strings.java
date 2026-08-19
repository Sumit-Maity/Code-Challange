class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        char[] sToT = new char[128];
        char[] tToS = new char[128];

        boolean[] usedS = new boolean[128];
        boolean[] usedT = new boolean[128];

        for (int i = 0; i < s.length(); i++) {

            char a = s.charAt(i);
            char b = t.charAt(i);
            if (usedS[a]) {
                if (sToT[a] != b) {
                    return false;
                }
            } else {
                sToT[a] = b;
                usedS[a] = true;
            }
            if (usedT[b]) {
                if (tToS[b] != a) {
                    return false;
                }
            } else {
                tToS[b] = a;
                usedT[b] = true;
            }
        }
        return true;
    }
}
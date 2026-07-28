class Solution {

    private Map<Integer, Boolean> memo = new HashMap<>();
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return true;
        }
        int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
        if (sum < desiredTotal) {
            return false;
        }
        return dfs(0, desiredTotal, maxChoosableInteger);
    }

    private boolean dfs(int mask, int target, int max) {

        if (memo.containsKey(mask)) {
            return memo.get(mask);
        }
        for (int i = 1; i <= max; i++) {
            int bit = 1 << (i - 1);

            if ((mask & bit) != 0) {
                continue;
            }
            if (i >= target) {
                memo.put(mask, true);
                return true;
            }
            if (!dfs(mask | bit, target - i, max)) {
                memo.put(mask, true);
                return true;
            }
        }
        memo.put(mask, false);
        return false;
    }
}
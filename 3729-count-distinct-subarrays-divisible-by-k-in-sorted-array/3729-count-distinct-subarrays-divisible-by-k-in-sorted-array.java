import java.util.*;

class Solution {
    public long numGoodSubarrays(int[] nums, int k) {

        long ans = 0;
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        int sum = 0;
        for (int num : nums) {
            sum = (sum + num) % k;

            ans += count.getOrDefault(sum, 0);

            count.put(sum, count.getOrDefault(sum, 0) + 1);
        }
        int n = nums.length;

        for (int i = 0; i < n; ) {

            int j = i + 1;
            while (j < n && nums[j] == nums[i]) {
                j++;
            }

            int length = j - i;
            for (int h = 1; h <= length; h++) {

                if (1L * nums[i] * h % k == 0) {
                    ans -= (length - h);
                }
            }
            i = j;
        }
        return ans;
    }
}
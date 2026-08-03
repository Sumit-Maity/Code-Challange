class Solution {
    public long maxScore(int[] nums, int x) {
        long NEG = Long.MIN_VALUE / 2;

        long even = NEG;
        long odd = NEG;
        if (nums[0] % 2 == 0) {
            even = nums[0];
        } else {
            odd = nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                even = Math.max(even + nums[i], odd + nums[i] - x);
            } else {
                odd = Math.max(odd + nums[i], even + nums[i] - x);
            }
        }
        return Math.max(even, odd);
    }
}
from collections import defaultdict

class Solution:
    def findTargetSumWays(self, nums, target):
        dp = {0: 1}  

        for num in nums:
            next_dp = defaultdict(int)
            for s, count in dp.items():
                next_dp[s + num] += count
                next_dp[s - num] += count
            dp = next_dp

        return dp.get(target, 0)
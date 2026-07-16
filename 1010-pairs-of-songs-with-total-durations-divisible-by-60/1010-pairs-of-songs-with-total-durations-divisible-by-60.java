class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] freq = new int[60];
        int count = 0;
        for (int t : time) {
            int rem = t % 60;
            int complement = (rem == 0) ? 0 : 60 - rem;

            count += freq[complement];
            freq[rem]++;
        }
        return count;
    }
}
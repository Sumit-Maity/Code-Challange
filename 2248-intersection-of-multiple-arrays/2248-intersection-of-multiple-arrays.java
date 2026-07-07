import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> intersection(int[][] nums) {

        int[] counts = new int[1001];
        
        for (int[] row : nums) {
            for (int num : row) {
                counts[num]++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        int totalArrays = nums.length;

        for (int i = 1; i <= 1000; i++) {
            if (counts[i] == totalArrays) {
                result.add(i);
            }
        }     
        return result;
    }
}
import java.util.HashMap;

public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefixSum = 0;
        int result = 0;
        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1);  // Initialize with remainder 0 count as 1
        
        for (int num : nums) {
            prefixSum += num;
            int remainder = prefixSum % k;
            
            if (remainder < 0) {
                remainder += k;
            }
            
            result += remainderCount.getOrDefault(remainder, 0);
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }
        
        return result;
    }
}

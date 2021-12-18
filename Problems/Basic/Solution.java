import java.util.HashMap;
import java.util.Map;

// Two Sum problem

public class Solution {
    public int[] twoSum(int[] data, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < data.length; ++i){
            int remainder = target - data[i];

            if (map.containsKey(remainder)){
                result[1] = i;
                result[0] = map.get(remainder);
                return result;
            }
            map.put(data[i], i);
        }
        return result;
    }
}
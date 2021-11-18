package number;

/**
 * @author Albina Gimaletdinova on 18/11/2021
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] arr) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (duplicates.add(arr[i])) {
                for (int j = i + 1; j < arr.length; j++) {
                    int complement = -arr[i] - arr[j];
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(
                                arr[i], arr[j], complement
                        );
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(arr[j], i);
                }
            }
        }
        return new ArrayList<>(res);
    }
}
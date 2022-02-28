package arrays;

/**
 * @author Albina Gimaletdinova on 28/02/2022
 */
public class NumberOfArithmeticTriplets {

    public int arithmeticTriplets(int[] arr, int diff) {
        Set<Integer> seen = new HashSet<>();

        int res = 0;
        for (int n : arr) {
            if (seen.contains(n - diff) && seen.contains(n - 2 * diff)) {
                res++;
            }
            seen.add(n);
        }
        return res;
    }

    // VERY SLOW
//     public int arithmeticTriplets(int[] arr, int diff) {
//         Set<List<Integer>> res = new HashSet<>();
//         Set<Integer> set = new HashSet<>();

//         for (int i = 0; i < arr.length; i++) {
//             set.add(arr[i]);
//             for (int j = i + 1; j < arr.length; j++) {
//                 int curDiff = arr[j] - arr[i];
//                 if (curDiff == diff) {
//                     int thirdElement = arr[i] - diff;
//                     if (set.contains(thirdElement)) {
//                         List<Integer> triplet = Arrays.asList(thirdElement, arr[i], arr[j]);
//                         Collections.sort(triplet);
//                         res.add(triplet);
//                     }
//                 }
//                 set.add(arr[j]);
//             }
//         }
//         return res.size();
//     }
}

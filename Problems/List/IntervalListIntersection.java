package arrays;

/**
 * @author Albina Gimaletdinova on 18/02/2022
 */
public class IntervalListIntersection {
    public int[][] intervalIntersection(int[][] arr1, int[][] arr2) {
        int i = 0, j = 0;

        List<int[]> res = new ArrayList<>();
        while (i < arr1.length && j < arr2.length) {
            int from = Math.max(arr1[i][0], arr2[j][0]);
            int to = Math.min(arr1[i][1], arr2[j][1]);
            if (from <= to) {
                res.add(new int[]{from, to});
            }

            if (arr1[i][1] < arr2[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}

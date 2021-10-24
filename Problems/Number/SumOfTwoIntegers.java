package number;

/**
 * @author Albina Gimaletdinova on 24/10/2021
 */
public class Solution {
    public int getSum(int a, int b) {
        // bitwise sum using last bits
        // 1+1=10, 0 for result, 1 for the next step and so on

        // loop for 32 bits (as we sum integers)
        // get last bit per num
        int result = 0;
        int shift = 0;
        for (int i = 0; i < 32; i++) {
            boolean currentBitA = getBit(i, a);
            boolean currentBitB = getBit(i, b);

            int currentBit = 0;
            if (currentBitA && currentBitB) {
                currentBit |= shift;
                shift = 1;
            } else if (currentBitA || currentBitB) {
                if (shift == 1) {
                    currentBit = 0;
                    shift = 1;
                } else {
                    currentBit = 1;
                    // shift = 0;
                }
            } else {
                currentBit = shift;
                shift = 0;
            }

            if (currentBit == 1) {
                result = setBit(i, result);
            }
        }
        return result;
    }

    private boolean getBit(int index, int num) {
        int mask = 1 << index;
        return ((num >> index) & 1) == 1;
    }

    private int setBit(int index, int num) {
        int mask = 1 << index;
        return num | mask;
    }
}

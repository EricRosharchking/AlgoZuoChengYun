package lesson8;

public class MaxValueInBag {

    public static void main(String[] args) {
        System.out.println(getMaxValue(new int[]{2,4,6}, new int[]{1,2,6}, 0, 0, 7));
    }

    public static int getMaxValue(int[] values, int[] weights, int i, int currWeight, int bag) {
        if (i == values.length) {
            return 0;
        }
        if (currWeight > bag) {
            return 0;
        }
        if (currWeight + weights[i] > bag) {
            return getMaxValue(values, weights, i + 1, currWeight, bag);
        }
        return Math.max(getMaxValue(values, weights, i + 1, currWeight, bag),
                values[i] + getMaxValue(values, weights, i + 1, currWeight + weights[i], bag));
    }
}

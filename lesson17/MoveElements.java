package lesson17;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MoveElements {
    // magic operation: move one element from one collection to another so that
    // afterwards, the average of both collections are bigger than before

    public static int magicOperations(int[] a, int[] b) {
        double suma = 0d;
        for (int i: a) {
            suma += (double)i;
        }
        double sumb = 0d;
        for (int i: b) {
            sumb += (double)i;
        }

        if (suma == sumb) {
            return 0;
        }
        int[] arr1 = null;
        int[] arr2 = null;
        double sum1 = 0;
        double sum2 = 0;
        if (avg(suma, a.length) > avg(sumb, b.length)) {
            arr1 = a;
            sum1 = suma;
            arr2 = b;
            sum2 = sumb;
        } else {
            arr1 = b;
            sum1 = sumb;
            arr2 = a;
            sum2 = suma;
        }
        Arrays.sort(arr1);
        Set<Integer> set = new HashSet<>();
        for (int i: arr2) {
            set.add(i);
        }
        int size1 = arr1.length;
        int size2 = arr2.length;

        int res = 0;
        for (int i = 0; i < arr1.length; i++) {
            double curr = (double) arr1[i];
            if (curr < avg(sum1, size1) && curr > avg(sum2, size2) && !set.contains(arr1[i])) {
                sum1 -= curr;
                size1--;
                sum2 += curr;
                size2++;
                set.add(arr1[i]);
                res++;
            }
        }
        return res;
    }

    public static double avg(double sum, int length) {
        return sum / (double) length;
    }
}

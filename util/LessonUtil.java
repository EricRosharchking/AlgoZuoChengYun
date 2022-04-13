package util;

import java.util.Random;

public class LessonUtil {
    
    public static int[] generatePositiveIntArray(int length, int max) {
        return new Random().ints(length, 0, max).toArray();
    }
}

package lesson17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerPairsWithDifferenceOfK {
    
    public static List<int[]> solution(int[] arr, int k) {
        List<int[]> res = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i: arr) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i)+1);
            }
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); i++) {
            Integer key = keys.get(i);
            if (map.containsKey(key+k)) {
                res.add(new int[]{key, key+k});
            }
        }
        return res;
    }
}

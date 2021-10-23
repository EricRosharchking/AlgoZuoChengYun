package lesson7;

import java.util.Arrays;
import java.util.Comparator;

public class ActivityPlan {

    static class ActivityComparator implements Comparator<Activity> {

        @Override
        public int compare(Activity o1, Activity o2) {
            // TODO Auto-generated method stub
            return o1.end - o2.end;
        }

    }

    public static int maxActivities(Activity[] arr, int startTime) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int res = 0;
        int currTime = startTime;
        Arrays.sort(arr, new ActivityComparator());
        for (int i = 0; i < arr.length; i++) {
            if (currTime < arr[i].start) {
                currTime = arr[i].end;
                res++;
            }
        }
        return res;
    }
}

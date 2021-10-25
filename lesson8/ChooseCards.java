package lesson8;

public class ChooseCards {
    
    public static void main(String[] args) {
        int[] arr = new int[10];
        ChooseCards c = new ChooseCards();
        System.out.println(Math.max(c.f(arr, 1, arr.length-1), c.s(arr, 0, arr.length-2)));
    }

    public int f(int[] arr, int l, int r) { // 先手拿到的是拿一张后下一次拿更大的那个
        if (l == r) {
            return arr[l];
        } else {
            return Math.max(arr[l] + s(arr, l+1, r), arr[r] + s(arr, l, r-1));
        }
    }

    public int s(int[] arr, int l, int r) {// 后手拿到的是另一个玩家拿完剩下的那个，是更小的那个
        if (l == r) {
            return 0;
        } else {
            return Math.min(arr[l] + f(arr, l+1, r), arr[r] + f(arr, l, r-1));
        }
    }
}

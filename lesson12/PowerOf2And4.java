package lesson12;

public class PowerOf2And4 {

    public static boolean isPowerOf2(int x) {
        return (x & (x - 1)) == 0;
    }

    public static boolean isPowerOf4(int x) {
        // 0x55555555: hexadecimal representation of 0b0101010101..01010101
        return isPowerOf2(x) && (x & 0x55555555) != 0;
    }
}

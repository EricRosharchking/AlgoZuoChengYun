package lesson1;

public class XOR {
    public static void main(String[] args) {

        int a = 254;
        int b = 1234;

        int xor = a ^ b;

        System.out.println(a + ": " + toBinary(a));
        System.out.println(b + ": " + toBinary(b));
        System.out.println(xor + ": " + toBinary(xor));
        int rightOne = xor & (~xor + 1);

        System.out.println(rightOne + ": " + toBinary(rightOne));
        System.out.println((rightOne & b) + ": " + toBinary(rightOne & b));
        System.out.println((rightOne & a) + ": " + toBinary(rightOne & a));
    }

    public static String toBinary(int n)
    {
        String binary = "";
        for (long i = (1L << 32 - 1); i > 0; i = i / 2) {
            binary += (n & i) != 0 ? "1" : "0";
        }
        return binary;
    }
}

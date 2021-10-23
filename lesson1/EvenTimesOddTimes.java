package lesson1;

public class EvenTimesOddTimes {
    /**
     * Given an array of integers, 
     * 
     * 1. There is only one number a that occurs an odd time, the rest all occur some even times, find a
     * 
     * 2. There are two numbers a, b that occur odd times, the rest all occur some even times, find a, b
     */


     public static void main(String[] args) {


     }

     public static void printOddTimesNum1(int[] arr) {
         int eor = 0;
         for (int i: arr) {
             eor ^= i;
         }

         System.out.println(eor);
     }

     public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i: arr) {
            eor ^= i;
        }
        //eor = a ^ b
        //eor != 0
        //eor 必然有一位上是1

        int rightOne = eor & (~eor + 1);//提取出eor中最右位的1
        // eor 与(&) 反eor(~eor)+1

        int onlyOne = 0; // eor'

        for (int i: arr) {
            if ((i & rightOne) == 1) { //最右位为1的数
                onlyOne ^= i;
            }
        }

        System.out.println(onlyOne + " " + (eor ^ onlyOne));
     }
}

package lesson10;

public class BitMap {
    // 10 ints means 4bytePerInt*8bitsPerByte*10ints = 320bits information
    // arr[0] int : bits of 0 ~ 31
    // arr[1] int : bits of 32 ~ 63
    // arr[2] int : bits of 64 ~ 95
    int[] arr = new int[10]; 

    public int getBit(int i) {
        // the numIndex-th int in the array that contains the i-th bit requested
        int numIndex = i / 32;
        // the bitIndex-th bit of the above int that contains the i-th bit requested
        int bitIndex = i % 32;
        return (arr[numIndex] >> bitIndex) & 1;
    }

    public void setToOne(int i) {
        int numIndex = i / 32;
        int bitIndex = i % 32;
        arr[numIndex] = arr[numIndex] | (1 << bitIndex);
    }

    public void setToZero(int i) {
        int numIndex = i / 32;
        int bitIndex = i / 32;
        arr[numIndex] = arr[numIndex] & (~ (1 << bitIndex));
    }
}

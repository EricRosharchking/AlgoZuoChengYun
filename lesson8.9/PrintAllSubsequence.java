package lesson8;

import java.util.HashSet;
import java.util.Set;

public class PrintAllSubsequence {
    
    public static void main(String[] args) {
        String str = "abc";
        char[] chars = str.toCharArray();
        PrintAllSubsequence p = new PrintAllSubsequence();
        Set<String> set = new HashSet<>();
        p.f(chars, 0, "", set);
        System.out.print(set.size() + ":");
        System.out.println(set.toString());
    }

    public void f(char[] chars, int index, String str, Set<String> set) {
        if (index == chars.length) {
            set.add(str);
        } else {
            f(chars, index + 1, str + chars[index], set);
            f(chars, index + 1, str, set);
        }
    }

    public void g(char[] chars, int index, Set<String> set) { // 更省空间的方法 重复利用了chars来代表str
        if (index == chars.length) {
            set.add(String.valueOf(chars));
        } else {
            g(chars, index + 1, set);
            char temp = chars[index];
            chars[index] = 0;
            g(chars, index + 1, set);
            chars[index] = temp;
        }
    }
}

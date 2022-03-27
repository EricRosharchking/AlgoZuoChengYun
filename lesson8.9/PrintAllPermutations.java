package lesson8;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutations {

    public static void main(String[] args) {
        String str = "abc";
        char[] chars = str.toCharArray();
        List<String> list = new ArrayList<>();
        PrintAllPermutations p = new PrintAllPermutations();
        p.f(chars, 0, list);
        System.out.print(list.size()+":");
        System.out.println(list.toString());
    }

    public void f(char[] chars, int index, List<String> list) {
        if (index == chars.length) {
            list.add(String.valueOf(chars));
        } else {
            boolean[] visited = new boolean[26];
            for (int i = index; i < chars.length; i++) {
                if (!visited[chars[i] - 'a']) {
                    visited[chars[i] - 'a'] = true;
                    swap(chars, i, index);
                    f(chars, index + 1, list);
                    swap(chars, i, index);
                }
            }
        }
    }

    public void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}

package lesson16;

public class NeedParentheses {
    
    public static int process(String str) {
        int leftParentheses = 0;
        int rightParenttheses = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                leftParentheses ++;
            } else {
                if (leftParentheses == 0) {
                    rightParenttheses ++;
                } else {
                    leftParentheses --;
                }
            }
        }
        return leftParentheses + rightParenttheses;
    }
}

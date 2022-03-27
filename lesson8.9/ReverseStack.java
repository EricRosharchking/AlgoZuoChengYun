package lesson8;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);
        // Queue<Integer> queue = new LinkedList<>();
        // queue.add(1);
        // queue.add(2);
        // queue.add(3);
        // while (!queue.isEmpty()) {
        // System.out.println(queue.poll());
        // }
        // System.out.println(queue);
        reverse(stack);
        System.out.println(stack);
    }

    public static void reverse(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            return;
        }
        int i = f(stack);
        reverse(stack);
        System.out.println(i);
        stack.push(i);
    }

    public static Integer f(Stack<Integer> stack) {
        int i = stack.pop();
        if (stack.isEmpty()) {
            // System.out.println(i);
            return i;
        } else {
            int last = f(stack);
            stack.push(i);
            return last;
        }
    }

}

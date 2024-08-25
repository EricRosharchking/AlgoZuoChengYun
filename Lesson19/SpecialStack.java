package Lesson19;

public class SpecialStack {
    
    // all methods has time of O(1)

    // two stack, one is the data stack, the other is the smallest element stack
    // when pushing to data stack, compare with the smallest element, if smaller, smallest element stack the smallest element
    // so the smallest element stack will contain multiple smallest element

    // when popping, pop from data stack and smallest element stack at the same time, but because the smallest element stack
    // has multiple smallest element, so the getMin() method will always return correct result with O(1)
    public void pop() {

    }

    public void push() {

    }
    
    public void getMin() {

    }
}

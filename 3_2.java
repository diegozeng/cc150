/**
 * 3.2 How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 *
 * 思路:新建一个队列minValues专门用来存放原队列s中的最小值，minValues的peek始终存放着s队列中的最小值。
 *
 * 时间复杂度:O(1)（traverse是后来为了测试加的，除了这个方法，push，pop，min都是O(1)）
 * 空间复杂度:O(n)
 *
 * Test case:参照书本题目的例子
 */

import java.util.Stack;

class MinStack {
    private static Stack<Integer> s;
    private static  Stack<Integer> minValues;
    public MinStack() {
        s = new Stack<Integer>();
        minValues = new Stack<Integer>();
    }

    public static void push(int element) {
        s.push(element);
        if(minValues.empty() || element <= minValues.peek()) {
            minValues.push(element);
        }
    }

    public static Integer pop() {
        if(minValues.peek() < s.peek()) {
            return s.pop();
        } else {
            minValues.pop();
            return s.pop();
        }
    }

    public static Integer min() {
        return minValues.peek();
    }
    
    public static void traverse() {
        System.out.print("stack is { ");
        for (Integer x : s) {
            System.out.print(x+" ");
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        push(5);
        traverse();
        System.out.println("min is "+ min());
        System.out.println(" ");
        push(6);
        traverse();
        System.out.println("min is "+ min());
        System.out.println(" ");
        push(3);
        traverse();
        System.out.println("min is "+ min());
        System.out.println(" ");
        push(7);
        traverse();
        System.out.println("min is "+ min());
        System.out.println(" ");
        int a = pop();
        System.out.println("pops " +a + ".");
        traverse();
        System.out.println("min is "+ min());
        System.out.println(" ");
        int b = pop();
        System.out.println("pops " +b + ".");
        traverse();
        System.out.println("min is "+ min());
        System.out.println(" ");
    }
}

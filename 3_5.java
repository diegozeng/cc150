/**
 * 3.5 Implement a MyQueue class which implements a queue using two stacks.
 *
 * 思路:用两个stack，栈尾靠栈尾,一个专门供enqueue（记作add），另一个专门用来dequeue （记作remove），每次enqueue，直接把元素push进pushStack，每次dequeue，优先从popStack中pop元素，如果没有元素，就将pushStack中的元素全部push进popStack，再从popstack里pop元素。
 *
 * 时间复杂度: enqueue: O(1); dequeue: worst O(n), amortized O(1).
 * 空间复杂度: O(n)
 *
 * Test case: 考虑queue为空时dequeue抛错的情况
 */

import java.util.Stack;

class MyQueue<T> {
    private Stack<T> stackNewest, stackoldest;
    
    public MyQueue() {
        stackNewest = new Stack<T>();
        stackoldest = new Stack<T>();
    }
    
    public int size() {
        return stackNewest.size() + stackoldest.size();
    }
    
    public void add(T value) {
        stackNewest.push(value);
    }
    
    protected void shiftStacks() {
        if (stackoldest.isEmpty()) { //一定要空了再shift
            while(!stackNewest.isEmpty()) {
                stackoldest.push(stackNewest.pop());
            }
        }
    }
    
    public T peek() {
        if (this.isEmpty()) {
            System.out.println("Empty queue! Cannot peek!");
            return null;
        }
        shiftStacks();
        return stackoldest.peek();
    }
    
    public T remove() {
        if (this.isEmpty()) {
            System.out.println("Empty queue! Cannot pop!");
            return null;
        }
        shiftStacks();
        return stackoldest.pop();
    }
    
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    /*public static void traverse() {
        int thesize = this.size();
        for(int i = 0; i < thesize; i++) {
            System.out.println(this.remove());
        }
    }*/
}

class Test35 {
    public static void main(String[] args) {
        MyQueue<String> newQueue = new MyQueue<String>();
        newQueue.add("我是1");
        newQueue.add("我是2");
        newQueue.add("我是3");
        newQueue.remove();
        newQueue.remove();
        newQueue.add("我是4");
        newQueue.remove();
        System.out.println("Now the queue is:");
        int thesize = newQueue.size();
        for(int i = 0; i < thesize; i++) {
            System.out.println(newQueue.remove());
        }

    }
}
/**
 * 3.6  Write a program to sort a stack in ascending order (with biggest items on top). You may use at most one additional stack to hold items, but you may not copy the elements into any other data structure (such as an array).The stack supports the following operations: push, pop, peek, and isEmpty.
 *
 * 思路: 用一个buffer stack储存临时数据，一个变量temp储存s stack的peek， temp和buffer中的每一个数比较，直到temp < buffer[i]，插入至i位置，循环往复。
 *
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 *
 * 注: 如果可以用超过一个additional stack，则可以考虑使用sort算法，时间复杂度可降至O(nlgn).
 */

import java.util.Stack;

class Test36 {
	public static void main(String[] args){
		Stack<Integer> test = new Stack<Integer>();
		test.push(5);
		test.push(2);
		test.push(3);
		test.push(1);
		test.push(4);
		test.push(6);
        test.push(9);
        test.push(7);
        test.push(8);
		sort(test);
        int thesize = test.size();
        for(int i = 0; i < thesize; i++) {
            System.out.println(test.pop());
        }
	}
	
	private static void sort(Stack<Integer> s){
		Stack<Integer> buffer = new Stack<Integer>();
		while(!s.isEmpty()){
			int temp = s.pop();
			while(!buffer.isEmpty() && temp > buffer.peek()){
				s.push(buffer.pop());
			}
			buffer.push(temp);
		}
		while(!buffer.isEmpty()){
			s.push(buffer.pop());
		}
	}
}
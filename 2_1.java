/**
 * 2.1 Write code to remove duplicates from an unsorted linked list. FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 *
 * 思路:遍历链表，相邻Node储存的元素进行两两比较，若相同则把LinkedListNode.next指向LinkedListNode.next.next.
 *
 * 时间复杂度:O(n^2);
 * 空间复杂度:O(1);
 *
 * Test case："1 -> 2 -> 2 -> 3 -> 4" deleteDups()后 变成 "1 -> 2 -> 3 -> 4"。
 * 注: 相邻的元素重复才算的上是duplicate，比如 “1 -> 2 -> 2” 算, 而 “1 -> 2 -> 1” 不算。
 */

class LinkedListNode {
	int data;
	LinkedListNode next;
}


class Test21 {
	public static void deleteDups(LinkedListNode head) {
		if (head == null) {
            return;
        }
        else {
            LinkedListNode current = head;
            while(current != null) {
                LinkedListNode runner = current;
                while(runner.next != null) {
                    if (runner.next.data == current.data) {
                        runner.next = runner.next.next;
                    }
                    else {
                        runner = runner.next;
                    }
                }
                System.out.print(current.data);
                if (current.next != null) {
                    System.out.print(" -> ");
                }
                current = current.next;
            }
        }
    }
	public static void main(String[] args) {
		LinkedListNode l1 = new LinkedListNode();
        LinkedListNode l2 = new LinkedListNode();
        LinkedListNode l3 = new LinkedListNode();
        LinkedListNode l4 = new LinkedListNode();
        LinkedListNode l5 = new LinkedListNode();
        l1.data = 1;
		l2.data = 2;
		l3.data = 2;
        l4.data = 3;
        l5.data = 4;
		l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
		deleteDups(l1);
        System.out.println("(The linked list after deleteDups() should be: 1 -> 2 -> 3 -> 4)");
	}
}

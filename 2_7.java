/**
 * 2.7 Implement a function to check if a linked list is a palindrome.
 *
 * 思路:clone链表, reverse原链表, 比较两链表的前半部分是否相同.
 *
 * 时间复杂度:O(n)
 * 空间复杂度:O(2n)（也算是O(n)吧
 *
 * Test case: 1.长度为奇数的链表
 *            2.长度为偶数的链表
 *            3.空链表
 *
 * 注: 如果可以用built－in，这题简单很多，clone和reverse都可以拿来直接用。之所以写的略复杂也是因为完全从零开始实现clone和reverse, 其中reverse参考的是Leetcode里“Reverse Arraylist II”的java实现，就当顺带刷了一道Leetcode吧。
 */

class LinkedListNode {
    int val;
    LinkedListNode next;
    public LinkedListNode(int val)
    {
        this.val = val;
        this.next = null;
    }
}

class Test27 {
    public static int sLength(LinkedListNode head) {
        int count = 0;
        LinkedListNode current = head;
        while(current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public static LinkedListNode reverseBetween(LinkedListNode head, int m, int n) {
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;
        LinkedListNode prevM = dummy, prev = dummy, curr = dummy;
        for (int i = 1; i <= n; i++) {
            if (i < m) {
                prevM = prevM.next;
            }
            else if (i == m) {
                prev = prevM.next;
                curr = prev.next;
            }
            else {
                prev.next = curr.next;
                curr.next = prevM.next;
                prevM.next = curr;
                curr = prev.next;
            }
        }
        return dummy.next;
    }

    public static boolean IsPalindrome(LinkedListNode head) {
        int length = sLength(head);
        int count1 = 0;
        int half;
        int ori[] = new int[length];
        LinkedListNode current1 = head;
        if (head == null)
            return false;
        if (length%2 == 0) {
            half = length/2;
        }
        else {
            half = (length+1)/2;
        }
        System.out.println("The input linked list is:");
        for (int j = 0; j < length;j++) {
            ori[j] = current1.val;
            current1 = current1.next;
            System.out.print(ori[j]);
            if(j < length - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println(" ");
        LinkedListNode node = reverseBetween(head,1,length);
        for(int i = 0; i < half; i++) {
            if(node.val == ori[i]) {
                count1++;
            }
            node = node.next;
        }
        if(count1 == half) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args)throws Exception {
        LinkedListNode l1 = new LinkedListNode(1);
        LinkedListNode l2 = new LinkedListNode(2);
        LinkedListNode l3 = new LinkedListNode(3);
        LinkedListNode l4 = new LinkedListNode(4);
        LinkedListNode l5 = new LinkedListNode(3);
        LinkedListNode l6 = new LinkedListNode(2);
        LinkedListNode l7 = new LinkedListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = null;
        if(IsPalindrome(l1)) {
            System.out.println("It is a palindrome linked list!");
        }
        else {
            System.out.println("You are kidding me!");
        }
    }
}

/*
class Node {
	public Node next;
	public int val;
	Node(int _v) {
		val = _v;
		next = null;
	}
}

class PalindromeList {
	public static boolean isPalindrome(Node head) {
		if (head == null || head.next == null) return true;
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		boolean result = false;
		if (fast == null) {
			// slow is the head of second half
			Node reversed = reverse(slow);
			result = areEqual(head, slow, reversed);
			reverse(reversed);
		} else {
			// slow is the middle node
			Node reversed = reverse(slow.next);
			result = areEqual(head, slow, reversed);
			reverse(reversed);
		}
		return result;
	}
    
	public static boolean areEqual(Node a, Node end, Node b) {
		// a starts with a and ends with end
		// b starts with b and ends with null
		Node p1 = a;
		Node p2 = b;
		while(p1 != end && p2 != null) {
			if (p1.val != p2.val) return false;
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1 == end && p2 == null;
	}
    
	public static Node reverse(Node head) {
		Node fakeHead = new Node(0);
		Node cur = head;
		while(cur != null) {
			// insert cur
			Node tmp = cur.next;
			cur.next = fakeHead.next;
			fakeHead.next = cur;
			cur = tmp;
		}
		return fakeHead.next;
	}
    
	public static void main(String[] args) {
		Node test1 = arrayToLinkedList(new int[]{1});
		Node test2 = arrayToLinkedList(new int[]{1,1});
		Node test3 = arrayToLinkedList(new int[]{1,2});
		Node test4 = arrayToLinkedList(new int[]{1, 2, 1});
		Node test5 = arrayToLinkedList(new int[]{1, 2, 2});
		Node test6 = arrayToLinkedList(new int[]{1, 2, 2, 1});
		Node test7 = arrayToLinkedList(new int[]{1, 2, 3, 4});
		Node test8 = arrayToLinkedList(new int[]{1, 3, 4, 3, 1});
        
		assert isPalindrome(test1);
		assert isPalindrome(test2);
		assert !isPalindrome(test3);
		assert isPalindrome(test4);
		assert !isPalindrome(test5);
		assert isPalindrome(test6);
		assert !isPalindrome(test7);
		assert isPalindrome(test8);
        
		System.out.println("Tests Passed");
	}
    
	private static Node arrayToLinkedList(int[] arr) {
		if (arr == null || arr.length < 1) return null;
		Node fakeHead = new Node(0);
		Node cur = fakeHead;
		for(int i = 0; i < arr.length; i++) {
			cur.next = new Node(arr[i]);
			cur = cur.next;
		}
		return fakeHead.next;
	}
    
}*/

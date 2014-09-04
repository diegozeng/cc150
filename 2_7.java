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

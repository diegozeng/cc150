/*
 * 2.5 You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the Ts digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 EXAMPLE
 Input:(7-> 1 -> 6) + (5 -> 9 -> 2).Thatis,617 + 295.
 Output: 2 -> 1 -> 9.That is, 912.
 *
 * 时间复杂度：O(m+n)
 * 空间复杂度：O(max(m,n))
 *
 * 思路：类似竖式的加法，注意考虑和链表为null的情况
 */

class ListNode {
    int val;
    ListNode next;
    public ListNode(int x)
    {
        val = x;
        next = null;
    }
}

class Test25 {
    public static ListNode addup(ListNode first, ListNode second) {
        ListNode result = new ListNode(0);
        rec(first, second, 0, result);
        return result.next;
    }
    
    public static void rec(ListNode first, ListNode second, int carry,  ListNode result) {
        if (first == null && second == null) {      //if both are null
            if (carry != 0) {   // but it may has a carry.
                result.next = new ListNode(carry);
            }
            return;                                  //stop
        } else if (first == null || second == null) { // if one of them is null
            if (first == null) { // if it is first
                result.next = new ListNode((second.val + carry)%10); // set next to second's value
                rec(null, second.next, (second.val + carry) / 10, result.next);
            } else {                                        //if it is second
                result.next = new ListNode((first.val + carry)%10); // set next to first
                rec(first.next, null, (first.val + carry) / 10, result.next);
            }
        } else { //if both are not null
            result.next = new ListNode((first.val + second.val + carry) % 10); // set next to both
            rec(first.next, second.next, (first.val + second.val + carry) / 10, result.next);// return with carry
        }
        
    }
    public static void main(String[] args) {
        ListNode first = new ListNode(7);
        first.next = new ListNode(1);
        first.next.next = new ListNode(6);
        ListNode second = new ListNode(5);
        second.next = new ListNode(9);
        second.next.next = new ListNode(2);
        
        ListNode head =  addup(first, second);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println(" ");
    }
}

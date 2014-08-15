/*
 * Implement an algorithm to delete a node in the middle of a singly linked
 * list, given only access to that node.
 *
 * 思路: 例如a->b->c这样的链表, 要删除a,只需把b的值赋给a, a的next直接指向c(next.next）即可。删除b同理，不过这种方法无法删除尾节点c.
 *
 * 时间复杂度：O(1)
 * 空间复杂度：O(1)
 * Test case: 同2.1的测试链表.
 */
class LinkedListNode {
	int data;
	LinkedListNode next;
}

class Test23 {
    public static void deleteNode(LinkedListNode node, LinkedListNode head) {
        if(node == null || head == null)
            return;
        LinkedListNode next = node.next;
        node.data = next.data;
        node.next = next.next;
        LinkedListNode current = head;
        while(current != null) {
            System.out.print(current.data);
            if(current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
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
        deleteNode(l1,l1);
        System.out.println("(The linked list after deleteDups() should be: 2 -> 2 -> 3 -> 4)");
//      deleteNode(l2,l1);
//      System.out.println("(The linked list after deleteDups() should be: 1 -> 2 -> 3 -> 4)");
//      deleteNode(l3,l1);
//      System.out.println("(The linked list after deleteDups() should be: 1 -> 2 -> 3 -> 4)");
//      deleteNode(l4,l1);
///     System.out.println("(The linked list after deleteDups() should be: 1 -> 2 -> 2 -> 4)");
//      deleteNode(l5,l1); NUllpointerException, cannot delete last node in the single linked list.
    }
}

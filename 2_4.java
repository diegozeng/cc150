/**
 * 2.4 Write code to partition a linked list around a value x, such that all
 * nodes less than x come before all nodes greater than or equal to x.
 *
 * 思路: 小于x的存一个链表，标记链表头节点beforeStart；同理，大于x的链表头节点afterStart，最后找到前者的尾节点和afterStart连在一起。
 *
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
 *
 * 注: 连接时注意"beforeStart == null"的情况.
 */

class LinkedListNode {
	int data;
	LinkedListNode next;
}


class Test24 {
	public static LinkedListNode ListPartition(LinkedListNode node, int x){
		LinkedListNode beforeStart=null;
		LinkedListNode afterStart=null;
		
		while (node!=null){
			LinkedListNode next = node.next;
			if(node.data < x){
				node.next = beforeStart;
				beforeStart = node;
			}
			else{
				node.next = afterStart;
				afterStart = node;
			}
			node = next;
		}
        if(beforeStart == null){
            return afterStart;
        }
        LinkedListNode head = beforeStart;
        while(beforeStart.next != null){
            beforeStart = beforeStart.next;
        }
        beforeStart.next=afterStart;
        return head;
	}

    public static void main(String[] args){
        LinkedListNode l1 = new LinkedListNode();
        LinkedListNode l2 = new LinkedListNode();
        LinkedListNode l3 = new LinkedListNode();
        LinkedListNode l4 = new LinkedListNode();
        LinkedListNode l5 = new LinkedListNode();
        l1.data = 1;
        l2.data = 9;
        l3.data = 3;
        l4.data = 7;
        l5.data = 5;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        LinkedListNode haha = ListPartition(l1, 4);
        while(haha != null) {
            System.out.print(haha.data);
            if(haha.next != null) {
                System.out.print(" -> ");
            }
            haha = haha.next;
        }
        System.out.println("(The test result should be: 3 -> 1 -> 5 -> 7 -> 9)");
    }
    
}
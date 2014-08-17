/**
 * 2.6 Given a circular linked list, implement an algorithm which returns the
 * node at the beginning of the loop.
 *
 * DEFINITION Circular linked list: A (corrupt) linked list in which a node's
 * next pointer points to an earlier node, so as to make a loop in the linked
 * list.
 *
 * EXAMPLE Input:A->B->C->D->E->F->G->C[thesameCasearlier]
 *
 * Output:C
 *
 * 思路：先构造两个dynamic Node: FasterRunner和SlowRunner，前者的速度是后者的两倍。当他们在循环中相遇时时，FasterRunner刚好在LOOPSIZE — k(非循环部分的长度)的位置，让后把SlowRunner拖回head，当两者再次相遇时，相遇的Node即位LOOP的begnning point.
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
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

class Test26 {
    public static LinkedListNode FindBeginning(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        /* Check no loop cases */
        if(fast == null || fast.next == null) {
            System.out.println("No loop in the linked list!");
            return null;
        }
        
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    //  return slow;
    }
    
    public static void main(String[] args) {
        LinkedListNode A = new LinkedListNode(1);
        LinkedListNode B = new LinkedListNode(2);
        LinkedListNode C = new LinkedListNode(3);
        LinkedListNode D = new LinkedListNode(4);
        LinkedListNode E = new LinkedListNode(5);
        LinkedListNode F = new LinkedListNode(6);
        LinkedListNode G = new LinkedListNode(7);
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        E.next = F;
        F.next = G;
        G.next = C;
        int count = 0;
        char[] Sq = {'A','B', 'C', 'D', 'E', 'F', 'G'};
        LinkedListNode bp = FindBeginning(A);
        for(int i = 0; i < 7; i++) {
            if(bp == A) {
                System.out.println(Sq[count]);
            }
            A = A.next;
            count ++;
        }
//        System.out.println(bp);
//        System.out.println(C);
    }
    
}
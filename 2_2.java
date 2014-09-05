/*
 * 2.2 Implement an algorithm to find the kth to last element of a singly linked list.
 *
 * 思路：若linkedlist长度已知，则get位于length－k位置的元素即可；若长度未知，利用书中的“runner tech”，定义两个指针，先拉开距离k，然后同时向链表尾部移动，直到首指针到链表末尾，get尾指针所在位置的元素。
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
import java.util.LinkedList;
import java.util.Iterator;
/* Length available
class findlastkth {
	// name of the method is "find", type is "Item".
	public static<Item> Item find(LinkedList<Item> list, int k) {
		if (list == null || list.size() < k || k < 0) {
			return null;
		}

		int length = list.size();
		int index = length - k;

		return list.get(index);
	}

	public static void main (String[] args) {
		LinkedList<Integer> test = new LinkedList<Integer>();

		for (int i = 0; i < 10; i++) {
			test.add(i);
		}
		int k = 6;
		Iterator itr = test.iterator();
		System.out.println("The total linkedlist is:");
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();
		System.out.println("The last " + k + "th element is:"+find(test,k));
	}
}
*/

/* Unknown length */
class findlastkth1 {
    public static int kthnode(LinkedList<Integer> input, int k) {
        if (input == null || input.size() < k || k < 0) {
            System.out.println("Entry null");
            return (Integer) null;
        }
        
        Iterator<Integer> iter = input.iterator();
        int i = 0;
        while(i < k) {
            iter.next();
            i++;
        }
        int r_index = 0;
        while(iter.hasNext()) {
            iter.next();
            r_index ++;
        }
        
        return input.get(r_index);
    }
    
    public static void main(String[] args) {
        LinkedList<Integer> test = new LinkedList<Integer>();
        for(int i = 0; i < 10; i++) {
            test.add(i);
            
        }
        int k = 6;
        System.out.println("The entire linkedlist is:");
//	System.out.println(test);
        System.out.println(test.toString());
        System.out.println("The last " + k + "th element is: " + kthnode(test,k));
    }
}
/**/

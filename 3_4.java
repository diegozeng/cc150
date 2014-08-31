/**
 *3.4 In the classic problem of the Towers of Hanoi, you have 3 towers and Ndisks of different sizes which can slide onto any tower.The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one). You have the following constraints:
 (1) Only one disk can be moved at a time.
 (2) A disk is slid off the top of one tower onto the next tower.
 (3) A disk can only be placed on top of a larger disk.
 Write a program to move the disks from the first tower to the last using stacks.
 *
 * 思路: 汉诺塔是递归的经典应用:
 if(盘子数量<=0)
 return
 else if(一个盘子)
 直接将A柱子上的盘子从A移到C.
 else
 先将A柱子上的n－1个盘子借助C移到B
 直接将A柱子上的盘子从A移到C
 最后将B柱子上的n－1个盘子借助A移到C
 *
 * 时间复杂度:O(2^n)
 * 空间复杂度:O(n)
 *
 * Test case:移动4个disk的情况
 *
 * 注: 相对于面向过程的实现，面向对象的思路是功能的拆分细化。
 * 如果有4根柱子会怎样? n根呢?(n>3)
 */

import java.util.Stack;
 
class Tower {
    private Stack<Integer> disks;
    private int index;
    public Tower(int i) {
        disks = new Stack<Integer>();
        index = i;
    }
 
    public int index() {
        return index;
    }
 
    public void add(int d) {
        if(!disks.empty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }
 
    public void moveTopTo(Tower t) {
        int top = disks.pop();
        t.add(top);
        System.out.println("Move disk " + top + " from " + index() + " to " + t.index());
    }
 
    public void moveDisks(int n, Tower destination, Tower buffer) {
        if(n > 0) {
            moveDisks(n - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }
 
    public static void main(String[] args) {
        int n = 4;
        Tower[] towers = new Tower[n];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }
        towers[0].moveDisks(n, towers[2], towers[1]);
    }
 }


 

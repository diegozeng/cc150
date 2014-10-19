/**
 * 4.2  Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 *
 * 思路: BFS/DFS
 *
 * 时间复杂度:O(|V|+|E|)
 * 空间复杂度:O(|V|)
 *
 * 注：bfs通过队列实现, dfs通过栈实现回溯
 */
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Node {
		boolean isVisited = false;
		ArrayList<Node> neighbors = new ArrayList<Node>();
	}	

class Test42 {
	public static boolean hasPath(Node n1, Node n2) {
		if(n1 == null || n2 == null)
			return false;
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(n1);
		n1.isVisited = true;

		Node current = null;
		while(!queue.isEmpty()) {
			current = queue.poll();
//          System.out.println(current);
//          System.out.println(current.neighbors);
			if (current == n2)
				return true;
			for (Node neighbor : current.neighbors) {
				if(!neighbor.isVisited) {
					queue.offer(neighbor);
					neighbor.isVisited = true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Node u = new Node();
		Node v = new Node();
		Node w = new Node();
		Node x = new Node();
		Node y = new Node();
		Node z = new Node();
        u.neighbors.add(0,x);
        u.neighbors.add(1,v);
		v.neighbors.add(0,y);
		w.neighbors.add(0,z);
		w.neighbors.add(1,y);
		x.neighbors.add(0,v);
		y.neighbors.add(0,x);
		z.neighbors.add(0,z);
		if(hasPath(w,v)){
			System.out.println("There is a route between two input nodes!");
		}
		else {
			System.out.println("You are kidding me!");
		}
	}
}

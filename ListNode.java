// singly liked list
public class ListNode<T extends Comparable<T>> {
	public T data;
	public ListNode<T> next;

	public static ListNode<Integer> search(ListNode<Integer> L, int key){ 
		while (L != null && L.data != key) {
			L = L.next;
		}
		// If key was not present in the list, L will have become null.
		return L;
	}

	public static ListNode<Integer> find(ListNode<Integer> L, int node){ 
		int count = 0;
		if (node < 0) {
			return L;
		}
		while (L != null && count++ != node) {
			L = L.next;
		}
		// If key was not present in the list, L will have become null.
		return L;
	}

	// deletes the node proceding the specified node
	public static void delete(ListNode<Integer> node) {
		if (node.next != null) {
			node.next = node.next.next;
		}
	}

	public String toString() {
		String str = "[";
		// adding current data in the ListNode
		str += this.data;
		ListNode<T> curr = this.next;
		// iteration of listNode
		while (curr != null) {
			str += " " + curr.data;
			curr = curr.next;
		}
		str += "]";

		return str;
	}

	// //  compares the data of the list to another
	public boolean comapreTo(ListNode<T> list) {
		if (this.data.compareTo(list.data) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	// randomly generate listnode with a specific length
	public static ListNode<Integer> randGen(int n) {
		ListNode<Integer> list = new ListNode<>();
		list.data = (int)(Math.random() * 10);
		ListNode<Integer> curr = list;
		
		for (int i = 0; i < n - 1; ++i) {
			curr.next = new ListNode<>();
			curr = curr.next;
			curr.data = (int)(Math.random() * 10);
		}
		return list;
	}

	public static void insertAfter(ListNode<Integer> node, ListNode<Integer> insertNode) {
		insertNode.next = node.next;
		node.next = insertNode;
	}

	public static void insertBefore(ListNode<Integer> node, ListNode<Integer> insertNode) {
		insertNode.next = node.next;
		node.next = insertNode;
		int insertData = insertNode.data;
		insertNode.data = node.data;
		node.data = insertData;
		node = insertNode;
	}

	public static void insertFirst(ListNode<Integer> list, ListNode<Integer> node) {
		node.next = list;
	}



	public static void main(String[] args) {

		//unit testing list node
		ListNode<Integer> list = new ListNode<>();
		list.data = 1;
		list.next = new ListNode<>();
		list.next.data = 2;
		System.out.println(list.toString());
	}
}
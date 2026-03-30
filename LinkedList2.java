public class LinkedList2 {
  static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static Node head;
  public static Node tail;

  public static boolean detectCycle() {
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  public static void removeCycle() {
    // detect cycle
    Node slow = head;
    Node fast = head;
    boolean cycle = false;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        cycle = true;
        break;
      }
    }
    if (cycle == false) {
      return;
    }
    // find meeting point
    slow = head;
    Node prev = null; // last Node
    while (slow != fast) {
      prev = fast;
      slow = slow.next;
      fast = fast.next;
    }

    // chatgpt improved for head
    // if (slow == fast) { // cycle at head
    // while (fast.next != slow) {
    // fast = fast.next;
    // }
    // fast.next = null;
    // return;
    // }
    // remove cycle -> last.next = null
    prev.next = null;
  }

  public Node getMid(Node head) {
    Node slow = head;
    Node fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private Node merge(Node head1, Node head2) {
    Node mergeLL = new Node(-1);
    Node temp = mergeLL;
    while (head1 != null && head2 != null) {
      if (head1.data <= head2.data) {
        temp.next = head1;
        head1 = head1.next;
        temp = temp.next;
      } else {
        temp.next = head2;
        head2 = head2.next;
        temp = temp.next;
      }
    }
    while (head1 != null) {
      temp.next = head1;
      head1 = head1.next;
      temp = temp.next;
    }

    while (head2 != null) {
      temp.next = head2;
      head2 = head2.next;
      temp = temp.next;
    }
    return mergeLL.next;
  }

  public Node mergeSort(Node head) {
    if (head == null || head.next == null) {
      return head;
    }
    // Find Mid
    Node mid = getMid(head);
    // Left & Right MS
    Node rightHead = mid.next;
    mid.next = null;
    Node newLeft = mergeSort(head);
    Node newRight = mergeSort(rightHead);

    // merge
    return merge(newLeft, newRight);
  }

  public void zigZag() {
    // find mid
    Node mid = getMid(head);
    // reverse 2nd Half
    Node curr = mid.next;
    Node prev = null;
    Node next = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    Node left = head;
    Node right = prev;
    Node nextL, nextR;
    // alt merge - Zig-Zag merge
    while (left != null && right != null) {
      nextL = left.next;
      left.next = right;
      nextR = right.next;
      right.next = nextL;
      left = nextL;
      right = nextR;
    }
  }

  public void addFirst(int data) {
    // Step 1 =create new node
    Node newNode = new Node(data);
    if (head == null) {
      head = tail = newNode;
      return;
    }
    // Step 2 =newNode next = head
    newNode.next = head; // Link
    // Step 3 - Head = newNode
    head = newNode;
  }

  public void print() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ->");
      temp = temp.next;
    }
    System.out.println(" null");
  }

  public static void main(String[] args) {
    // head = new Node(1);
    // Node temp = new Node(2);
    // head.next = temp;
    // head.next.next = new Node(3);
    // head.next.next.next = temp;
    // System.out.println(detectCycle());
    // removeCycle();
    // System.out.println(detectCycle());

    LinkedList2 ll = new LinkedList2();
    ll.addFirst(1);
    ll.addFirst(2);
    ll.addFirst(3);
    ll.addFirst(4);
    ll.addFirst(5);
    ll.addFirst(6);

    ll.print();
    ll.head = ll.mergeSort(ll.head);
    ll.zigZag();
    ll.print();
    // mergeSort(head);

  }
}


import org.w3c.dom.Node;
import java.util.*;

public class BST2 {
  // static class Node {
  // int data;
  // Node left;
  // Node right;

  // public Node(int data) {
  // this.data = data;
  // }
  // }

  // For AVL Tree

  // public static Node insert(Node root, int val) {
  // if (root == null) {
  // root = new Node(val);
  // return root;
  // }
  // if (val <= root.data) {
  // root.left = insert(root.left, val);
  // } else {
  // root.right = insert(root.right, val);
  // }
  // return root;
  // }

  public static void inOrder(Node root) {
    if (root == null) {
      return;
    }
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
  }

  public static Node createBst(int values[], int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = (start + end) / 2;
    Node root = new Node(values[mid]);
    root.left = createBst(values, start, mid - 1);
    root.right = createBst(values, mid + 1, end);
    return root;
  }

  public static void preOrder(Node root) {
    if (root == null)
      return;
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  public static Node balanceBST(ArrayList<Integer> inOrder, int st, int end) {
    if (st > end) {
      return null;
    }
    int mid = (st + end) / 2;
    Node root = new Node(inOrder.get(mid));
    root.left = balanceBST(inOrder, st, mid - 1);
    root.right = balanceBST(inOrder, mid + 1, end);
    return root;
  }

  public static void getInOrder(Node root, ArrayList<Integer> inOrder) {
    if (root == null) {
      return;
    }
    getInOrder(root.left, inOrder);
    inOrder.add(root.data);
    getInOrder(root.right, inOrder);
  }

  public static Node convertBst(Node root) {
    ArrayList<Integer> inOrder = new ArrayList<>();
    getInOrder(root, inOrder);
    return balanceBST(inOrder, 0, inOrder.size() - 1);
  }

  static class Info {
    boolean isBST;
    int size;
    int min;
    int max;

    public Info(boolean isBST, int size, int min, int max) {
      this.isBST = isBST;
      this.size = size;
      this.min = min;
      this.max = max;
    }

  }

  public static int maxBST = 0;// largest root size
  static Node maxBSTRoot = null;// largest root data

  public static Info largestBst(Node root) {
    if (root == null) {
      return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    ;
    Info rightInfo = largestBst(root.right);
    int size = leftInfo.size + rightInfo.size + 1;
    int min = Math.min(root.data, (Math.min(leftInfo.min, rightInfo.min)));
    int max = Math.max(root.data, (Math.max(leftInfo.max, rightInfo.max)));
    if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
      return new Info(false, size, min, max);
    }
    if (leftInfo.isBST && rightInfo.isBST) {
      maxBST = Math.max(maxBST, size);
      maxBSTRoot = root;
      return new Info(true, size, min, max);
    }
    return new Info(false, size, min, max);
  }

  public static void mergeInOrder(Node root, ArrayList<Integer> arr) {
    if (root == null) {
      return;
    }
    mergeInOrder(root.left, arr);
    arr.add(root.data);
    mergeInOrder(root.right, arr);

  }

  public static Node createBalancedBst(ArrayList<Integer> arr, int st, int end) {
    if (st > end) {
      return null;
    }
    int mid = (st + end) / 2;
    Node root = new Node(arr.get(mid));
    root.left = createBalancedBst(arr, st, mid - 1);
    root.right = createBalancedBst(arr, mid + 1, end);
    return root;
  }

  public static Node mergeBSTs(Node root1, Node root2) {
    ArrayList<Integer> arr1 = new ArrayList<>();
    ArrayList<Integer> arr2 = new ArrayList<>();
    mergeInOrder(root1, arr1);
    mergeInOrder(root2, arr2);
    // mergeSort(arr1, arr2);
    ArrayList<Integer> sorted = new ArrayList<>();
    int i = 0, j = 0;
    while (i < arr1.size() && j < arr2.size()) {
      if (arr1.get(i) <= arr2.get(j)) {
        sorted.add(arr1.get(i));
        i++;
      } else {
        sorted.add(arr2.get(j));
        j++;
      }
    }
    while (i < arr1.size()) {
      sorted.add(arr1.get(i));
      i++;
    }
    while (j < arr2.size()) {
      sorted.add(arr2.get(j));
      j++;
    }
    return createBalancedBst(sorted, 0, sorted.size() - 1);
  }

  public static void main(String[] args) {
    // Node root = null;
    // int values[] = { 3, 5, 6, 8, 10, 11, 12 };
    // for (int i = 0; i < values.length; i++) {
    // root = insert(root, values[i]);
    // }

    // inOrder(root);
    // root = createBst(values, 0, values.length - 1);
    // balanceBST(root);
    // Node root = new Node(8);
    // root.left = new Node(6);
    // root.left.left = new Node(5);
    // root.left.left.left = new Node(3);

    // root.right = new Node(10);
    // root.right.right = new Node(11);
    // root.right.right.right = new Node(12);

    // largestBst
    // Node root = new Node(50);
    // root.left = new Node(30);
    // root.left.left = new Node(5);
    // root.left.right = new Node(20);

    // root.right = new Node(60);
    // root.right.left = new Node(45);
    // root.right.right = new Node(70);
    // root.right.right.left = new Node(65);
    // root.right.right.right = new Node(80);

    // mergeBST
    // Node root1 = new Node(2);
    // root1.left = new Node(1);
    // root1.right = new Node(4);

    // Node root2 = new Node(9);
    // root2.left = new Node(3);
    // root2.right = new Node(12);

    // root = convertBst(root); // update root
    // Info info = largestBst(root);
    // System.out.println("Largest BST size = " + maxBST);
    // System.out.print("Largest BST (Preorder): ");
    // preOrder(maxBSTRoot);

    // Node root = mergeBSTs(root1, root2);

    preOrder(root);
    // System.out.println();
    // System.out.println(root.data);
  }
}

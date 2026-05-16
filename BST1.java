import org.w3c.dom.Node;
import java.util.*;

public class BST1 {
  static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
    }
  }

  public static Node insert(Node root, int val) {
    if (root == null) {
      root = new Node(val);
      return root;
    }
    if (root.data > val) {
      // lest subTree
      root.left = insert(root.left, val);
    } else {
      root.right = insert(root.right, val);
    }
    return root;
  }

  public static void inOrder(Node root) {
    if (root == null) {
      return;
    }
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
  }

  public static boolean search(Node root, int key) {
    if (root == null) {
      return false;
    }
    if (root.data == key) {
      return true;
    }
    if (root.data > key) {
      search(root.left, key);
    } else {
      search(root.right, key);
    }
    return false;
  }

  public static Node delete(Node root, int val) {
    if (root == null) {
      return root;
    }
    if (root.data < val) {
      root.right = delete(root.right, val);
    } else if (root.data > val) {
      root.left = delete(root.left, val);
    } else {// voila
      // case 1
      if (root.left == null && root.right == null) {
        return null;
      }
      // case 2 - single child
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }
      // case 3 - both children
      Node Is = findInOrderSuccessor(root.right);
      root.data = Is.data;
      root.right = delete(root.right, Is.data);
    }
    return root;
  }

  public static Node findInOrderSuccessor(Node root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }

  public static void printRange(Node root, int k1, int k2) {
    if (root == null) {
      return;
    }
    if (root.data >= k1 && root.data <= k2) {
      printRange(root.left, k1, k2);
      System.out.print(root.data + " ");
      printRange(root.right, k1, k2);
    } else if (root.data < k1) {
      printRange(root.right, k1, k2);
    } else {
      printRange(root.left, k1, k2);
    }
  }

  public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
    if (root == null) {
      return;
    }
    path.add(root.data);
    if (root.left == null && root.right == null) {
      printPath(path);
    }
    printRoot2Leaf(root.left, path);
    printRoot2Leaf(root.right, path);
    path.remove(path.size() - 1);
  }

  public static void printPath(ArrayList<Integer> path) {
    for (int i = 0; i < path.size(); i++) {
      System.out.print(path.get(i) + " ");
    }
    System.out.println("null");
  }

  public static boolean isValid(Node root, Node min, Node max) {
    if (root == null) {
      return false;
    }
    if (min != null && min.data <= root.data) {
      return true;
    } else if (max != null && max.data >= root.data) {
      return true;
    }
    return isValid(root.left, min, root) && isValid(root.right, root, max);
  }

  public static Node mirror(Node root) {
    if (root == null)
      return root;
    Node leftSide = mirror(root.left);
    Node rightside = mirror(root.right);
    root.left = rightside;
    root.right = leftSide;
    return root;
  }

  public static void preOrder(Node root) {
    if (root == null)
      return;
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  public static void main(String[] args) {
    // int values[] = { 5, 1, 3, 4, 2, 7 };
    int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
    // int values[] = { 1, 1, 1, 1 };
    Node root = null;
    for (int i = 0; i < values.length; i++) {
      root = insert(root, values[i]);
    }
    // System.out.println(search(root, 6));
    // inOrder(root);
    // System.out.println();
    // root = delete(root, 7);
    // System.out.println();
    // inOrder(root);
    // System.out.println();
    // printRange(root, 5, 12);
    // ArrayList<Integer> path = new ArrayList<>();
    // printRoot2Leaf(root, path);
    // if (isValid(root, null, null)) {
    // System.out.println("valid");
    // } else {
    // System.out.println("not valid");
    // }
    preOrder(root);
    mirror(root);
    System.out.println();
    preOrder(root);
    // inOrder(root);
  }
}

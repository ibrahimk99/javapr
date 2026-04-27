
import java.util.*;

import org.w3c.dom.Node;

public class BinaryTrees2 {
  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  static class BinaryTree {
    static int idx = -1;

    public static Node buildTree(int nodes[]) {
      idx++;
      if (nodes[idx] == -1) {
        return null;
      }
      Node newNode = new Node(nodes[idx]);
      newNode.left = buildTree(nodes);
      newNode.right = buildTree(nodes);
      return newNode;
    }

    public static int height(Node root) {
      if (root == null) {
        return 0;
      }
      int lh = height(root.left);
      int rh = height(root.right);
      return Math.max(lh, rh) + 1;
    }

    static class Info {
      int diam;
      int ht;

      public Info(int diam, int ht) {
        this.diam = diam;
        this.ht = ht;
      }
    }

    public static Info diameter(Node root) {
      if (root == null) {
        return new Info(0, 0);
      }
      Info leftInfo = diameter(root.left);
      Info rightInfo = diameter(root.right);
      int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
      int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;
      return new Info(diam, ht);
    }

    public static int diameter2(Node root) {
      if (root == null) {
        return 0;
      }
      int leftDiam = diameter2(root.left);
      int rightDiam = diameter2(root.right);
      int leftHt = height(root.left);
      int rightHt = height(root.right);
      int selfDiam = leftHt + rightHt + 1;
      return Math.max(Math.max(leftDiam, rightDiam), selfDiam);
    }

  }
  // GPT
  // public static boolean isIdentical(Node node, Node subRoot) {
  // if (node == null && subRoot == null) {
  // return true;
  // } else if (node == null || subRoot == null || node.data != subRoot.data) {
  // return false;
  // }

  // return isIdentical(node.left, subRoot.left) && isIdentical(node.right,
  // subRoot.right);
  // }

  // public static boolean isSubTree(Node root, Node subRoot) {
  // if (subRoot == null) {
  // return true;
  // }
  // if (root == null) {
  // return false;
  // }
  // if (isIdentical(root, subRoot)) {
  // return true;
  // }
  // return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
  // }

  // // best optimized gpt
  // public static boolean isIdentical(Node node, Node subRoot) {
  // if (node == null && subRoot == null)
  // return true;
  // if (node == null || subRoot == null)
  // return false;
  // if (node.data != subRoot.data)
  // return false;

  // return isIdentical(node.left, subRoot.left) &&
  // isIdentical(node.right, subRoot.right);
  // }

  // public static boolean isSubTree(Node root, Node subRoot) {
  // if (subRoot == null)
  // return true; // important edge case
  // if (root == null)
  // return false;

  // if (root.data == subRoot.data && isIdentical(root, subRoot)) {
  // return true;
  // }

  // return isSubTree(root.left, subRoot) ||
  // isSubTree(root.right, subRoot);
  // }

  // sharadha
  public static boolean isIdentical(Node node, Node subRoot) {
    if (node == null && subRoot == null) {
      return true;
    } else if (node == null || subRoot == null || node.data != subRoot.data) {
      return false;
    }
    if (!isIdentical(node.left, subRoot.left)) {
      return false;
    }
    if (!isIdentical(node.right, subRoot.right)) {
      return false;
    }
    return true;
  }

  public static boolean isSubTree(Node root, Node subRoot) {
    if (subRoot == null)
      return true; // important edge case
    if (root == null) {
      return false;
    }
    if (root.data == subRoot.data) {
      if (isIdentical(root, subRoot)) {
        return true;
      }
    }
    return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
  }

  static class InfoHd {
    Node node;
    int hd;

    public InfoHd(Node node, int hd) {
      this.node = node;
      this.hd = hd;
    }
  }

  public static void topView(Node root) {
    Queue<InfoHd> q = new LinkedList<>();
    HashMap<Integer, Node> map = new HashMap<>();
    int min = 0, max = 0;
    q.add(new InfoHd(root, 0));
    q.add(null);

    while (!q.isEmpty()) {
      InfoHd curr = q.remove();
      if (curr == null) {
        if (q.isEmpty()) {
          break;
        } else {
          q.add(null);
        }
      } else {
        if (!map.containsKey(curr.hd)) { // first time my horizontal distance (hd) is occurring
          map.put(curr.hd, curr.node);
        }
        if (curr.node.left != null) {
          q.add(new InfoHd(curr.node.left, curr.hd - 1));
          min = Math.min(min, curr.hd - 1);
        }
        if (curr.node.right != null) {
          q.add(new InfoHd(curr.node.right, curr.hd + 1));
          max = Math.max(max, curr.hd + 1);
        }
      }
    }
    for (int i = min; i <= max; i++) {
      System.out.print(map.get(i).data + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
    int subTreeArr[] = { 2, 4, -1, -1, 5, -1, -1 };

    BinaryTree tree = new BinaryTree();

    // Build main tree
    BinaryTree.idx = -1;
    Node root = tree.buildTree(nodes);

    // Build subtree
    // BinaryTree.idx = -1;
    // Node subRoot = tree.buildTree(subTreeArr);
    // System.out.println(isSubTree(root, subRoot));

    // System.out.println(subRoot.data);

    // System.out.println(tree.diameter(root).diam);
    // System.out.println(tree.diameter2(root));
    topView(root);
  }
}
import java.lang.ProcessHandle.Info;
import java.util.*;

import org.w3c.dom.Node;

public class BinaryTrees {
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

    // Pre-Order Tree Traversal
    public static void preOrder(Node root) {
      if (root == null) {
        System.out.print(-1 + " ");
        return;
      }
      System.out.print(root.data + " ");
      preOrder(root.left);
      preOrder(root.right);
    }

    // In-Order Tree Traversal
    public static void inOrder(Node root) {
      if (root == null) {
        System.out.print(-1 + " ");
        return;
      }
      inOrder(root.left);
      System.out.print(root.data + " ");
      inOrder(root.right);
    }

    // Post-Order Tree Traversal
    public static void postOrder(Node root) {
      if (root == null) {
        System.out.print(-1 + " ");
        return;
      }
      postOrder(root.left);
      postOrder(root.right);
      System.out.print(root.data + " ");
    }

    // Level Order Traversal
    public static void levelOrder(Node root) {
      if (root == null) {
        return;
      }
      Queue<Node> q = new LinkedList<>();
      q.add(root);
      q.add(null);
      while (!q.isEmpty()) {
        Node currentNode = q.remove();
        if (currentNode == null) {
          System.out.println();
          if (q.isEmpty()) {
            break;
          } else {
            q.add(null);
          }
        } else {
          System.out.print(currentNode.data + " ");
          if (currentNode.left != null) {
            q.add(currentNode.left);
          }
          if (currentNode.right != null) {
            q.add(currentNode.right);
          }
        }
      }
    }

    // Height of Tree
    public static int height(Node root) {
      if (root == null) {
        return 0;
      }
      int lh = height(root.left);
      int rh = height(root.right);
      return Math.max(lh, rh) + 1;
    }

    public static int count(Node root) {
      if (root == null) {
        return 0;
      }
      int lcount = count(root.left);
      int rcount = count(root.right);
      return lcount + rcount + 1;
    }

    public static int sum(Node root) {
      if (root == null) {
        return 0;
      }
      int leftSum = sum(root.left);
      int rightSum = sum(root.right);
      return leftSum + rightSum + root.data;
    }

  }

  public static void main(String[] args) {
    int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
    BinaryTree tree = new BinaryTree();
    Node root = tree.buildTree(nodes);
    // tree.preOrder(root);
    // tree.inOrder(root);
    // tree.postOrder(root);
    // tree.levelOrder(root);

    // System.out.println(tree.height(root));
    // System.out.println(tree.count(root));
    // System.out.println(tree.sum(root));

  }
}

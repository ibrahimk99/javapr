import java.util.*;

public class Stacks {
  // static class Node {
  // int data;
  // Node next;

  // Node(int data) {
  // this.data = data;
  // this.next = null;
  // }
  // }

  // static class Stack {
  // Stack with LinkedList
  // static Node head = null;

  // public static boolean isEmpty() {
  // return head == null;
  // }

  // // push
  // public static void push(int data) {
  // Node newNode = new Node(data);
  // if (isEmpty()) {
  // head = newNode;
  // return;
  // }
  // newNode.next = head;
  // head = newNode;
  // }

  // public static int pop() {
  // if (isEmpty()) {
  // return -1;
  // }
  // int top = head.data;
  // head = head.next;
  // return top;
  // }

  // public static int peek() {
  // if (isEmpty()) {
  // return -1;
  // }
  // return head.data;
  // }

  // Stack with ArrayList
  // static ArrayList<Integer> list = new ArrayList<>();

  // public static boolean isEmpty() {
  // return list.size() == 0;
  // }

  // // push add automtically add data at last
  // public static void push(int data) {
  // list.add(data);
  // }

  // // pop
  // public static int pop() {
  // if (isEmpty()) {
  // return -1;
  // }
  // int top = list.get(list.size() - 1);
  // list.remove(list.size() - 1);
  // return top;
  // }

  // // peak
  // public static int peek() {
  // if (isEmpty()) {
  // return -1;
  // }
  // return list.get(list.size() - 1);
  // }
  // }
  // Stack using Collection FrameWork

  public static void pushAtBottom(Stack<Integer> s, int data) {
    if (s.isEmpty()) {
      s.push(data);
      return;
    }
    int top = s.pop();
    pushAtBottom(s, data);
    s.push(top);
  }

  public static void main(String[] args) {
    // Stack s = new Stack();
    Stack<Integer> s = new Stack<>();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    pushAtBottom(s, 5);
    while (!s.isEmpty()) {
      System.out.println(s.peek());
      s.pop();
    }
  }
}

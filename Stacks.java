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

  public static String reverseStr(String str) {
    Stack<Character> s = new Stack<>();
    int idx = 0;
    while (idx < str.length()) {
      s.push(str.charAt(idx));
      idx++;
    }
    StringBuilder result = new StringBuilder();
    while (!s.isEmpty()) {
      char curr = s.pop();
      result.append(curr);
    }
    return result.toString();
  }

  public static void reverseStack(Stack<Integer> s) {
    if (s.isEmpty()) {
      return;
    }
    int top = s.pop();
    reverseStack(s);
    pushAtBottom(s, top);

  }

  public static void printStack(Stack<Integer> s) {
    while (!s.isEmpty()) {
      System.out.println(s.pop());
    }
  }

  public static void stocksSpan(int stocks[], int span[]) {
    Stack<Integer> s = new Stack<>();
    span[0] = 1;
    s.push(0);
    for (int i = 1; i < stocks.length; i++) {
      int currPrice = stocks[i];
      while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
        s.pop();
      }
      if (s.isEmpty()) {
        span[i] = i + 1;
      } else {
        int prevHigh = s.peek();
        span[i] = i - prevHigh;
      }
      s.push(i);
    }
  }

  public static void nxtGreaterElement(int arr[]) {
    Stack<Integer> s = new Stack<>();
    int nxtGreater[] = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
        s.pop();
      }
      if (s.isEmpty()) {
        nxtGreater[i] = -1;
      } else {
        nxtGreater[i] = arr[s.peek()];
      }
      s.push(i);
    }
    for (int i = 0; i < nxtGreater.length; i++) {
      System.out.print(nxtGreater[i] + " ");
    }
  }

  public static boolean isValidParenThesis(String str) {
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      // opening
      if (ch == '(' || ch == '{' || ch == '[') {
        s.push(ch);
      } else { // closing
        if (s.isEmpty()) {
          return false;
        }
        if ((s.peek() == '(' && ch == ')') // ()
            || (s.peek() == '{' && ch == '}')// {}
            || (s.peek() == '[' && ch == ']')) {// []
          // s.peek(); // gpt
          s.pop();
        } else {
          return false;
        }
      }
    }
    if (s.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean isDuplicateParenThesis(String dupStr) {
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < dupStr.length(); i++) {
      char ch = dupStr.charAt(i);
      // closing
      if (ch == ')') {
        int count = 0;
        // while (s.peek() != '(') {
        // s.pop();
        // count++;
        // } //gpt
        while (!s.isEmpty() && s.peek() != '(') {
          s.pop();
          count++;
        }
        if (count < 1) {
          return true; // duplicate
        } else {
          s.pop(); // opening pair

        }
      } else {
        // opening
        s.push(ch);
      }
    }
    return false;
  }

  public static void maxArea(int arr[]) {
    Stack<Integer> s = new Stack<>();
    int maxArea = 0;
    int nsl[] = new int[arr.length];
    int nsr[] = new int[arr.length];
    // Next Smaller Right

    for (int i = arr.length - 1; i >= 0; i--) {
      while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
        s.pop();
      }
      if (s.isEmpty()) {
        nsr[i] = arr.length;
      } else {
        nsr[i] = s.peek();

      }
      s.push(i);
    }
    // Next Smaller left
    s = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
        s.pop();
      }
      if (s.isEmpty()) {
        nsl[i] = -1;
      } else {
        nsl[i] = s.peek();

      }
      s.push(i);
    }

    // Current Area : width= j-i-1 = nsr[i] - nsl[i] - 1
    for (int i = 0; i < arr.length; i++) {
      int height = arr[i];
      int width = nsr[i] - nsl[i] - 1;
      int currArea = height * width;
      maxArea = Math.max(currArea, maxArea);
    }
    System.out.println("max Area in histogram = " + maxArea);
  }

  public static void main(String[] args) {

    // Stack s = new Stack();
    Stack<Integer> s = new Stack<>();
    // s.push(1);
    // s.push(2);
    // s.push(3);
    // s.push(4);
    // pushAtBottom(s, 5);
    // System.out.println(reverseStr("abc"));
    // reverseStack(s);
    // printStack(s);
    // int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
    // int span[] = new int[stocks.length];
    // stocksSpan(stocks, span);
    // for (int i = 0; i < span.length; i++) {
    // System.out.print(span[i] + " ");
    // }
    // String str = "()({[]})[]";
    // System.out.println(isValidParenThesis(str));
    // String dupStr = "(((a+b)+(c+d)))";
    // System.out.println(isDuplicateParenThesis(dupStr));
    int arr[] = { 2, 1, 5, 6, 2, 3 };
    maxArea(arr);
    // int arr[] = { 6, 8, 0, 1, 3 };
    // nxtGreaterElement(arr);
    while (!s.isEmpty()) {
      System.out.println(s.peek());
      s.pop();
    }
  }
}

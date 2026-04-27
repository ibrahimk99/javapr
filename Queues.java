import java.util.*;

public class Queues {

  // static class Queue {

  // <<<<<<<<<<< Queue using Array >>>>>>>>>>>>>>>>
  // static int arr[];
  // static int size;
  // static int rear;
  // static int front;

  // Queue(int n) {
  // arr = new int[n];
  // size = n;
  // rear = -1;
  // front = -1;
  // }

  // public static boolean isEmpty() {
  // return rear == -1 && front == -1;
  // // Array
  // // return rear == -1;
  // }

  // public static boolean isFull() {
  // return (rear + 1) % size == front;
  // }

  // // add
  // public static void add(int data) {
  // // Array
  // // if(rear ==-1){
  // // return;}
  // if (isFull()) {
  // System.out.println("queue is full");
  // return;
  // }
  // // add 1st element
  // if (front == -1) {
  // front = 0;
  // }
  // rear = (rear + 1) % size;
  // // Array
  // // rear = rear+1;
  // arr[rear] = data;
  // }

  // // remove
  // public static int remove() {
  // if (isEmpty()) {
  // System.out.println("empty queue");
  // return -1;
  // }
  // int result = arr[front];
  // // last element remove
  // if (rear == front) {
  // rear = front = -1;
  // } else {
  // front = (front + 1) % size;
  // }
  // return result;
  // // Array
  // // int front = arr[0];
  // // for (int i = 0; i < rear; i++) {
  // // arr[i] = arr[i + 1];
  // // }
  // // rear = rear - 1;
  // // return front;
  // }

  // // peek
  // public static int peek() {
  // if (isEmpty()) {
  // System.out.println("empty queue");
  // return -1;
  // }
  // return arr[front];
  // // Array
  // // return arr[0];
  // }

  // <<<<<<<<<<< Queue using Linked List >>>>>>>>>>>>>>>>
  // static class Node {
  // int data;
  // Node next;

  // Node(int data) {
  // this.data = data;
  // this.next = null;
  // }
  // }

  // static Node head = null;
  // static Node tail = null;

  // public static boolean isEmpty() {
  // return head == null && tail == null;
  // }

  // // add
  // public static void add(int data) {
  // Node newNode = new Node(data);
  // if (head == null) {
  // head = tail = newNode;
  // return;
  // }
  // tail.next = newNode;
  // tail = newNode;
  // }

  // // remove
  // public static int remove() {
  // if (isEmpty()) {
  // System.out.println("empty queue");
  // return -1;
  // }
  // int front = head.data;
  // if (tail == head) {
  // tail = head = null;
  // } else {
  // head = head.next;
  // }
  // return front;
  // }

  // // peek
  // public static int peek() {
  // if (isEmpty()) {
  // System.out.println("empty queue");
  // return -1;
  // }
  // return head.data;
  // }

  // <<<<<<<<<<< Queue using 2 Stacks >>>>>>>>>>>>>>>>
  // static Stack<Integer> s1 = new Stack<>();
  // static Stack<Integer> s2 = new Stack<>();

  // public static boolean isEmpty() {
  // return s1.isEmpty();
  // }

  // public static void add(int data) {
  // while (!s1.isEmpty()) {
  // s2.push(s1.pop());
  // }
  // s1.push(data);
  // while (!s2.isEmpty()) {
  // s1.push(s2.pop());
  // }
  // }

  // public static int remove() {
  // if (isEmpty()) {
  // return -1;
  // }
  // return s1.pop();
  // }

  // public static int peek() {
  // return s1.peek();
  // }
  // }

  // <<<<<<<<<<< Stacks using 2 Queue >>>>>>>>>>>>>>>>
  // static class Stack {
  // static Queue<Integer> q1 = new LinkedList<>();
  // static Queue<Integer> q2 = new LinkedList<>();

  // public static boolean isEmpty() {
  // return q1.isEmpty() && q2.isEmpty();
  // }

  // public static void push(int data) {
  // if (!q1.isEmpty()) {
  // q1.add(data);
  // } else {
  // q2.add(data);
  // }
  // }

  // public static int pop() {
  // if (isEmpty()) {
  // return -1;
  // }
  // int top = -1;
  // // case 1
  // if (!q1.isEmpty()) {
  // while (!q1.isEmpty()) {
  // top = q1.remove();
  // if (q1.isEmpty()) {
  // break;
  // }
  // q2.add(top);
  // }
  // } else {
  // // case 2
  // while (!q2.isEmpty()) {
  // top = q2.remove();
  // if (q2.isEmpty()) {
  // break;
  // }
  // q1.add(top);
  // }
  // }
  // return top;
  // }

  // public static int peek() {
  // if (isEmpty()) {
  // return -1;
  // }
  // int top = -1;
  // if (!q1.isEmpty()) {
  // while (!q1.isEmpty()) {
  // top = q1.remove();
  // q2.add(top);
  // }
  // } else {
  // while (!q2.isEmpty()) {
  // top = q2.remove();
  // q1.add(top);
  // }
  // }
  // return top;
  // }
  // }

  // <<<<<<<<<<< Non Repeating Stream >>>>>>>>>>>>>>>>

  // public static void printNonRepeating(String str) {
  // int freq[] = new int[26];
  // Queue<Character> q = new LinkedList<>();
  // for (int i = 0; i < str.length(); i++) {
  // char ch = str.charAt(i);
  // q.add(ch);
  // freq[ch - 'a']++;
  // while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
  // q.remove();
  // }
  // if (q.isEmpty()) {
  // System.out.print(-1 + " ");
  // } else {
  // System.out.print(q.peek() + " ");
  // }
  // }
  // System.out.println();
  // }

  // public static void interLeave(Queue<Integer> q) {
  // Queue<Integer> firstHalf = new LinkedList<>();
  // int size = q.size();
  // for (int i = 0; i < size / 2; i++) {
  // firstHalf.add(q.remove());
  // }
  // while (!firstHalf.isEmpty()) {
  // q.add(firstHalf.remove());
  // q.add(q.remove());
  // }
  // }

  // public static void reverse(Queue<Integer> q) {
  // Stack<Integer> s = new Stack<>();
  // while (!q.isEmpty()) {
  // s.push(q.remove());
  // }
  // while (!s.isEmpty()) {
  // q.add(s.pop());
  // }
  // }

  public static void main(String[] args) {
    // Queue<Integer> q = new LinkedList<>();
    // Queue<Integer> q = new ArrayDeque<>();
    // Queue q = new Queue();

    // q.add(1);
    // q.add(2);
    // q.add(3);

    // while (!q.isEmpty()) {
    // System.out.println(q.peek());
    // q.remove();
    // }
    // <<<<<<<<<<< Stacks using 2 Queue >>>>>>>>>>>>>>>>
    // Stack s = new Stack();
    // s.push(1);
    // s.push(2);
    // s.push(3);
    // while (!s.isEmpty()) {
    // System.out.println(s.peek());
    // s.pop();
    // }
    // String str = "aabccxb";
    // printNonRepeating(str);
    // Queue<Integer> q = new LinkedList<>();
    // q.add(1);
    // q.add(2);
    // q.add(3);
    // q.add(4);
    // q.add(5);
    // q.add(6);
    // q.add(7);
    // q.add(8);
    // q.add(9);
    // q.add(10);
    // interLeave(q);
    // reverse(q);
    // while (!q.isEmpty()) {
    // System.out.print(q.remove() + " ");
    // }
    Deque<Integer> dq = new LinkedList<>();
    dq.addFirst(1);
    dq.addFirst(2);
    dq.addLast(3);
    dq.addLast(4);

    System.out.print("first el : " + dq.getFirst());
    System.out.println();
    System.out.print("last el : " + dq.getLast());
    System.out.println();
    System.out.print(dq);
  }
}

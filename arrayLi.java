import java.util.*;

public class arrayLi {
  public static void findMaximum(ArrayList<Integer> list) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < list.size(); i++) {
      max = Math.max(max, list.get(i));
    }
    System.out.println(max);
  }

  public static void swap(ArrayList<Integer> arr, int idx1, int idx2) {
    int temp = arr.get(idx1);
    arr.set(idx1, arr.get(idx2));
    arr.set(idx2, temp);
  }

  public static int stormWater(ArrayList<Integer> height) {
    // Approach 1 O(n^2)
    // int maxWater = 0;
    // for (int i = 0; i < height.size(); i++) {
    // for (int j = i + 1; j < height.size(); j++) {
    // int ht = Math.min(height.get(i), height.get(j));
    // int width = j - i;
    // int currWater = ht * width;
    // maxWater = Math.max(maxWater, currWater);
    // }
    // }
    // return maxWater;

    // Approach 2 O(n)
    int maxWater = 0;
    int lp = 0;
    int rp = height.size() - 1;
    while (lp < rp) {

      int width = rp - lp;
      int ht = Math.min(height.get(rp), height.get(lp));
      int currWater = ht * width;
      maxWater = Math.max(currWater, maxWater);
      if (height.get(rp) > height.get(lp)) {
        lp++;
      } else {
        rp--;
      }
    }
    return maxWater;
  }

  public static boolean pairSum(int key, ArrayList<Integer> arr) {
    // BruteForce Approach

    // for (int i = 0; i < arr.size(); i++) {
    // for (int j = i + 1; j < arr.size(); j++) {
    // if (arr.get(i) + arr.get(j) == key) {
    // return true;
    // }
    // }
    // }
    // return false;

    // Approach 2 O(n)
    int lp = 0;
    int rp = arr.size() - 1;
    while (lp < rp) {
      if (arr.get(lp) + arr.get(rp) < key) {
        lp++;
      } else {
        rp--;
      }
    }
    if ((arr.get(lp) + arr.get(rp) == key)) {
      return true;
    }
    return false;
  }

  // Rotated & sorted Array
  public static boolean pairSum2(int key, ArrayList<Integer> arr2) {
    int bp = -1;
    for (int i = 0; i < arr2.size() - 1; i++) {
      if (arr2.get(i) > arr2.get(i + 1)) {
        bp = i;
      }
    }
    int lp = bp + 1;
    int rp = bp;
    int n = arr2.size();
    while (lp != rp) {
      if (arr2.get(lp) + arr2.get(rp) == key) {
        return true;
      }
      if (arr2.get(lp) + arr2.get(rp) < key) {
        lp = (lp + 1) % n;
      } else {
        rp = (n + rp - 1) % n;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();

    list.add(5);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(16);
    list.add(1);
    // list.set(0, 8);
    // list.contains(3);
    // list.remove(3);
    // System.out.println(list.get(1));
    // System.out.println(list.contains(3));
    // System.out.println(list.size());
    // System.out.println(list.reversed());
    // Collections.sort(list);
    // Collections.sort(list.reversed());

    // System.out.println(list);
    // findMaximum(list);

    ArrayList<Integer> height = new ArrayList<>();
    height.add(1);
    height.add(8);
    height.add(6);
    height.add(2);
    height.add(5);
    height.add(4);
    height.add(8);
    height.add(3);
    height.add(7);
    // System.out.print(stormWater(height));
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    arr.add(4);
    arr.add(5);
    arr.add(6);

    // int idx1 = 1, idx2 = 3;
    // swap(arr, idx1, idx2);
    // System.out.print(arr);

    // Multi Dimensional ArrayList
    ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    ArrayList<Integer> list3 = new ArrayList<>();
    for (int i = 1; i <= 5; i++) {
      list1.add(i * 1);
      list2.add(i * 2);
      list3.add(i * 3);
    }
    mainList.add(list1);
    mainList.add(list2);
    mainList.add(list3);

    // list2.remove(3);
    // list3.remove(4);

    // for Print Nested Loop
    // for (int i = 0; i < mainList.size(); i++) {
    // ArrayList<Integer> currList = mainList.get(i);
    // for (int j = 0; j < currList.size(); j++) {
    // System.out.print(currList.get(j) + " ");
    // }
    // System.out.println();
    // }
    // System.out.println(mainList);
    ArrayList<Integer> arr2 = new ArrayList<>();
    arr2.add(11);
    arr2.add(15);
    arr2.add(6);
    arr2.add(8);
    arr2.add(9);
    arr2.add(10);
    System.out.print(pairSum(6, arr));
    // System.out.print(pairSum2(16, arr2));
  }
}

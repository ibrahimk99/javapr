import java.lang.reflect.Array;
import java.time.*;
import java.util.*;

public class JavaArrays {
  public static void update(int marks[]) {
    for (int i = 0; i < marks.length; i++) {
      marks[i] = marks[i] + 1;
    }
  }

  public static int linearSearch(int numbers[], int key) {
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == key) {
        return i;
      }
    }
    return -1;
  }

  public static int fruitSearch(String fruits[], String favFruit) {
    for (int i = 0; i < fruits.length; i++) {
      if (fruits[i].equals(favFruit)) {
        return i;
      }
    }
    return -1;
  }

  // Find Largest & Smallest Integer in Array
  public static int getLargest(int numbers[]) {
    int largest = Integer.MIN_VALUE;
    int smallest = Integer.MAX_VALUE;
    for (int i = 0; i < numbers.length; i++) {
      if (smallest > numbers[i]) {
        smallest = numbers[i];
      }

    }
    for (int i = 0; i < numbers.length; i++) {
      if (largest < numbers[i]) {
        largest = numbers[i];
      }
    }
    System.out.println(smallest);
    return largest;
  }

  // Binary Search
  public static int binarySearch(int numbers[], int key) {
    int start = 0, end = numbers.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (numbers[mid] == key) {
        return mid;
      }
      if (numbers[mid] < key) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }

  // Reverse Array
  public static void reverseArray(int numbers[]) {
    int start = 0, end = numbers.length - 1;
    while (start < end) {
      int temp = numbers[start];
      numbers[start] = numbers[end];
      numbers[end] = temp;
      start++;
      end--;
    }
  }

  // Pairs in array
  public static void arrPair(int numbers[]) {
    for (int i = 0; i < numbers.length; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        System.out.print("(" + numbers[i] + "," + numbers[j] + ")" + " ");
      }
      System.out.println();
    }
  }

  // Print Sub Arrays
  public static void subArray(int numbers[]) {
    for (int i = 0; i < numbers.length; i++) {
      int start = i;
      for (int j = i; j < numbers.length; j++) {
        int end = j;
        for (int k = start; k <= end; k++) {
          System.out.print(numbers[k]);
        }
        System.out.println();
      }
      System.out.println();
    }
  }

  // Print Maximum Sum of Sub Arrays
  public static void maximumSubArraySum(int numbers[]) {
    int currSum = 0;
    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < numbers.length; j++) {
        for (int k = i; k <= j; k++) {
          System.out.print(" " + numbers[k]);
          currSum += (numbers[k]);
        }
        System.out.println();
      }
    }
    if (currSum > maxSum) {
      maxSum = currSum;
    }
    System.out.println("Maximum Sub Array Sum is: " + maxSum);
  }

  // Print Maximum Sum of Sub Arrays 2
  public static void maximumSubArraySum2(int numbers[]) {
    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.println(numbers[j] + " ");
      }
      System.out.println();
    }
  }

  // Print Maximum Sum of Sub Arrays 3 kadane's Algorithm
  public static void maximumSubArraySum3(int numbers[]) {
    int maximumSum = 0;
    int currentSum = 0;
    for (int i = 0; i < numbers.length; i++) {
      currentSum = currentSum + numbers[i];
      if (currentSum < 0) {
        currentSum = 0;
      }
      maximumSum = Math.max(currentSum, maximumSum);
    }
    System.out.println("Maximum Sub Array 3 Sum is: " + maximumSum);
  }

  public static void trappedRainWater(int height[]) {
    int n = height.length;
    // calculate left max boundary - array
    int leftMax[] = new int[n];
    leftMax[0] = height[0];
    for (int i = 1; i < n; i++) {
      leftMax[i] = Math.max(height[i], leftMax[i - 1]);
    }
    // calculate right max boundary - array
    int rightMax[] = new int[n];
    rightMax[n - 1] = height[n - 1];
    for (int j = n - 2; j >= 0; j--) {
      rightMax[j] = Math.max(height[j], rightMax[j + 1]);
    }
    int trappedWater = 0;
    // loop through the height array
    for (int i = 0; i < n; i++) {
      // waterlevel = min(leftmaxbound, rightmaxbound)
      int waterLevel = Math.min(leftMax[i], rightMax[i]);
      // trapped water = waterlevel - height[i]
      trappedWater += waterLevel - height[i];
    }
    System.out.println("Trapped Water: " + trappedWater);
  }

  // Buy Sell Stock to Maximize Profit
  // profit = maximum(sellingPrice) - minimum(buyingPrice)
  public static void buyAndSell(int price[]) {
    // int price[] = { 7, 1, 5, 3, 6, 4 };
    int buyingPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    for (int i = 0; i < price.length; i++) {
      if (buyingPrice < price[i]) {
        int profit = price[i] - buyingPrice;
        maxProfit = Math.max(maxProfit, profit);
      } else {
        buyingPrice = price[i];
      }
    }
    System.out.println("Buying Price: " + buyingPrice);
    System.out.println("Max Profit: " + maxProfit);
  }

  public static void arrayTest() {
    int height[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    int rightMax[] = new int[height.length];
    rightMax[height.length - 1] = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; i--) {
      rightMax[i] = Math.max(height[i], rightMax[i + 1]);
      System.out.println(Arrays.toString(rightMax));
    }
    int leftMax[] = new int[height.length];
    leftMax[0] = height[0];
    for (int i = 1; i < height.length; i++) {
      leftMax[i] = Math.max(height[i], leftMax[i - 1]);
    }
    System.out.println(Arrays.toString(leftMax));
  }

  public static void main(String args[]) {
    // update Array
    // int marks[] = { 4, 5, 6 };
    // update(marks);
    // for (int i = 0; i < marks.length; i++) {
    // System.out.print(marks[i] + " ");
    // }
    //// linear search with String

    // linear search with integer
    // int numbers[] = { 1, 3, 4, 4, 45, 10, 66, 20 };
    // int key = 20;
    // int index = linearSearch(numbers, key);
    // if (index == -1) {
    // System.out.println("No key found");
    // } else {
    // System.out.println("The index is : " + index);
    // }

    // //linear search with fruit index

    // String fruits[] = { "mango", "banana", "orange", "apple", "strawberry" };
    // String favFruit = "strawberry";
    // int index = fruitSearch(fruits, favFruit);

    // if (index == -1) {
    // System.out.println("No food available");
    // } else {
    // System.out.println("Fruit found at index: " + index);
    // }

    //// Find Largest & Smallest Integer in Array
    // int numbers[] = { 3, 45, 22, 6, 10, 20 };
    // System.out.println(getLargest(numbers));

    //// Binary Search (work on only sorted array)

    // int key = 45;
    // System.out.println(binarySearch(numbers, key));
    // Array Reverse
    // reverseArray(numbers);
    // for (int i = 0; i < numbers.length; i++) {
    // System.out.print(numbers[i] + " ");
    // }
    // System.out.println();
    int numbers[] = { 2, 4, 6, 8, 10, 15 };
    // int numbers[] = { 1, -2, 6, -1, 3 };
    // arrPair(numbers);
    // subArray(numbers);
    // maximumSubArraySum(numbers);
    // maximumSubArraySum2(numbers);
    maximumSubArraySum3(numbers);
    int height[] = { 4, 2, 0, 6, 3, 2, 5 };
    int price[] = { 7, 1, 5, 3, 6, 4 };
    buyAndSell(price);
    // trappedRainWater(height);
    // arrayTest();
  }
}
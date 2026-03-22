public class Recursion {
  public static void printDec(int n) {
    if (n <= 0) {
      return;
    }
    System.out.println(n);
    printDec(n - 1);
  }

  public static void printInc(int n) {
    if (n <= 0) {
      return;
    }
    printInc(n - 1);
    System.out.println(n);

  }

  public static int factorial(int n) {
    if (n <= 0) {
      return 1;
    }
    return n * factorial(n - 1);
  }

  public static int sumOfNumbers(int n) {
    if (n <= 0) {
      return 0;
    }
    return n + sumOfNumbers(n - 1);
  }

  public static int fibonacci(int n) {
    if (n <= 1) {
      return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  public static boolean isSorted(int arr[], int i) {
    if (i == arr.length - 1) {
      return true;
    } else if (arr[i] > arr[i + 1]) {
      return false;
    }
    return isSorted(arr, i + 1);
  }

  public static int firstOccurence(int arr[], int key, int i) {
    if (i == arr.length) {
      return -1;
    }
    if (arr[i] == key) {
      return i;
    }
    return firstOccurence(arr, key, i + 1);
  }

  public static int lastOccurence(int arr[], int key, int i) {
    if (i == arr.length) {
      return -1;
    }
    int isFound = lastOccurence(arr, key, i + 1);

    if (isFound == -1 && arr[i] == key) {
      return i;
    }
    return isFound;
  }

  public static void main(String args[]) {
    // printDec(5);
    // printInc(5);
    // System.out.println(factorial(5));
    // System.out.println(sumOfNumbers(5));
    // System.out.println(fibonacci(5));
    int[] arr = { 1, 2, 3, 6, 4, 5, 8, 9, };
    // System.out.println(isSorted(arr, 0));
    // System.out.println(firstOccurence(arr, 6, 0));
    System.out.println(lastOccurence(arr, 6, 0));

  }
}

public class JavaSorting {
  public static void bubbleSort(int arr[]) {
    for (int turn = 0; turn < arr.length - 1; turn++) {
      for (int j = 0; j < arr.length - 1 - turn; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
      System.out.println();
    }
  }

  public static void selectionSort(int arr[]) {
    for (int i = 0; i < arr.length - 1; i++) {
      int minPos = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[minPos] > arr[j]) {
          minPos = j;
        }
      }
      int temp = arr[minPos];
      arr[minPos] = arr[i];
      arr[i] = temp;
    }
  }

  public static void insertionSort(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      int curr = arr[i];
      int prev = i - 1;
      // finding out the current pos for insertion
      while (prev >= 0 && arr[prev] > curr) {
        arr[prev + 1] = arr[prev];
        prev--;
      }
      // for insertion
      arr[prev + 1] = curr;
    }
  }

  public static void printArr(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int arr[] = { 5, 3, 4, 2, 1 };
    // int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    // arrayTest(arr1);
    // bubbleSort(arr);
    // selectionSort(arr);
    insertionSort(arr);
    printArr(arr);
  }
}

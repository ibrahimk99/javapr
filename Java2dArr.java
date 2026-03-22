import java.util.*;

public class Java2dArr {

  public static void print2dArr(int arr[][]) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void printSpiral(int arr[][]) {
    int sr = 0;
    int er = arr.length - 1;
    int sc = 0;
    int ec = arr[0].length - 1;
    // System.out.println(er + " " + ec);
    while (sr <= er && sc <= ec) {
      for (int i = sc; i <= ec; i++) {
        System.out.print(arr[sr][i] + " ");
      }
      for (int j = sr + 1; j <= er; j++) {
        System.out.print(arr[j][ec] + " ");
      }
      for (int i = ec - 1; i >= sc; i--) {
        if (sr == er)
          break;
        System.out.print(arr[er][i] + " ");
      }
      for (int j = er - 1; j >= sr + 1; j--) {
        if (sc == ec)
          break;
        System.out.print(arr[j][sc] + " ");
      }
      sr++;
      ec--;
      er--;
      sc++;
    }
  }

  public static void sumDiagonal(int arr[][]) {
    int sum = 0;
    int secondSum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i][i];
      if (i != arr.length - i - 1) {
        secondSum += arr[i][arr.length - i - 1];
      }
    }
    System.out.println("Sum of primary diagonal: " + sum);
    System.out.println("Sum of secondary diagonal: " + secondSum);
  }

  public static void searchInSort(int arr[][], int key) {

    int row = 0;
    int col = arr[0].length - 1;

    while (row < arr.length && col >= 0) {

      if (arr[row][col] == key) {
        System.out.println("Key found at index = (" + row + "," + col + ")");
        return;
      }

      else if (key > arr[row][col]) {
        row++; // move down
      }

      else {
        col--; // move left
      }
    }

    System.out.println("Key not found");
  }

  public static void main(String[] args) {

    int arr[][] = { { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
        { 13, 14, 15, 16 }
    };
    // print2dArr(arr);
    // printSpiral(arr);
    // sumDiagonal(arr);
    searchInSort(arr, 122);

  }
}

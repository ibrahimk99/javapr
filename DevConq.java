public class DevConq {

  public static void printArr(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void mergeSort(int arr[], int si, int ei) {
    if (si >= ei) { // ✅ Base condition
      return;
    }
    int mid = si + (ei - si) / 2; // (si+ei)/2
    mergeSort(arr, si, mid); // left part
    mergeSort(arr, mid + 1, ei); // right part
    merge(arr, si, mid, ei);
  };

  public static void merge(int arr[], int si, int mid, int ei) {
    // left index (0,3)=4 right index (4-6)=3 ->6-0+1=7 //To remember the size of
    // the new array
    int temp[] = new int[ei - si + 1];
    int i = si; // iterator for left part
    int j = mid + 1; // iterator for right part
    int k = 0; // iterator for temp array
    while (i <= mid && j <= ei) {
      if (arr[i] < arr[j]) {
        temp[k] = arr[i];
        i++;
      } else {
        temp[k] = arr[j];
        j++;
      }
      k++;
    }
    // Copy remaining elements of left subarray, if any
    while (i <= mid) {
      temp[k++] = arr[i++];
    }
    // Copy remaining elements of right subarray, if any
    while (j <= ei) {
      temp[k++] = arr[j++];
    }
    // Copy back the merged elements to original array
    for (k = 0, i = si; k < temp.length; k++, i++) {
      arr[i] = temp[k];
    }
  }

  public static void quickSort(int arr[], int si, int ei) {
    if (si >= ei) {
      return;
    }

    // last element as pivot
    int pidx = partition(arr, si, ei);
    quickSort(arr, si, pidx - 1); // left part
    quickSort(arr, pidx + 1, ei); // right part
  }

  public static int partition(int arr[], int si, int ei) {
    int pivot = arr[ei];
    int i = si - 1; // to track the smaller element or to make place for els smaller than pivot

    for (int j = si; j < ei; j++) {
      if (arr[j] <= pivot) {
        i++;
        // swap arr[i] and arr[j]
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
      }
    }
    i++;
    int temp = pivot;
    arr[ei] = arr[i];
    arr[i] = temp;
    return i;
  }

  public static int search(int arr[], int tar, int si, int ei) {
    if (si > ei) {
      return -1;
    }
    int mid = si + (ei - si) / 2;
    if (arr[mid] == tar) {
      return mid;
    }
    // mid on L1
    if (arr[si] <= arr[mid]) {
      if (arr[si] <= tar && tar <= arr[mid]) {
        return search(arr, tar, si, mid - 1);
      } else {
        return search(arr, tar, mid + 1, ei);
      }
    }
    // mid on L2
    else {
      if (arr[mid] <= tar && tar <= arr[ei]) {
        return search(arr, tar, mid + 1, ei);
      } else {
        return search(arr, tar, si, mid - 1);
      }
    }
  }

  public static void main(String[] args) {
    int arr[] = { 6, 8, 9, 100, 2, 3, 5 };
    // mergeSort(arr, 0, arr.length - 1);
    // printArr(arr);
    // quickSort(arr, 0, arr.length - 1);
    int target = 100;
    int searchidx = search(arr, target, 0, arr.length - 1);
    System.out.println(searchidx);
    // printArr(arr);
  }
};

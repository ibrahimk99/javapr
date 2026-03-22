public class javaPatterns {
  // Print Hollow Rectangle Star

  public static void hollowRectangle(int row, int col) {
    for (int i = 1; i <= row; i++) {
      for (int j = 1; j <= col; j++) {
        if (i == 1 || i == row || j == 1 || j == col) {
          System.out.print(" *");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  // Print inverted Pyramid Star

  public static void invertPyramid(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n - i; j++) {
        System.out.print(" ");
      }
      for (int k = 1; k <= i; k++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void invertHalfPyramid(int n) {
    for (int i = 1; i <= n; i++) {
      int num = 1;
      for (int j = 1; j <= n - i + 1; j++) {
        System.out.print(num++);
      }
      System.out.println();
    }
  }

  // floyd Integer Triangle

  public static void floydTriangle(int n) {
    int num = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(num++);
      }
      System.out.println();
    }
  }

  // 0-1 floyd Triangle

  public static void triangle(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        if ((i + j) % 2 == 1) {
          System.out.print("1");
        } else {
          System.out.print("0");
        }
      }
      System.out.println();
    }
  }

  // Butterfly Pattern
  public static void butterfly(int n) {
    for (int i = 1; i <= n; i++) {
      for (int s = 1; s <= i; s++) {
        System.out.print("*");
      }

      for (int j = 1; j <= 2 * (n - i); j++) {
        System.out.print(" ");
      }
      for (int s = 1; s <= i; s++) {
        System.out.print("*");
      }
      System.out.println();
    }
    for (int i = n; i >= 0; i--) {
      for (int s = 1; s <= i; s++) {
        System.out.print("*");
      }

      for (int j = 1; j <= 2 * (n - i); j++) {
        System.out.print(" ");
      }
      for (int s = 1; s <= i; s++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
  // Pyramid Pattern

  public static void pyramid(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= 2 * (n - i); j++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print(" ");
      }
      for (int k = 1; k <= 2 * i; k++) {
        System.out.print("*");
      }
      System.out.println();
    }

  }

  // SOLID RHOMBUS pattern
  public static void solidRhoumbus(int n) {
    for (int i = 1; i <= n; i++) {
      int count = 1;
      for (int j = 1; j <= n - i; j++) {
        System.out.print(count++);
      }
      for (int k = 1; k <= n; k++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  // HOLLOW RHOMBUS pattern
  public static void hollowRohmbus(int row, int col) {
    for (int i = 1; i <= row; i++) {
      for (int j = 1; j <= row - i; j++) {
        System.out.print(" ");
      }
      for (int k = 1; k <= col; k++) {
        if (k == 1 || k == col || i == 1 || i == row) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  public static void diamond(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= 2 * (n - i); j++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print(" ");
      }
      for (int k = 1; k <= (2 * i) - 1; k++) {
        System.out.print("*");
      }
      System.out.println();
    }
    for (int i = n; i >= 0; i--) {
      for (int j = 1; j <= 2 * (n - i); j++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print(" ");
      }
      for (int k = 1; k <= (2 * i) - 1; k++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void main(String args[]) {

    // hollowRectangle(5, 7);
    // invertPyramid(4);
    // invertHalfPyramid(5);
    // floydTriangle(5);
    // triangle(5);
    // butterfly(14);
    // pyramid(4);
    // solidRhoumbus(5);
    // hollowRohmbus(4, 4);
    diamond(4);
  }
}

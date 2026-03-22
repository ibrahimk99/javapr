
// import java.math.BigInteger;
import java.util.*;
//Learning Function Parameter/Arguments
// public class JavaFunctions {
//   public static void calculateSum(int a, int b) {
//     int sum = a + b;
//     System.out.print("Total value is : " + sum);
//   }

//   public static void main(String args[]) {
//     Scanner sc = new Scanner(System.in);
//     System.out.print("Enter value a : ");
//     int a = sc.nextInt();
//     System.out.print("Enter value b : ");
//     int b = sc.nextInt();
//     calculateSum(a, b);

public class JavaFunctions {
  public static int calculateMultiply(int a, int b) {
    int product = a * b;
    System.out.println("Product Answer is : " + product);
    return product;
  }

  // Factorial of a number
  public static int factorial(int n) {
    int f = 1;
    for (int i = 1; i <= n; i++) {
      f = f * i;
    }
    return f;
  }

  // Binomial Coeffiecient
  public static int binCoeff(int n, int r) {
    int fact_n = factorial(n);
    int fact_r = factorial(r);
    int nmr_fact = factorial(n - r);
    int binCoeff = fact_n / (fact_r * nmr_fact);
    return binCoeff;
  }

  // Function overloading using parameter
  // sum 2 numbers
  public static int sum(int a, int b) {
    return a + b;
  }

  // // sum 3 numbers
  public static int sum(int a, int b, int c) {
    return a + b + c;
  }

  // sum 3 numbers with float
  public static float sum(float a, float b, float c) {
    return a + b + c;
  }

  // find prime number with basic method
  public static boolean prime(int n) {
    boolean isPrime = true;
    for (int i = 2; i <= n - 1; i++) {
      if (n % i == 0) {
        isPrime = false;
        break;
      } else {
        isPrime = true;
      }
    }
    if (isPrime == true) {
      System.out.print("prime");
    } else {
      System.out.print("not prime");
    }
    return isPrime;
  }

  // find prime number with advance method
  public static boolean isPrime(int n) {
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static void rangePrime(int n) {
    for (int i = 2; i <= n; i++) {
      if (isPrime(i)) {
        System.out.print(i + " ");
      }
    }
  }

  // test binary to decimal
  public static int binToDec(int binaryNum) {
    int pow = 0;
    int decimal = 0;
    while (binaryNum > 0) {
      int lastDigit = binaryNum % 10;
      System.out.println("Last Digit: " + lastDigit);
      decimal = decimal + (lastDigit * (int) Math.pow(2, pow));
      pow++;
      binaryNum = binaryNum / 10;
    }
    System.out.print(decimal);
    return binaryNum;
  }

  // Decimal to Binary
  public static int decToBin(int n) {
    int rem = 0;
    int bin = 0;
    int pow = 0;
    while (n > 0) {
      rem = n % 2;
      bin = bin + rem * (int) Math.pow(10, pow);
      n = n / 2;
      pow++;
    }
    System.out.print(bin);
    return bin;
  }

  public static void main(String args[]) {
    // Scanner sc = new Scanner(System.in);
    // System.out.print("Enter value a : ");
    // int a = sc.nextInt();
    // System.out.print("Enter value b : ");
    // int b = sc.nextInt();
    // int prod = calculateMultiply(a, b);
    // System.out.println("Product is : " + prod);
    // prod = calculateMultiply(3, 4);
    // System.out.println("Product is : " + prod);

    // System.out.println(binCoeff(5, 2));

    // System.out.print(sum(1.6f, 2.3f, 6.5f));

    // System.out.print(isPrime(100));

    // rangePrime(100);

    binToDec(10011);
    // decToBin(19);
  }
}
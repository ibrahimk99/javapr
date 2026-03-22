
// import java.math.BigInteger;
import java.util.*;

public class JavaBasics {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    // System.out.println("Hello World _");
    // System.out.println("Hello World _ 1");
    // System.out.println("Hello World _ 2");
    // System.out.println("Hello World _ 3");
    // System.out.println("Hello World _ 4");
    // System.out.println("****");
    // System.out.println("***");
    // System.out.println("**");
    // System.out.println("*");
    // Q - 1
    // int a = 20;
    // int b = 150;
    // int c = 25;
    // System.out.println((a + b + c) / 3);
    // Q - 2
    // int sideA = 16;
    // int sideB = 22;
    // System.out.println(sideA * sideB);
    // Q - 3
    // Scanner sc = new Scanner(System.in);
    // float pencil = sc.nextFloat();
    // float pen = sc.nextFloat();
    // float eraser = sc.nextFloat();
    // float total = pencil + pen + eraser;
    // System.out.println("Bill is : " + total);
    // float newTotal = total + (0.18f * total);
    // System.out.println("Bill with 18% tax : " + newTotal);

    // Q - 4
    // byte b = 4;
    // char c = 'a';
    // short s = 512;
    // int i = 1000;
    // float f = 3.14f;
    // double d = 99.9954;
    // result = (f * b) + (i % c) - (d * s);
    // TypeKind(result);
    // int $ = 24;
    // System.out.println($);
    // Calculate Sum
    // Scanner sc = new Scanner(System.in);
    // int a = sc.nextInt();
    // int b = sc.nextInt();
    // int sum = a + b;

    // System.out.println(sum);
    // Calculate Area of Circle
    // Scanner sc = new Scanner(System.in);
    // float radius = sc.nextFloat();
    // float area = 3.14f * radius * radius;
    // System.out.println(area);
    // int x = 10, y = 5;
    // int exp1 = (y * (x / y + x / y));
    // int exp2 = (y * x / y + y * x / y);
    // System.out.println(exp1);
    // System.out.println(exp2);
    // int counter = 1;
    // while (counter <= 10) {
    // System.out.println(counter++);
    // }

    // int n = sc.nextInt();
    // // int sum = 0;
    // int i = 0;

    // while (i <= n) {
    // i++;

    // System.out.println("i value is : " + i);
    // i *= i;
    // System.out.println("addes value is : " + i);
    // }
    // print reverse number
    // int n = 10899;
    // while (n > 0) {
    // int lastDigit = n % 10;
    // System.out.println(lastDigit);
    // n = n / 10;
    // System.out.println("remainig value = " + n);
    // }

    // get original reverse number while loop
    // int n = 10899;
    // int rev = 0;
    // while (n > 0) {
    // int lastDigit = n % 10;
    // rev = (rev * 10) + lastDigit;
    // n = n / 10;
    // // System.out.print(n);
    // }
    // System.out.print(rev);

    // Do while loop
    // int counter = 1;
    // do {
    // System.out.println("Hello World" + counter);
    // counter++;
    // } while (counter <= 10);

    // break/continue in loop
    // for (int i = 1; i <= 5; i++) {
    // if (i == 3) {
    // continue;
    // }
    // System.out.println(i);
    // }
    // System.out.println("i am out of loop");
    // test break/continue with example
    // do {
    // System.out.print("Please Enter Number : ");
    // int n = sc.nextInt();
    // if (n % 10 == 0) {
    // continue;
    // }

    // } while (true);
    // Logic to test Prime Number
    // int n = sc.nextInt();
    // boolean isPrime = true;
    // if (n == 1) {
    // isPrime = false;
    // } else {
    // for (int i = 2; i <= Math.sqrt(n); i++) {
    // if (n % i == 0) {
    // isPrime = false;
    // }
    // }
    // }
    // if (isPrime == true) {
    // System.out.print("Prime Number");
    // } else {
    // System.out.print("Not Prime Number");
    // }

    // Patterns
    // integer patterns
    // System.out.print("Select Number : ");
    // int n = sc.nextInt();

    // for (int line = 1; line <= n; line++) {
    // int count = 1;
    // for (int j = 1; j <= line; j++) {
    // System.out.print(count++);
    // }
    // System.out.println();
    // }

    // character patterns
    System.out.print("Select Number : ");
    int n = sc.nextInt();
    char ch = 'A';
    for (int line = 1; line <= n; line++) {
      for (int j = 1; j <= line; j++) {
        System.out.print(ch);
        ch++;
      }
      System.out.println();
    }

    // Chess Board Theory Methamatics
    // System.out.print("Enter n (number of steps): ");
    // int n = sc.nextInt();

    // BigInteger grains = BigInteger.valueOf(2); // Start with 2 so squaring grows
    // int step = 0;

    // while (step < n) {

    // grains = grains.multiply(grains);
    // step++;
    // }
    // System.out.println("Step " + step +
    // " → Digits: " + grains.toString().length() +
    // " → Grains: " + grains);
    // sc.close();
  }
}

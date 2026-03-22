public class JavaBits {

  // print binary to decimal
  public static void binToDec(int n) {
    int dec = 0;
    int pow = 0;
    while (n > 0) {
      int lastDigit = n % 10;
      dec += (lastDigit * Math.pow(2, pow));
      pow++;
      n = n / 10;
    }
    System.out.println("Decimal Value: " + dec);
  }

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
    System.out.println("Binary Value: " + bin);
    return bin;
  }
  // We can use StringBuilder to reverse the binary string instead of calculating
  // the power of 10 for each bit. This can be more efficient and easier to read.

  public static void decToBinSb(int n) {
    StringBuilder bin = new StringBuilder();
    while (n > 0) {
      int rem = n % 2;
      bin.append(rem);
      n = n / 2;
    }
    System.out.println("Binary Value: " + bin.reverse().toString());
  }

  public static void andOperator(int a, int b) {
    int result = a & b;
    System.out.println("AND Operator Result: " + result);
  }

  public static void orOperator(int a, int b) {
    int result = a | b;
    System.out.println("Decimal Result: " + result);
  }

  public static void xorOperator(int a, int b) {
    int result = a ^ b;
    System.out.println("XOR Operator Result: " + result);
  }

  public static void notOperator(int a) {
    int result = ~a;
    System.out.println("NOT Operator Result: " + result);
  }

  public static void leftShiftOperator(int a, int b) {
    int result = a << b;
    System.out.println("Left Shift Operator Result: " + result);
  }

  public static void rightShiftOperator(int a, int b) {
    int result = a >> b;
    System.out.println("Right Shift Operator Result: " + result);
  }

  public static int ithBit(int n, int i) {
    int bitMask = (1 << i);
    int bit = n & bitMask;
    if (bit != 0) {
      return 1;
    }
    return 0;
  }

  public static int setIthBit(int n, int i) {
    int bitMask = 1 << i;
    int bit = n | bitMask;
    return bit;
  }

  public static int clearIthBit(int n, int i) {
    int bitMask = ~(1 << i);
    return n & bitMask;
  }

  public static int updateIthBit(int n, int i, int newBit) {
    // Method 1: Using clear and set bit methods
    int BitMask = (1 << i);
    if (newBit == 0) {
      return n & ~BitMask;
    } else {
      return n | BitMask;
    }
    // Method 2
    // int clearBitMask = ~(1 << i);
    // n = n & clearBitMask;
    // int newBitMask = newBit << i;
    // return n | newBitMask;
  }

  public static int clearIBits(int n, int i) {

    int bitMask = ~0 << i;
    return n & bitMask;
  }

  public static int clearRangeBits(int n, int i, int j) {
    int a = ~0 << (j + 1);
    int b = (1 << i) - 1;
    int bitMask = a | b;
    return n & bitMask;
  }

  public static boolean isPowerofTwo(int n) {
    int bitMask = n & n - 1;
    if (bitMask == 0) {
      return true;
    } else {
      return false;
    }
  }

  public static int countSetBits(int n) {
    int count = 0;
    while (n > 0) {
      if ((n & 1) != 0) {
        count++;
      }
      n = n >> 1;
    }
    return count;
  }

  public static int fastExponentiation(int a, int n) {
    int ans = 1;
    while (n > 0) {
      if ((n & 1) != 0) { // check LSB of n
        ans = ans * a;
      }
      a = a * a;
      n = n >> 1;
    }
    return ans;
  }

  public static void main(String args[]) {

    int n = 3;
    int i = 2;
    System.out.println(fastExponentiation(3, 3));
    // System.out.println(isPowerofTwo(n));

    // System.out.println(countSetBits(n));
    // System.out.println("Clear Range of Bits: " + clearRangeBits(15, 2, 4));
    // System.out.println("Clear i Bits: " + clearIBits(n, i));
    // System.out.println("update i-th Bit: " + updateIthBit(n, i, 0));
    // System.out.println("clear i-th Bit: " + clearIthBit(n, i));
    // System.out.println("i-th Bit: " + ithBit(n, i));
    // System.out.println("set i-th Bit: " + setIthBit(n, i));
    // leftShiftOperator(-1, 2);
    // rightShiftOperator(5, 2);
    // notOperator(0);
    // xorOperator(110, 101);
    // orOperator(110, 111);
    // andOperator(100, 011);
    // decToBinSb(30);
    // decToBin(3);
    // binToDec(1110);
  }
}

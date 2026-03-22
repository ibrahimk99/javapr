public class JavaOops {
  public static void main(String args[]) {
    // Pen p1 = new Pen();
    // p1.setColor("Blue");
    // System.out.println(p1.color);
    // p1.setColor("Black");
    // System.out.println(p1.color);
    // p1.setTip(5);
    // System.out.println(p1.tip);

    BankAccount myAcc = new BankAccount();
    myAcc.username = "Muhammad Ibrahim";
    myAcc.setPassword("12345678");
  }
}

class BankAccount {
  String username;
  String password;

  void setPassword(String pwd) {
    password = pwd;
  }
}

class Pen {
  String color;
  int tip;

  void setColor(String newColor) {
    color = newColor;
  }

  void setTip(int newTip) {
    tip = newTip;
  }

}
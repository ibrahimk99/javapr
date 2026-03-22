
public static String toUpperCase(String str) {
  StringBuilder sb = new StringBuilder("");

  char ch = Character.toUpperCase(str.charAt(0));
  sb.append(ch);
  for (int i = 1; i < str.length(); i++) {
    if (str.charAt(i) == ' ' && i < str.length() - 1) {
      sb.append(str.charAt(i));
      i++;
      sb.append(Character.toUpperCase(str.charAt(i)));
    } else {
      sb.append(str.charAt(i));
    }
  }
  return sb.toString();
}

public static String compressStr(String str3) {
  String newStr = "";
  for (int i = 0; i < str3.length(); i++) {
    Integer count = 1;
    while (i < str3.length() - 1 && str3.charAt(i) == str3.charAt(i + 1)) {
      count++;
      i++;
    }
    newStr += str3.charAt(i);
    if (count > 0) {
      newStr += count.toString();
    }
  }
  return newStr;
}

public static void main(String[] args) {
  // String fruits[] = { "apple", "orange", "banana" };
  // firstStrings(fruits);
  String str = "my name is ibrahim";
  String str3 = "aaaaabbbbcccddddfff";
  System.out.println(toUpperCase(str));
  System.out.println(compressStr(str3));
}
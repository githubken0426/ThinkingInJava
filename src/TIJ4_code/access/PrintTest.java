
//: access/PrintTest.java
// Uses the static printing methods in Print.java.
package TIJ4_code.access;
import static TIJ4_code.net.mindview.util.Print.*;

public class PrintTest {
  public static void main(String[] args) {
    print("Available from now on!");
    print(100);
    print(100L);
    print(3.14159);
  }
} /* Output:
Available from now on!
100
100
3.14159
*///:~

//: polymorphism/PrivateOverride.java
// Trying to override a private method.
package TIJ4_code.polymorphism;
import static TIJ4_code.net.mindview.util.Print.*;

public class PrivateOverride {
  private void f() { print("private f()"); }
  public static void main(String[] args) {
    PrivateOverride po = new Derived();
    po.f();
  }
}

class Derived extends PrivateOverride {
  public void f() { print("public f()"); }
} /* Output:
private f()
*///:~

//: annotations/Testable.java
package TIJ4_code.annotations;
import TIJ4_code.net.mindview.atunit.*;

public class Testable {
  public void execute() {
    System.out.println("Executing..");
  }
  @Test void testExecute() { execute(); }
} ///:~

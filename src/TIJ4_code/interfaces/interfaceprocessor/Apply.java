//: interfaces/interfaceprocessor/Apply.java
package TIJ4_code.interfaces.interfaceprocessor;
import static TIJ4_code.net.mindview.util.Print.*;

public class Apply {
  public static void process(Processor p, Object s) {
    print("Using Processor " + p.name());
    print(p.process(s));
  }
} ///:~

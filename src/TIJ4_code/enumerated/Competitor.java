//: enumerated/Competitor.java
// Switching one enum on another.
package TIJ4_code.enumerated;

public interface Competitor<T extends Competitor<T>> {
  Outcome compete(T competitor);
} ///:~

package TIJ4_code.generics;

import java.util.*;
//: generics/UseList.java
//{CompileTimeError} (Won't compile)
public class UseList<W,T> {
  void f(List<T> v) {}
  void f(List<W> v) {}
} ///:~

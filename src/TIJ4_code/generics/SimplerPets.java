package TIJ4_code.generics;
//: generics/SimplerPets.java
import TIJ4_code.typeinfo.pets.*;
import java.util.*;
import TIJ4_code.net.mindview.util.*;

public class SimplerPets {
  public static void main(String[] args) {
    Map<Person, List<? extends Pet>> petPeople = New.map();
    // Rest of the code is the same...
  }
} ///:~

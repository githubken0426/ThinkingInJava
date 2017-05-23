package th.part_15_Generic.chapter_05_InnerClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import th.part_15_Generic.chapter_04_GenericMethod._03.Generators;

public class BankTeller {
	public static void serve(Teller t,Customer c){
		System.out.println(t+" serves "+c);
	}
	public static void main(String[] args) {
		Random random=new Random(47);
		Queue<Customer> line=new LinkedList<Customer>();
		Generators.fill(line, Customer.generator(), 5);
		
		List<Teller> list=new ArrayList<Teller>();
		Generators.fill(list, Teller.generator(), 4);
		
		for (Customer c : line) {
			serve(list.get(random.nextInt(list.size())),c);
		}
	}
}

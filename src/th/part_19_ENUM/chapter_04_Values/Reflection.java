package th.part_19_ENUM.chapter_04_Values;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

import TIJ4_code.net.mindview.util.OSExecute;
/**
 * values的神秘之处
 * @author Administrator
 * 2015-12-8 下午05:24:45
 *
 */
public class Reflection {
	public static Set<String> analyze(Class<?> enumClass){
		System.out.println("------------Analyze "+enumClass+"------------");
		System.out.println("Interfaces: ");
		for(Type t:enumClass.getGenericInterfaces()){
			System.out.println(t);
		}
		System.out.println("Base:"+enumClass.getSuperclass());
		System.out.print("Methods:");
		Set<String> methods=new TreeSet<String>();
		for(Method m:enumClass.getDeclaredMethods()){
			methods.add(m.getName());
		}
		System.out.println(methods);
		return methods;
	}
	
	static String fileName="E:\\Eclipse_WS\\ThinkingInJava\\build\\classes\\th\\part_19_ENUM\\chapter_04_Values\\Explor.class";
	public static void main(String[] args) {
		/*Set<String> exploreMethods=analyze(Explor.class);
		Set<String> enumMethods=analyze(Enum.class);
		
		System.out.println("**********************");
		System.out.println("Explore.containsAll(Enum):"+exploreMethods.containsAll(enumMethods));
		System.out.println("Explore.removeAll(Enum):"+exploreMethods.removeAll(enumMethods));
		System.out.println(exploreMethods);*/
		OSExecute.command("javap "+fileName);
	}
}

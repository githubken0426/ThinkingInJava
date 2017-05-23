package th.part_11_collection.chapter_13ForeachAndIterator;
import java.util.Map;

public class EnvironmentVariable {
	public static void main(String[] args) {
		for(Map.Entry entry:System.getenv().entrySet()){
			System.out.println(entry.getKey()+"--"+entry.getValue());
		}
	}
}

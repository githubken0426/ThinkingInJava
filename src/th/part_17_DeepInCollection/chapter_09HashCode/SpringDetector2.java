package th.part_17_DeepInCollection.chapter_09HashCode;


public class SpringDetector2 {
	public static void main(String[] args) {
		try {
			SpringDetector.detectorSpring(Groundhog2.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

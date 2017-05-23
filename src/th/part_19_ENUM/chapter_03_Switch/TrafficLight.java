package th.part_19_ENUM.chapter_03_Switch;

public class TrafficLight {
	Signal color=Signal.RED;
	
	public void change(){
		switch (color){
		case RED:
			color=Signal.BLUE;
			break;
		case YELLOW:
			color=Signal.YELLOW;
			break;
		case BLUE:
			color=Signal.RED;
			break;
		}
	}
	
	public String toString(){
		return "Traffic light is "+color;
	}
	
	public static void main(String[] args) {
		TrafficLight t= new TrafficLight();
		for(int i=0;i<4;i++){
			System.out.println(t);
			t.change();
		}
			
	}
}

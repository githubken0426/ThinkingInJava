package designPattern.headfirst.chapter_06Command.anExample.client;

public class ChargeDoor {
	Light light;
	
	public void setLight(Light light) {
		this.light = light;
	}

	public void up() {
		System.out.println("door up");
	}

	public void down() {
		System.out.println("door down");
	}

	public void lighOn() {
		light.on();
	}

	public void lightOff() {
		light.off();
	}

}

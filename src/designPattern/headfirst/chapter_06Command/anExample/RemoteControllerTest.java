package designPattern.headfirst.chapter_06Command.anExample;

import designPattern.headfirst.chapter_06Command.anExample.client.ChargeDoor;
import designPattern.headfirst.chapter_06Command.anExample.client.Light;
import designPattern.headfirst.chapter_06Command.anExample.command.ChargeDoorOpenCommand;
import designPattern.headfirst.chapter_06Command.anExample.command.LightOnCommand;

public class RemoteControllerTest {
	public static void main(String[] args) {
		SimpleRemoteControl contorl=new SimpleRemoteControl();
		contorl.setCommand(new LightOnCommand(new Light()));
		contorl.buttonWasPressed();
		
		ChargeDoor door=new ChargeDoor();
		contorl.setCommand(new ChargeDoorOpenCommand(door));
		contorl.buttonWasPressed();
	}
}

package designPattern.headfirst.chapter_06Command.advanced;

import designPattern.headfirst.chapter_06Command.advanced.command.ChargeDoorDownCommand;
import designPattern.headfirst.chapter_06Command.advanced.command.ChargeDoorOpenCommand;
import designPattern.headfirst.chapter_06Command.advanced.command.Command;
import designPattern.headfirst.chapter_06Command.advanced.command.LightOffCommand;
import designPattern.headfirst.chapter_06Command.advanced.command.LightOnCommand;
import designPattern.headfirst.chapter_06Command.advanced.receiver.ChargeDoor;
import designPattern.headfirst.chapter_06Command.advanced.receiver.Light;

public class RemoteLoader {
	public static void main(String[] args) {
		RemoteControl control=new RemoteControl(3);
		
		Light roomLight=new Light("Room Light had");
		Light bathroomLight=new Light("Bathroom Light had");
		ChargeDoor roomDoor=new ChargeDoor("Room Door had");
		ChargeDoor bathroomDoor=new ChargeDoor("Bathroom Door had");
		
		Command ligthOn=new LightOnCommand(roomLight);
		Command ligthOff=new LightOffCommand(bathroomLight);
		
		Command doorOpen=new ChargeDoorOpenCommand(roomDoor);
		Command doorClose=new ChargeDoorDownCommand(bathroomDoor);
		
		control.setCommand(0, ligthOn, ligthOff);
		control.setCommand(1, doorOpen, doorClose);
		System.out.println(control);
		
		control.onButtonWasPushed(0);
		control.offButtonWasPushed(0);
		control.onButtonWasPushed(1);
		control.offButtonWasPushed(1);
	}
}

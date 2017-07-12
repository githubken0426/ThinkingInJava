package designPattern.headfirst.chapter_06Command.advanced;

import designPattern.headfirst.chapter_06Command.advanced.command.Command;
import designPattern.headfirst.chapter_06Command.advanced.command.status.CeilingFanHighCommand;
import designPattern.headfirst.chapter_06Command.advanced.command.status.CeilingFanLowCommand;
import designPattern.headfirst.chapter_06Command.advanced.command.status.CeilingFanMediumCommand;
import designPattern.headfirst.chapter_06Command.advanced.command.status.CeilingFanOffCommand;
import designPattern.headfirst.chapter_06Command.advanced.receiver.CeilingFan;

public class RemoteLoaderCeilingFan {
	public static void main(String[] args) {
		RemoteControl control=new RemoteControl(3);
		
		CeilingFan fan=new CeilingFan("天花板风扇");
		Command fanHigh=new CeilingFanHighCommand(fan);
		Command fanMediun=new CeilingFanMediumCommand(fan);
		Command fanLow=new CeilingFanLowCommand(fan);
		Command fanOff=new CeilingFanOffCommand(fan);
		
		control.setCommand(0, fanHigh, fanOff);
		control.setCommand(1, fanMediun, fanOff);
		control.setCommand(2, fanLow, fanOff);
		
		control.onButtonWasPushed(0);
		control.offButtonWasPushed(0);
		System.out.println(control);
		
		control.onButtonWasPushed(1);
		System.out.println(control);
		control.undoButtonWasPushed();
		
	}
}

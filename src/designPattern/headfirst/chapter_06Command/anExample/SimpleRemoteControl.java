package designPattern.headfirst.chapter_06Command.anExample;

import designPattern.headfirst.chapter_06Command.anExample.command.Command;

public class SimpleRemoteControl {
	Command command;
	
	public SimpleRemoteControl(){}

	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void buttonWasPressed(){
		command.execute();
	}
}

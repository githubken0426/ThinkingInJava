package designPattern.headfirst.chapter_06Command.macro.command;

import designPattern.headfirst.chapter_06Command.macro.receiver.Light;

public class LightOnCommand implements Command {
	Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}

	@Override
	public void undo() {
		light.off();
	}

}

package designPattern.headfirst.chapter_06Command.advanced.command;

import designPattern.headfirst.chapter_06Command.advanced.receiver.Light;

public class LightOnCommand implements Command {
	Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}

}

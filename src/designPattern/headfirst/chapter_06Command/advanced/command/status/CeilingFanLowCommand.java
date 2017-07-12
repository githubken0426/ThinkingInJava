package designPattern.headfirst.chapter_06Command.advanced.command.status;

import designPattern.headfirst.chapter_06Command.advanced.command.Command;
import designPattern.headfirst.chapter_06Command.advanced.receiver.CeilingFan;

public class CeilingFanLowCommand implements Command {
	CeilingFan ceilingFan;
	public CeilingFanLowCommand(CeilingFan ceilingFan){
		this.ceilingFan=ceilingFan;
	}
	int prevSpeed;
	
	@Override
	public void execute() {
		prevSpeed=ceilingFan.getSpeed();
		ceilingFan.low();
	}

	@Override
	public void undo() {
		if(prevSpeed==CeilingFan.HIGH)
			ceilingFan.high();
		else if(prevSpeed==CeilingFan.MEDIUM)
			ceilingFan.medium();
		else if(prevSpeed==CeilingFan.LOW)
			ceilingFan.low();
		else if(prevSpeed==CeilingFan.OFF)
			ceilingFan.off();
	}

}
